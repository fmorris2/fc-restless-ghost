package scripts.fc.missions.fc_restless_ghost.tasks.impl;

import java.util.function.BooleanSupplier;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.objects.ItemOnObject;
import scripts.fc.api.items.FCItem;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.missions.fc_restless_ghost.FCRestlessGhost;
import scripts.fc.missions.fc_restless_ghost.data.RGSettings;
import scripts.fc.missions.fc_restless_ghost.tasks.CoffinTask;

public class UseSkullOnCoffin extends CoffinTask implements ItemsRequiredTask
{
	private static final long serialVersionUID = 1L;

	@Override
	public FCItem[] getRequiredItems()
	{
		return new FCItem[]{new FCItem(1, false, FCRestlessGhost.SKULL)};
	}

	@Override
	protected EntityInteraction getInteraction()
	{
		return new ItemOnObject("Ghost's skull", "Coffin", getRadius());
	}

	@Override
	public boolean shouldExecute()
	{
		return RGSettings.USE_SKULL_ON_COFFIN.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Use skull on coffin";
	}
	
	@Override
	protected BooleanSupplier getWaitCondition()
	{
		return () -> RGSettings.CUTSCENE.isValid();
	}

	@Override
	protected int getWaitTimeout()
	{
		return 7500;
	}

}
