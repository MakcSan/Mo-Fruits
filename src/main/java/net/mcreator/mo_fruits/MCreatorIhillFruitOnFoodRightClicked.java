package net.mcreator.mo_fruits;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

@Elementsmo_fruits.ModElement.Tag
public class MCreatorIhillFruitOnFoodRightClicked extends Elementsmo_fruits.ModElement {
	public MCreatorIhillFruitOnFoodRightClicked(Elementsmo_fruits instance) {
		super(instance, 16);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorIhillFruitOnFoodRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorIhillFruitOnFoodRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorIhillFruitOnFoodRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorIhillFruitOnFoodRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorIhillFruitOnFoodRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) (entity.world.rayTraceBlocks(
				new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100,
						entity.getLook(1f).z * 100), RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
				(int) (entity.world.rayTraceBlocks(
						new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getLook(1f).x * 100,
								entity.getLook(1f).y * 100, entity.getLook(1f).z * 100), RayTraceContext.BlockMode.OUTLINE,
								RayTraceContext.FluidMode.NONE, entity)).getPos().getY()), (int) (entity.world.rayTraceBlocks(
						new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getLook(1f).x * 100,
								entity.getLook(1f).y * 100, entity.getLook(1f).z * 100), RayTraceContext.BlockMode.OUTLINE,
								RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))).getBlock() == Blocks.FARMLAND.getDefaultState()
				.getBlock())) {
			world.setBlockState(
					new BlockPos((int) (entity.world.rayTraceBlocks(
							new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getLook(1f).x * 100,
									entity.getLook(1f).y * 100, entity.getLook(1f).z * 100), RayTraceContext.BlockMode.OUTLINE,
									RayTraceContext.FluidMode.NONE, entity)).getPos().getX()), (int) ((entity.world.rayTraceBlocks(
							new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getLook(1f).x * 100,
									entity.getLook(1f).y * 100, entity.getLook(1f).z * 100), RayTraceContext.BlockMode.OUTLINE,
									RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) + 1), (int) (entity.world.rayTraceBlocks(
							new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getLook(1f).x * 100,
									entity.getLook(1f).y * 100, entity.getLook(1f).z * 100), RayTraceContext.BlockMode.OUTLINE,
									RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())), MCreatorIhillSapling.block.getDefaultState(), 3);
			world.playSound((PlayerEntity) null, x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.place")),
					SoundCategory.NEUTRAL, (float) 1, (float) (Math.random() * 2));
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(
						p -> new ItemStack(MCreatorIhillFruit.block, (int) (1)).getItem() == p.getItem(), (int) 1);
		}
	}
}
