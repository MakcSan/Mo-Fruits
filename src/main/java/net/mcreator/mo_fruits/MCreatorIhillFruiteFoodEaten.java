package net.mcreator.mo_fruits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

@Elementsmo_fruits.ModElement.Tag
public class MCreatorIhillFruiteFoodEaten extends Elementsmo_fruits.ModElement {
	public MCreatorIhillFruiteFoodEaten(Elementsmo_fruits instance) {
		super(instance, 1);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorIhillFruiteFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity)
					.setHealth((float) (((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHealth() : -1) + 6));
	}
}
