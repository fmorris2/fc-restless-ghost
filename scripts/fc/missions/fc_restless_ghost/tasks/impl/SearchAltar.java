package scripts.fc.missions.fc_restless_ghost.tasks.impl;

import java.util.function.BooleanSupplier;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.framework.task.BasicInteractionTask;
import scripts.fc.framework.task.SpaceRequiredTask;
import scripts.fc.missions.fc_restless_ghost.FCRestlessGhost;
import scripts.fc.missions.fc_restless_ghost.data.RGSettings;

public class SearchAltar extends BasicInteractionTask implements SpaceRequiredTask
{
	private static final long serialVersionUID = 1L;

	@Override
	protected Positionable getPosition()
	{
		return new RSTile(3118, 9566, 0);
	}

	@Override
	protected int getRadius()
	{
		return 7;
	}

	@Override
	protected EntityInteraction getInteraction()
	{
		return new ClickObject("Search", "Altar", getRadius());
	}

	@Override
	protected BooleanSupplier getWaitCondition()
	{
		return () -> Inventory.getCount(FCRestlessGhost.SKULL) > 0;
	}

	@Override
	protected int getWaitTimeout()
	{
		return 4500;
	}

	@Override
	public boolean shouldExecute()
	{
		return RGSettings.SEARCH_ALTAR.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Search Altar";
	}

	@Override
	public int getSpaceRequired()
	{
		return 1;
	}

}
