package BuildcentricTweeks;

import BuildcentricTweeks.lib.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BTCreativeTab extends CreativeTabs
{
	public static BTCreativeTab instance = new BTCreativeTab();

	public BTCreativeTab() 
	{
		super(ModInfo.MOD_ID);
	}

	@Override
	public Item getTabIconItem() 
	{
		return Items.apple;
	}
}
