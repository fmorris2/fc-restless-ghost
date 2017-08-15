package scripts.fc.missions.fc_restless_ghost.tasks.impl;

import org.tribot.api.General;

import scripts.fc.api.utils.InterfaceUtils;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_restless_ghost.data.RGSettings;

public class Cutscene extends Task
{
	private static final long serialVersionUID = 1L;

	@Override
	public boolean execute()
	{
		General.println("Waiting for cutscene to finish...");
		if(FCTiming.waitCondition(() -> !shouldExecute() && InterfaceUtils.isQuestInterfaceUp(), 15000))
			return InterfaceUtils.closeQuestInterface();
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return RGSettings.CUTSCENE.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Cutscene";
	}

}
