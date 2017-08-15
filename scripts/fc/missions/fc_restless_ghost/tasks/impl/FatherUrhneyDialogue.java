package scripts.fc.missions.fc_restless_ghost.tasks.impl;

import java.util.function.BooleanSupplier;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.framework.task.BasicInteractionTask;
import scripts.fc.framework.task.SpaceRequiredTask;
import scripts.fc.missions.fc_restless_ghost.data.RGSettings;

public class FatherUrhneyDialogue extends BasicInteractionTask implements SpaceRequiredTask
{
	private static final long serialVersionUID = 1L;

	@Override
	protected Positionable getPosition()
	{
		return new RSTile(3147, 3175, 0);
	}

	@Override
	protected int getRadius()
	{
		return 6;
	}

	@Override
	protected EntityInteraction getInteraction()
	{
		return new NpcDialogue("Talk-to", "Father Urhney", 10, 1,0);
	}

	@Override
	protected BooleanSupplier getWaitCondition()
	{
		return null;
	}

	@Override
	protected int getWaitTimeout()
	{
		return 0;
	}

	@Override
	public boolean shouldExecute()
	{
		return RGSettings.FATHER_URHNEY_DIALOGUE.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Father Urhney dialogue";
	}

	@Override
	public int getSpaceRequired()
	{
		return 1;
	}
}
