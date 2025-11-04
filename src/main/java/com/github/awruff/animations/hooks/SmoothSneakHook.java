package com.github.awruff.animations.hooks;

import net.minecraft.client.Minecraft;
import com.github.awruff.animations.config.OldAnimationsSettings;

public class SmoothSneakHook {
    private static float sneakingHeight;

    public static void setSneakingHeight(float sneakingHeight) {
        SmoothSneakHook.sneakingHeight = sneakingHeight;
    }

    public static float getSmoothSneak() {
        if (OldAnimationsSettings.smoothSneaking && OldAnimationsSettings.INSTANCE.enabled) {
            return sneakingHeight;
        } else {
            return Minecraft.getMinecraft().getRenderViewEntity().getEyeHeight();
        }
    }
}
