package BuildcentricTweeks.block;

import java.util.List;

import BuildcentricTweeks.BTCreativeTab;
import BuildcentricTweeks.lib.ModInfo;
import BuildcentricTweeks.tile.TileAdventureMode;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import tv.twitch.chat.ChatMessage;


public class BlockAdventureMode extends BlockContainer
{
	public BlockAdventureMode(Material material) 
	{
		super(material);
		setCreativeTab(BTCreativeTab.instance);
		setHardness(2.0F);
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) 
    {
        for (int meta = 0; meta < 2; meta++) 
        {
            list.add(new ItemStack(item, 1, meta));
        }
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,  EntityPlayer player, int side, float hitX, float hitY, float hitZ) 
    {
       TileEntity tile = world.getTileEntity(x, y, z);
    	
       if (!player.isSneaking())
       {
    	   ((TileAdventureMode)tile).increaseAoe();
    	   	player.addChatMessage(new ChatComponentText(" " + ((TileAdventureMode)tile).searchDistance2));
       }
       else if(player.isSneaking())
       {
    	   ((TileAdventureMode)tile).decreaseAoe();
    	   	player.addChatMessage(new ChatComponentText(" " + ((TileAdventureMode)tile).searchDistance2));
       }
        return true;
    }
	
	@Override
	public void registerBlockIcons(IIconRegister icon) 
	{
		blockIcon = icon.registerIcon(ModInfo.MOD_ID.toLowerCase() + ":" + getUnlocalizedName().toString().substring(5));
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) 
	{
		return new TileAdventureMode();
	}
	
	@Override
	protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {}
}
