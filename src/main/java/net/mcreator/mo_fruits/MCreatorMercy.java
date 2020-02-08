package net.mcreator.mo_fruits;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

@Elementsmo_fruits.ModElement.Tag
public class MCreatorMercy extends Elementsmo_fruits.ModElement {
	public MCreatorMercy(Elementsmo_fruits instance) {
		super(instance, 5);
		MinecraftForge.EVENT_BUS.register(this);
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
	public void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		Entity entity = event.getPlayer();
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
}
