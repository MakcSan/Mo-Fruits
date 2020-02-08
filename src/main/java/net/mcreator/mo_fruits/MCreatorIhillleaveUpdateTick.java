package net.mcreator.mo_fruits;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

@Elementsmo_fruits.ModElement.Tag
public class MCreatorIhillleaveUpdateTick extends Elementsmo_fruits.ModElement {
	public MCreatorIhillleaveUpdateTick(Elementsmo_fruits instance) {
		super(instance, 13);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorIhillleaveUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorIhillleaveUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorIhillleaveUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorIhillleaveUpdateTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double RandomTick = 0;
		RandomTick = (double) (Math.random() * 2730);
		if (((RandomTick) == 1)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), MCreatorIhillleavefruited.block.getDefaultState(), 3);
		}
	}
}
