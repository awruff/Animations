package com.github.awruff.animations.mixins;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.entity.item.EntityItem;
import com.github.awruff.animations.Animations;
import com.github.awruff.animations.config.OldAnimationsSettings;
import com.github.awruff.animations.hooks.DroppedItemHook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RenderEntityItem.class)
public abstract class RenderEntityItemMixin extends Render<EntityItem> {

    @Unique
    private boolean overflowanimations$isGui3d;

    protected RenderEntityItemMixin(RenderManager renderManager) {
        super(renderManager);
    }

    @Inject(
            method = "doRender(Lnet/minecraft/entity/item/EntityItem;DDDFF)V",
            at = @At(
                    value = "HEAD"
            )
    )
    private void overflowAnimations$setHook(EntityItem entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo ci) {
        DroppedItemHook.isItemDropped = true;
    }

    @Inject(
            method = "doRender(Lnet/minecraft/entity/item/EntityItem;DDDFF)V",
            at = @At(
                    value = "TAIL"
            )
    )
    private void overflowAnimations$setHook2(EntityItem entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo ci) {
        DroppedItemHook.isItemDropped = false;
    }

    @ModifyVariable(method = "func_177077_a", at = @At("STORE"), ordinal = 0)
    private boolean overflowAnimations$hookGui3d(boolean isGui3d) {
        overflowanimations$isGui3d = isGui3d;
        return isGui3d;
    }

    @ModifyArg(method = "func_177077_a", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;rotate(FFFF)V"), index = 0)
    private float overflowAnimations$apply2dItem(float angle) {
        if (!overflowanimations$isGui3d && OldAnimationsSettings.itemSprites && OldAnimationsSettings.INSTANCE.enabled && !Animations.isItemPhysics) {
            return 180.0F - renderManager.playerViewY;

        }
        return angle;
    }

    @Inject(method = "func_177077_a", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;rotate(FFFF)V", shift = At.Shift.AFTER))
    private void overflowAnimations$fix2dRotation(EntityItem itemIn, double p_177077_2_, double p_177077_4_, double p_177077_6_, float p_177077_8_, IBakedModel p_177077_9_, CallbackInfoReturnable<Integer> cir) {
        if (!overflowanimations$isGui3d && OldAnimationsSettings.itemSprites && OldAnimationsSettings.INSTANCE.enabled && OldAnimationsSettings.rotationFix && !Animations.isItemPhysics) {
            GlStateManager.rotate(-renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        }
    }

}
