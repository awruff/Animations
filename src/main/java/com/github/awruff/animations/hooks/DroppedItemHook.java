package com.github.awruff.animations.hooks;

import com.github.awruff.animations.Animations;

public class DroppedItemHook {
    public static boolean isItemDropped;

    public static boolean isItemPhysicsAndEntityDropped() {
        return Animations.isItemPhysics && isItemDropped;
    }
}