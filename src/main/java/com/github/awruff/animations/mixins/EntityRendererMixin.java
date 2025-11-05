package com.github.awruff.animations.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.Entity;
import com.github.awruff.animations.config.OldAnimationsSettings;
import com.github.awruff.animations.hooks.DebugCrosshairHook;
import com.github.awruff.animations.hooks.DebugOverlayHook;
import com.github.awruff.animations.hooks.SmoothSneakHook;
import com.github.awruff.animations.util.MathUtils;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = EntityRenderer.class, priority = 1001)
public abstract class EntityRendererMixin {

    @Unique
    @Final
    private final Minecraft overflowAnimations$mc = Minecraft.getMinecraft();
    @Shadow
    private Minecraft mc;
    @Unique
    private float overflow$height;
    @Unique
    private float overflow$previousHeight;

    @Shadow
    public abstract void setupOverlayRendering();

    @Inject(method = "setupCameraTransform", at = @At("HEAD"))
    protected void overflowAnimations$getInterpolatedEyeHeight(float partialTicks, int pass, CallbackInfo ci) {
        if (!OldAnimationsSettings.INSTANCE.enabled) {
            return;
        }
        float interpEyeHeight = MathUtils.interp(overflow$previousHeight, overflow$height, partialTicks);
        SmoothSneakHook.setSneakingHeight(interpEyeHeight);
    }

    @ModifyVariable(method = "orientCamera", at = @At(value = "STORE", ordinal = 0), index = 3)
    public float overflowAnimations$modifyEyeHeight(float eyeHeight) {
        return SmoothSneakHook.getSmoothSneak();
    }

    @ModifyArg(method = "renderWorldDirections", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;translate(FFF)V"), index = 1)
    public float overflowAnimations$syncCrossHair(float x) {
        return SmoothSneakHook.getSmoothSneak();
    }

    @Inject(method = "renderWorldDirections", at = @At("HEAD"), cancellable = true)
    public void overflowAnimations$renderCrosshair(float partialTicks, CallbackInfo ci) {
        if ((OldAnimationsSettings.INSTANCE.debugCrosshairMode != 1) && OldAnimationsSettings.INSTANCE.enabled)
            ci.cancel();
    }

    @Inject(method = "updateRenderer", at = @At("HEAD"))
    private void overflowAnimations$interpolateHeight(CallbackInfo ci) {
        if (!OldAnimationsSettings.INSTANCE.enabled) {
            return;
        }
        Entity entity = overflowAnimations$mc.getRenderViewEntity();
        float eyeHeight = entity.getEyeHeight();
        overflow$previousHeight = overflow$height;

        if (OldAnimationsSettings.longerUnsneak) {
            if (eyeHeight < overflow$height)
                overflow$height = eyeHeight;
            else
                overflow$height += (eyeHeight - overflow$height) * 0.5f;
        } else {
            overflow$height = eyeHeight;
        }
        DebugOverlayHook.setOverflowEyeHeight(overflow$height);
    }

    @Inject(method = "hurtCameraEffect", at = @At("HEAD"), cancellable = true)
    public void overflowAnimations$cancelHurtCamera(float partialTicks, CallbackInfo ci) {
        if (OldAnimationsSettings.noHurtCam && OldAnimationsSettings.INSTANCE.enabled)
            ci.cancel();
    }

    @Inject(method = "updateCameraAndRender", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiIngame;renderGameOverlay(F)V"))
    private void draw(float partialTicks, long nanoTime, CallbackInfo ci) {
        if (OldAnimationsSettings.INSTANCE.debugCrosshairMode == 2 &&
                OldAnimationsSettings.INSTANCE.enabled && mc.gameSettings.showDebugInfo && !mc.thePlayer.hasReducedDebug() &&
                !mc.gameSettings.reducedDebugInfo) {
            setupOverlayRendering();
            DebugCrosshairHook.renderDirections(partialTicks, mc);
        }
    }

}
