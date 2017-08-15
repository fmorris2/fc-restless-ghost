package scripts.fc.missions.fc_restless_ghost.tasks.impl;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.missions.fc_restless_ghost.data.RGSettings;

public class RecoverAmulet extends FatherUrhneyDialogue
{
	private static final long serialVersionUID = 1L;
	
	@Override
	public boolean shouldExecute()
	{
		return RGSettings.RECOVER_AMULET.isValid();
	}
	
	@Override
	public String getStatus()
	{
		return "Recover amulet";
	}
	
	@Override
	protected EntityInteraction getInteraction()
	{
		return new NpcDialogue("Talk-to", "Father Urhney", 10, 2);
	}
}
