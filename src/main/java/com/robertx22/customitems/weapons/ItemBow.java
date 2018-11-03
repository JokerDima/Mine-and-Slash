package com.robertx22.customitems.weapons;

import java.util.HashMap;

import com.robertx22.customitems.bases.BaseBow;
import com.robertx22.customitems.bases.IWeapon;
import com.robertx22.database.lists.Rarities;
import com.robertx22.uncommon.utilityclasses.RegisterUtils;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ItemBow extends BaseBow implements IWeapon {
	public static HashMap<Integer, Item> Items = new HashMap<Integer, Item>();

	public ItemBow(int rarity, HashMap<Integer, Item> map) {
		super(rarity, map);

	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		Rarities.Items.forEach((x) -> Items.put(x.Rank(), new ItemBow(x.Rank(), Items)));
		Items.values().forEach((x) -> event.getRegistry().register(x));
	}

	@SubscribeEvent
	public static void onModelRegistry(ModelRegistryEvent event) {
		Items.values().forEach((x) -> RegisterUtils.registerRender(x));
	}

	@Override
	public String Name() {
		return "Bow";
	}

	@Override
	public int GetEnergyCost() {
		return 9;
	}

}