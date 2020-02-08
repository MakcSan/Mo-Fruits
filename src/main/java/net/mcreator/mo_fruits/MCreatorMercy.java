package net.mcreator.mo_fruits;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

@Elementsmo_fruits.ModElement.Tag
public class MCreatorMercy extends Elementsmo_fruits.ModElement {
	public MCreatorMercy(Elementsmo_fruits instance) {
		super(instance, 5);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorMercy!");
			return;
		}
		World world = (World) dependencies.get("world");
		mo_fruitsVariables.MapVariables.get(world).Howmanykilled = (double) ((mo_fruitsVariables.MapVariables.get(world).Howmanykilled) / 2);
		mo_fruitsVariables.MapVariables.get(world).syncData(world);
	}

	@SubscribeEvent
	public void onPlayerRespawned(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent event) {
		Entity entity = event.player;
		java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
		dependencies.put("x", (int) entity.posX);
		dependencies.put("y", (int) entity.posY);
		dependencies.put("z", (int) entity.posZ);
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("endconquered", event.isEndConquered());
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
