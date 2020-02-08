package net.mcreator.mo_fruits;

import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.command.Commands;
import net.minecraft.command.CommandSource;

import java.util.HashMap;
import java.util.Arrays;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.arguments.StringArgumentType;

@Elementsmo_fruits.ModElement.Tag
public class MCreatorJugDebug extends Elementsmo_fruits.ModElement {
	public MCreatorJugDebug(Elementsmo_fruits instance) {
		super(instance, 7);
	}

	@Override
	public void serverLoad(FMLServerStartingEvent event) {
		event.getCommandDispatcher().register(customCommand());
	}

	private static LiteralArgumentBuilder<CommandSource> customCommand() {
		return LiteralArgumentBuilder.<CommandSource> literal("jugdebug")
				.then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(MCreatorJugDebug::execute))
				.executes(MCreatorJugDebug::execute);
	}

	private static int execute(CommandContext<CommandSource> ctx) {
		Entity entity = ctx.getSource().getEntity();
		if (entity != null) {
			int x = entity.getPosition().getX();
			int y = entity.getPosition().getY();
			int z = entity.getPosition().getZ();
			World world = entity.world;
			HashMap<String, String> cmdparams = new HashMap<>();
			int[] index = {0};
			Arrays.stream(ctx.getInput().split("\\s+")).forEach(param -> {
				cmdparams.put(Integer.toString(index[0]), param);
				index[0]++;
			});
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				MCreatorJugDebugCommandExecuted.executeProcedure($_dependencies);
			}
		}
		return 0;
	}
}
