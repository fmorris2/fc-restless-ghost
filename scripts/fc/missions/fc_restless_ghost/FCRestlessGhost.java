package scripts.fc.missions.fc_restless_ghost;

import java.util.Arrays;
import java.util.LinkedList;

import scripts.fc.framework.quest.QuestScriptManager;
import scripts.fc.framework.requirement.Requirement;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_restless_ghost.data.RGSettings;
import scripts.fc.missions.fc_restless_ghost.data.RGTasks;

public class FCRestlessGhost extends QuestScriptManager
{
	public static final String QUEST_NAME = "The Restless Ghost";
	public static final int SETTING = 107;
	public static final int AMULET = 552, SKULL = 553;
	
	public FCRestlessGhost(FCMissionScript fcScript)
	{
		super(fcScript);
	}

	@Override
	public boolean canStart()
	{
		return true;
	}

	@Override
	public boolean hasReachedEndingCondition()
	{
		return RGSettings.QUEST_COMPLETE.isValid();
	}

	@Override
	public String getMissionName()
	{
		return "FC Restless Ghost";
	}

	@Override
	public String getEndingMessage()
	{
		return "FC Restless Ghost has ended";
	}

	@Override
	public String[] getMissionSpecificPaint()
	{
		return new String[]{};
	}

	@Override
	public void resetStatistics()
	{
	}

	@Override
	public Requirement[] getRequirements()
	{
		return new Requirement[]{};
	}

	@Override
	public LinkedList<Task> getTaskList()
	{
		return new LinkedList<>(Arrays.asList(RGTasks.getTasks()));
	}
	
	@Override
	public String toString()
	{
		return QUEST_NAME;
	}

	@Override
	public int getQuestPointReward() {
		return 1;
	}

}
