package BuildcentricTweeks;

import BuildcentricTweeks.handler.RespawnEvent;
import BuildcentricTweeks.init.ModBlocks;
import BuildcentricTweeks.lib.ModInfo;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION)
public class BuildcentricTweeks 
{
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		ModBlocks.init();
		FMLCommonHandler.instance().bus().register(new RespawnEvent());
	}
}
