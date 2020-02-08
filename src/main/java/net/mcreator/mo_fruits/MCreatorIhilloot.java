package net.mcreator.mo_fruits;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.util.ResourceLocation;

@Elementsmo_fruits.ModElement.Tag
public class MCreatorIhilloot extends Elementsmo_fruits.ModElement {
	public MCreatorIhilloot(Elementsmo_fruits instance) {
		super(instance, 9);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		LootTableList.register(new ResourceLocation("minecraft", "chests/abandoned_mineshaft"));
	}
}
