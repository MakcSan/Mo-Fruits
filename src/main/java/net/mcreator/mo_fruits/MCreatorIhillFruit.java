package net.mcreator.mo_fruits;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

@Elementsmo_fruits.ModElement.Tag
public class MCreatorIhillFruit extends Elementsmo_fruits.ModElement {
	@GameRegistry.ObjectHolder("mo_fruits:ihillfruit")
	public static final Item block = null;

	public MCreatorIhillFruit(Elementsmo_fruits instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("mo_fruits:ihillfruit", "inventory"));
	}

	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(1, 0.7f, true);
			setUnlocalizedName("ihillfruit");
			setRegistryName("ihillfruit");
			setAlwaysEdible();
			setCreativeTab(MCreatorMoreFruites.tab);
			setMaxStackSize(64);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}

		@Override
		protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entity) {
			super.onFoodEaten(itemStack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				MCreatorIhillFruiteFoodEaten.executeProcedure($_dependencies);
			}
		}
	}
}
