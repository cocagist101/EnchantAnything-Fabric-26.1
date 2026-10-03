package com.github.shiftjis.enchantanything.mixin;

import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
	/** Every non-empty stack can be placed in the enchanting table. */
	@Inject(method = "isEnchantable", at = @At("HEAD"), cancellable = true)
	private void enchantanything$isEnchantable(CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(!((ItemStack) (Object) this).isEmpty());
	}
}
