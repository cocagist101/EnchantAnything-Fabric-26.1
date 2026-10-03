package com.github.shiftjis.enchantanything;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantable;

public class EnchantAnythingFabric implements ModInitializer {
	public static final String MOD_ID = "enchantanything";

	@Override
	public void onInitialize() {
		// Since 1.21.2 an item is only enchantable at the enchanting table if it carries
		// the "enchantable" data component. Give it to every item that doesn't have one.
		DefaultItemComponentEvents.MODIFY.register(context ->
			context.modify(
				item -> item != Items.AIR && !item.components().has(DataComponents.ENCHANTABLE),
				(builder, item) -> builder.set(DataComponents.ENCHANTABLE, new Enchantable(1))
			)
		);
	}
}
