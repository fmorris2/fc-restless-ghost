package scripts.fc.missions.fc_restless_ghost.tasks;

import java.util.function.BooleanSupplier;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Objects;
import org.tribot.api2007.ext.Filters;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.BasicInteractionTask;
import scripts.fc.api.interaction.impl.objects.ClickObject;

public abstract class CoffinTask extends BasicInteractionTask
{
	private static final long serialVersionUID = 1L;

	@Override
	public boolean execute()
	{
		if (isWithinRadius() && !isCoffinOpen())
			return openCoffin();

		return super.execute();
	}

	private boolean isCoffinOpen()
	{
		return Objects.find(getRadius(), Filters.Objects.nameEquals("Coffin").combine(Filters.Objects.actionsEquals("Close"), false)).length > 0;
	}

	private boolean openCoffin()
	{
		return new ClickObject("Open", "Coffin", getRadius()).execute()
				&& FCTiming.waitCondition(() -> isCoffinOpen(), 5000);
	}

	@Override
	protected Positionable getPosition()
	{
		return new RSTile(3248, 3193, 0);
	}

	@Override
	protected int getRadius()
	{
		return 5;
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
}
