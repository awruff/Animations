package com.github.awruff.animations.mixins;

import net.minecraft.client.renderer.entity.RenderFish;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import org.lwjgl.opengl.GL11;
import com.github.awruff.animations.config.OldAnimationsSettings;
import com.github.awruff.animations.hooks.SmoothSneakHook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RenderFish.class, priority = 2000)
public class RenderFishMixin {
    @ModifyConstant(method = "doRender(Lnet/minecraft/entity/projectile/EntityFishHook;DDDFF)V",
            constant = @Constant(doubleValue = 0.8D)
    )
    public double overflowAnimations$moveLinePosition(double constant) {
        return overflowAnimations$moveVecLine(constant);
    }

    @Redirect(method = "doRender(Lnet/minecraft/entity/projectile/EntityFishHook;DDDFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/EntityPlayer;getEyeHeight()F"))
    public float overflowAnimations$modifyEyeHeight(EntityPlayer instance) {
        return SmoothSneakHook.getSmoothSneak();
    }

    @Inject(method = "doRender(Lnet/minecraft/entity/projectile/EntityFishHook;DDDFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/WorldRenderer;begin(ILnet/minecraft/client/renderer/vertex/VertexFormat;)V", ordinal = 1))
    private void overflowAnimations$modifyLineThickness(EntityFishHook entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo ci) {
        if (!OldAnimationsSettings.INSTANCE.enabled) {
            return;
        }
        GL11.glLineWidth(1.0f + OldAnimationsSettings.INSTANCE.rodThickness);
    }

    @Unique
    private double overflowAnimations$moveVecLine(double constant) {
        return OldAnimationsSettings.fishingStick && OldAnimationsSettings.INSTANCE.enabled ? 0.85D : constant;
    }

}
