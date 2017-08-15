package scripts.fc.missions.fc_restless_ghost.data;

import java.util.Arrays;

import scripts.fc.framework.quest.InvBankBool;
import scripts.fc.framework.quest.InvBankBool.TYPE;
import scripts.fc.framework.quest.Order;
import scripts.fc.framework.quest.QuestState;
import scripts.fc.framework.quest.SettingBool;
import scripts.fc.missions.fc_restless_ghost.FCRestlessGhost;

public enum RGSettings
{
	START_QUEST
	(
		new QuestState
		(
			new SettingBool(FCRestlessGhost.SETTING, 0, true, Order.EQUALS)
		)
	),
	
	FATHER_URHNEY_DIALOGUE
	(
		new QuestState
		(
			new SettingBool(FCRestlessGhost.SETTING, 1, true, Order.EQUALS)
		)
	),
	
	RECOVER_AMULET
	(
		new QuestState
		(
			new SettingBool(FCRestlessGhost.SETTING, 2, true, Order.EQUALS),
			new InvBankBool(FCRestlessGhost.AMULET, 1, TYPE.NOT_IN_EITHER, true)
		)
	),
	
	GHOST_DIALOGUE
	(
		new QuestState
		(
			new SettingBool(FCRestlessGhost.SETTING, 2, true, Order.EQUALS),
			new InvBankBool(FCRestlessGhost.AMULET, 1, TYPE.IN_ONE, true)
		)
	),
	
	SEARCH_ALTAR
	(
		new QuestState
		(
			new SettingBool(FCRestlessGhost.SETTING, 3, true, Order.AFTER_EQUALS),
			new SettingBool(FCRestlessGhost.SETTING, 5, true, Order.BEFORE),
			new InvBankBool(FCRestlessGhost.SKULL, 1, TYPE.NOT_IN_EITHER, true)
		)
	),
	
	USE_SKULL_ON_COFFIN
	(
		new QuestState
		(
			new SettingBool(FCRestlessGhost.SETTING, 4, true, Order.EQUALS),
			new InvBankBool(FCRestlessGhost.SKULL, 1, TYPE.IN_ONE, true)
		)
	),
	
	CUTSCENE
	(
		new QuestState
		(
			new SettingBool(1021, 192, true, Order.EQUALS)
		)
	),
	
	QUEST_COMPLETE
	(
		new QuestState
		(
			new SettingBool(1021, 0, true, Order.EQUALS),
			new SettingBool(FCRestlessGhost.SETTING, 5, true, Order.EQUALS)
		)
	);
	
	private QuestState[] states;
	
	RGSettings(QuestState... states)
	{
		this.states = states;
	}
	
	public boolean isValid()
	{
		return Arrays.stream(states).allMatch(s -> s.validate());
	}
}
