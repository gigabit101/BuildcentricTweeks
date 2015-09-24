package BuildcentricTweeks.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.internal.EntitySpawnHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

public class HorseKillerEvent 
{
	@SubscribeEvent
	public void killHorses(LivingEvent.LivingUpdateEvent event)
	{
		EntityHorse horse;
		
		if(event.entityLiving instanceof EntityHorse)
		{
			horse = (EntityHorse) event.entityLiving;
			horse.setDead();
//			event.entityLiving.setDead();
		}
	}
}
