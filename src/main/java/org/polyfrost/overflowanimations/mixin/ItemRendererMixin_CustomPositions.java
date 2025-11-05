package org.polyfrost.overflowanimations.mixin;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import org.polyfrost.overflowanimations.config.OldAnimationsSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin_CustomPositions {
    @ModifyArg(method = "renderItemInFirstPerson", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/ItemRenderer;transformFirstPersonItem(FF)V", ordinal = 2), index = 0)
    private float overflowAnimations$modifyBlockEquip(float original) {
        return OldAnimationsSettings.lunarBlockhit && OldAnimationsSettings.INSTANCE.enabled ? 0.2F : original;
    }

    @ModifyConstant(method = "performDrinking", constant = @Constant(floatValue = 0.6f))
    public float overflowAnimations$lunarDrinking(float original) {
        return OldAnimationsSettings.lunarPositions && OldAnimationsSettings.INSTANCE.enabled ? 0.66f : original;
    }

    @ModifyConstant(method = "performDrinking", constant = @Constant(floatValue = 10.0f))
    public float overflowAnimations$lunarDrinking2(float original) {
        return OldAnimationsSettings.lunarPositions && OldAnimationsSettings.INSTANCE.enabled ? 5.0f : original;
    }

    @ModifyConstant(method = "performDrinking", constant = @Constant(floatValue = 30.0f))
    public float overflowAnimations$lunarDrinking3(float original) {
        return OldAnimationsSettings.lunarPositions && OldAnimationsSettings.INSTANCE.enabled ? 28.0f : original;
    }

    @Inject(method = "doBowTransformations", at = @At("HEAD"))
    public void overflowAnimations$lunarBowPosition(float partialTicks, AbstractClientPlayer clientPlayer, CallbackInfo ci) {
        if (OldAnimationsSettings.lunarPositions && OldAnimationsSettings.INSTANCE.enabled) {
            GlStateManager.translate(-0.2D, 0.0D, -0.175D);
            GlStateManager.rotate(1.0F, 0.0F, 0.0F, -1.25F);
        }
    }
}
