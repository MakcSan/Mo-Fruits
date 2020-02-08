package net.mcreator.mo_fruits;

import net.minecraftforge.common.DimensionManager;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.world.Teleporter;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
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
		if ((!(world.getDifficulty() == EnumDifficulty.PEACEFUL))) {
			Chance = (double) (Math.random() * (50 + (mo_fruitsVariables.MapVariables.get(world).Howmanykilled)));
			if (((Chance) <= 50)) {
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).getFoodStats().setFoodLevel((int) 20);
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.LUCK, (int) 10280, (int) 5, (false), (false)));
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, (int) 20560, (int) 10, (false), (false)));
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, (int) 20560, (int) 2, (false), (false)));
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, (int) 1, (int) 10, (false), (false)));
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SATURATION, (int) 10280, (int) 1, (false), (false)));
			}
			if (((Chance) > 50)) {
				if (!entity.world.isRemote && !entity.isRiding() && !entity.isBeingRidden() && entity instanceof EntityPlayerMP) {
					int dimensionID = -1;
					class TeleporterDirect extends Teleporter {
						public TeleporterDirect(WorldServer worldserver) {
							super(worldserver);
						}

						@Override
						public void placeInPortal(Entity entity, float yawrotation) {
						}

						@Override
						public boolean placeInExistingPortal(Entity entity, float yawrotation) {
							return true;
						}

						@Override
						public boolean makePortal(Entity entity) {
							return true;
						}
					}
					EntityPlayerMP _player = (EntityPlayerMP) entity;
					_player.mcServer.getPlayerList().transferPlayerToDimension(_player, dimensionID, new TeleporterDirect(_player.getServerWorld()));
					_player.connection.setPlayerLocation(DimensionManager.getWorld(dimensionID).getSpawnPoint().getX(),
							DimensionManager.getWorld(dimensionID).getSpawnPoint().getY() + 1, DimensionManager.getWorld(dimensionID).getSpawnPoint()
									.getZ(), _player.rotationYaw, _player.rotationPitch);
				}
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).clearActivePotions();
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.WITHER, (int) 102800, (int) 0, (false), (false)));
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).getFoodStats().setFoodLevel((int) 0);
				world.playSound((EntityPlayer) null, (entity.posX), (entity.posY), (entity.posZ),
						(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("ambient.cave")),
						SoundCategory.NEUTRAL, (float) 1, (float) 0);
			}
		}
	}
}
