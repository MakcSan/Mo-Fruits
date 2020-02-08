package net.mcreator.mo_fruits;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

@Elementsmo_fruits.ModElement.Tag
public class MCreatorSinsCommandExecuted extends Elementsmo_fruits.ModElement {
	public MCreatorSinsCommandExecuted(Elementsmo_fruits instance) {
		super(instance, 6);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorSinsCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorSinsCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayer && !world.isRemote) {
			((EntityPlayer) entity).sendStatusMessage(new TextComponentString(
					(((mo_fruitsVariables.MapVariables.get(world).Howmanykilled)) + "" + ("Sins"))), (true));
		}
	}
}
