package net.mcreator.mo_fruits;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;

@Elementsmo_fruits.ModElement.Tag
public class MCreatorIhillleavefruitedOnBlockRightClicked extends Elementsmo_fruits.ModElement {
	public MCreatorIhillleavefruitedOnBlockRightClicked(Elementsmo_fruits instance) {
		super(instance, 12);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorIhillleavefruitedOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorIhillleavefruitedOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorIhillleavefruitedOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorIhillleavefruitedOnBlockRightClicked!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double fruitsize = 0;
		world.playSound((PlayerEntity) null, x, y, z,
				(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mo_fruits:pickfruit")),
				SoundCategory.NEUTRAL, (float) 1, (float) (Math.random() * 2));
		fruitsize = (double) (Math.random() * 20);
		if (!world.isRemote) {
			ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorIhillFruit.block, (int) (1)));
			entityToSpawn.setPickupDelay(10);
			world.addEntity(entityToSpawn);
		}
		if (((fruitsize) <= 10)) {
			if (!world.isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorIhillFruit.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.addEntity(entityToSpawn);
			}
			fruitsize = (double) (Math.random() * 20);
			if (((fruitsize) <= 10)) {
				if (!world.isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorIhillFruit.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
			}
		}
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), MCreatorIhillleave.block.getDefaultState(), 3);
	}
}
