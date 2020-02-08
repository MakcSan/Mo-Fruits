package net.mcreator.mo_fruits;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.Difficulty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

@Elementsmo_fruits.ModElement.Tag
public class MCreatorFruitOfjudgementFoodEaten extends Elementsmo_fruits.ModElement {
	public MCreatorFruitOfjudgementFoodEaten(Elementsmo_fruits instance) {
		super(instance, 4);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorFruitOfjudgementFoodEaten!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorFruitOfjudgementFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		double Chance = 0;
		Chance = (double) (Math.random() * (50 + (mo_fruitsVariables.MapVariables.get(world).Howmanykilled)));
		if (((Chance) <= 50)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getFoodStats().setFoodLevel((int) 20);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LUCK, (int) 10280, (int) 5, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, (int) 20560, (int) 10, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 20560, (int) 2, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 1, (int) 10, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SATURATION, (int) 10280, (int) 1, (false), (false)));
		}
		if ((!(world.getDifficulty() == Difficulty.PEACEFUL))) {
			if (((Chance) > 50)) {
				if (!entity.world.isRemote && entity instanceof ServerPlayerEntity) {
					DimensionType destinationType = DimensionType.THE_NETHER;
					ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, (ServerPlayerEntity) entity, true, "field_184851_cj");
					ServerWorld nextWorld = entity.getServer().getWorld(destinationType);
					((ServerPlayerEntity) entity).connection.sendPacket(new SChangeGameStatePacket(4, 0));
					((ServerPlayerEntity) entity).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
							nextWorld.getSpawnPoint().getZ(), entity.rotationYaw, entity.rotationPitch);
					((ServerPlayerEntity) entity).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) entity).abilities));
					for (EffectInstance effectinstance : ((ServerPlayerEntity) entity).getActivePotionEffects()) {
						((ServerPlayerEntity) entity).connection.sendPacket(new SPlayEntityEffectPacket(entity.getEntityId(), effectinstance));
					}
					((ServerPlayerEntity) entity).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).clearActivePotions();
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 102800, (int) 0, (false), (false)));
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getFoodStats().setFoodLevel((int) 0);
				world.playSound((PlayerEntity) null, (entity.posX), (entity.posY), (entity.posZ),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")),
						SoundCategory.NEUTRAL, (float) 1, (float) 0);
			}
		}
	}
}
