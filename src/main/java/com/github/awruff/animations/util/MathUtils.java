package com.github.awruff.animations.util;

public class MathUtils {

    public static float interp(float previous, float current, float partialTick) {
        return previous + (current - previous) * partialTick;
    }

}
