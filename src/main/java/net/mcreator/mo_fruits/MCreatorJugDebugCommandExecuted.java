package net.mcreator.mo_fruits;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

@Elementsmo_fruits.ModElement.Tag
public class MCreatorJugDebugCommandExecuted extends Elementsmo_fruits.ModElement {
	public MCreatorJugDebugCommandExecuted(Elementsmo_fruits instance) {
		super(instance, 7);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorJugDebugCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorJugDebugCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if ((entity.canUseCommand((int) 2, ""))) {
			mo_fruitsVariables.MapVariables.get(world).Howmanykilled = (double) 300;
			mo_fruitsVariables.MapVariables.get(world).syncData(world);
		}
	}
}
