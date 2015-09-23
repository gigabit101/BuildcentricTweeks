package BuildcentricTweeks.tile;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.WorldSettings.GameType;

public class TileAdventureMode extends TileEntity
{
	public static double searchDistance = 8;
	public static double searchDistance2 = 10;
	
	@Override
	public void updateEntity() 
	{
		super.updateEntity();
		changeMode();
	}
	
	public void increaseAoe()
	{
		searchDistance++;
		searchDistance2++;
	}
	
	public void decreaseAoe()
	{
		searchDistance--;
		searchDistance2--;
	}
	
	  public EntityPlayer whatPlayerIsNearADVENTURE()
	  {
	    List<EntityPlayer> players = getPlayersForADVENTURE();
	    
	    for(EntityPlayer entplayer : players) 
	    {	
	    	EntityPlayer player2 = entplayer;
	    	
	    	if(players != null)
	    	{
	    		return player2;
	    	}
	    }
		return null;
	  }
	  
	  public EntityPlayer whatPlayerIsNearSURVIVAL()
	  {
	    List<EntityPlayer> players = getPlayersForSURVIVAL();
	    
	    for(EntityPlayer entplayer : players) 
	    {	
	    	EntityPlayer player2 = entplayer;
	    	
	    	if(players != null)
	    	{
	    		return player2;
	    	}
	    }
		return null;
	  }
	
	List<EntityPlayer> getPlayersForADVENTURE() 
	{
		return worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(xCoord - searchDistance, yCoord - searchDistance, zCoord - searchDistance,
				xCoord + searchDistance, yCoord + searchDistance, zCoord + searchDistance));
	}
	
	List<EntityPlayer> getPlayersForSURVIVAL() 
	{
		return worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(xCoord - searchDistance2, yCoord - searchDistance2,
				zCoord - searchDistance2, xCoord + searchDistance2, yCoord + searchDistance2, zCoord + searchDistance2));
	}
	//TODO Clean this up 
	public void changeMode()
	{
		if (whatPlayerIsNearADVENTURE() != null && whatPlayerIsNearADVENTURE().capabilities.allowEdit == true)
		{
			whatPlayerIsNearADVENTURE().setGameType(GameType.ADVENTURE);
		}
		else if (whatPlayerIsNearSURVIVAL() != null  && whatPlayerIsNearSURVIVAL().capabilities.allowEdit == false)
		{
			if(whatPlayerIsNearSURVIVAL() != whatPlayerIsNearADVENTURE())
				whatPlayerIsNearSURVIVAL().setGameType(GameType.SURVIVAL);
		}
	}
}
