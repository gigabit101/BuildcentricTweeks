package BuildcentricTweeks;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "BuildcentricTweeks", name = "BuildcentricTweeks", version = "1.0.0", acceptableRemoteVersions = "*")
public class BuildcentricTweeks 
{
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(new RespawnEvent());
	}
}
