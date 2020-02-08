package net.mcreator.mo_fruits;

import net.minecraft.entity.LivingEntity;
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
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 6));
	}
}
