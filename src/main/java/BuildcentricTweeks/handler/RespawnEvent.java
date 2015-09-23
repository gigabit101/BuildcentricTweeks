package BuildcentricTweeks.handler;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class RespawnEvent
{
	public static final RespawnEvent instancemain = new RespawnEvent();
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onRespawnEvent(PlayerRespawnEvent event) 
	{
		if (event.isCancelable())
			return;
		
		if(!event.player.capabilities.allowEdit)
		{
			event.player.setGameType(GameType.SURVIVAL);
		}
	}
}
