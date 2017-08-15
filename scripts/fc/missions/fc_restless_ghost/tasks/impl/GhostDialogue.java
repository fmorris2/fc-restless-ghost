package scripts.fc.missions.fc_restless_ghost.tasks.impl;

import org.tribot.api2007.Equipment;
import org.tribot.api2007.Inventory;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.items.FCItem;
import scripts.fc.api.items.ItemUtils;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.missions.fc_restless_ghost.FCRestlessGhost;
import scripts.fc.missions.fc_restless_ghost.data.RGSettings;
import scripts.fc.missions.fc_restless_ghost.tasks.CoffinTask;

public class GhostDialogue extends CoffinTask implements ItemsRequiredTask
{
	private static final long serialVersionUID = 1L;
	
	@Override 
	public boolean execute()
	{
		if(Inventory.getCount(FCRestlessGhost.AMULET) > 0 && Equipment.getCount(FCRestlessGhost.AMULET) == 0)
			ItemUtils.equipItem(FCRestlessGhost.AMULET);
		
		return super.execute();
	}

	@Override
	protected EntityInteraction getInteraction()
	{
		return new NpcDialogue("Talk-to", "Restless ghost", 10, 0,0);
	}

	@Override
	public boolean shouldExecute()
	{
		return RGSettings.GHOST_DIALOGUE.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Ghost Dialogue";
	}

	@Override
	public FCItem[] getRequiredItems()
	{
		return new FCItem[]{new FCItem(1, false, FCRestlessGhost.AMULET)};
	}

}
