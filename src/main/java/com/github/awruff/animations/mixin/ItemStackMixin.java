package com.github.awruff.animations.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import com.github.awruff.animations.config.OldAnimationsSettings;
import com.github.awruff.animations.mixin.interfaces.ItemRendererInvoker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Inject(method = "getIsItemStackEqual", at = @At("RETURN"), cancellable = true)
    public void overflowAnimations$modifyReequip(ItemStack p_179549_1_, CallbackInfoReturnable<Boolean> cir) {
        Minecraft mc = Minecraft.getMinecraft();
        if (OldAnimationsSettings.INSTANCE.itemSwitchMode == 1 && OldAnimationsSettings.INSTANCE.enabled) {
            int currentItem = mc.thePlayer.inventory.currentItem;
            int equippedProgress = ((ItemRendererInvoker) mc.getItemRenderer()).getEquippedItemSlot();
            cir.setReturnValue(cir.getReturnValue() && equippedProgress == currentItem);
        }
    }

}
