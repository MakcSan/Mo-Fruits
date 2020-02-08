package net.mcreator.mo_fruits;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

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
		double GrowRepresent = 0;
		RandomTick = (double) (Math.random() * 45000);
		if (((RandomTick) <= 75)) {
			GrowRepresent = (double) ((RandomTick) + 1);
		}
		if (((GrowRepresent) >= 23)) {
			{
				TileEntity tileEntity = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (tileEntity != null)
					tileEntity.getTileData().putDouble("Age", ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) z), "Age")) + 1));
			}
		}
		if (((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Age")) >= 5)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), MCreatorIhillleavefruited.block.getDefaultState(), 3);
		}
	}
}
