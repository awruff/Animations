package com.github.awruff.animations.mixin;

import net.minecraft.client.network.NetHandlerPlayClient;
import com.github.awruff.animations.config.OldAnimationsSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(NetHandlerPlayClient.class)
public abstract class NetHandlerPlayClientMixin {

    @ModifyConstant(method = "handleSpawnExperienceOrb", constant = @Constant(doubleValue = 32.0D))
    private double overflowAnimations$oldXPOrbs(double original) {
        return OldAnimationsSettings.oldXPOrbs && OldAnimationsSettings.INSTANCE.enabled ? original / 32.0D : original;
    }

}
