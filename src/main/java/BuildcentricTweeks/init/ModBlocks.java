package BuildcentricTweeks.init;

import BuildcentricTweeks.block.BlockAdventureMode;
import BuildcentricTweeks.tile.TileAdventureMode;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks 
{
	public static Block adventureMode;
	
	public static void init()
	{
		adventureMode = new BlockAdventureMode(Material.iron).setBlockName("BlockAdventureMode");
		GameRegistry.registerBlock(adventureMode, adventureMode.getUnlocalizedName());
		GameRegistry.registerTileEntity(TileAdventureMode.class, "tileAdventureMode");
	}
}
