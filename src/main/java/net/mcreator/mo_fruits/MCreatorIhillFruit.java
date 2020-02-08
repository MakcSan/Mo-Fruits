package net.mcreator.mo_fruits;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

@Elementsmo_fruits.ModElement.Tag
public class MCreatorIhillFruit extends Elementsmo_fruits.ModElement {
	@ObjectHolder("mo_fruits:ihillfruit")
	public static final Item block = null;

	public MCreatorIhillFruit(Elementsmo_fruits instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(MCreatorMoreFruites.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(1).saturation(0.7f).setAlwaysEdible().meat().build()));
			setRegistryName("ihillfruit");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				MCreatorIhillFruiteFoodEaten.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
