package com.github.shiftjis.enchantanything.mixin;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public abstract class EnchantmentMixin {
	/** Any enchantment can be applied to any item (anvil, books, commands). */
	@Inject(method = "isSupportedItem", at = @At("HEAD"), cancellable = true)
	private void enchantanything$isSupportedItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(true);
	}

	/** Any enchantment may roll on any item in the enchanting table. */
	@Inject(method = "isPrimaryItem", at = @At("HEAD"), cancellable = true)
	private void enchantanything$isPrimaryItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(true);
	}

	/** Conflicting enchantments (Sharpness + Smite, Fortune + Silk Touch, ...) can coexist. */
	@Inject(method = "areCompatible", at = @At("HEAD"), cancellable = true)
	private static void enchantanything$areCompatible(Holder<Enchantment> first, Holder<Enchantment> second, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(true);
	}
}
