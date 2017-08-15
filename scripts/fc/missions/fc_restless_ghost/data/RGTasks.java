package scripts.fc.missions.fc_restless_ghost.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_restless_ghost.tasks.impl.Cutscene;
import scripts.fc.missions.fc_restless_ghost.tasks.impl.FatherUrhneyDialogue;
import scripts.fc.missions.fc_restless_ghost.tasks.impl.GhostDialogue;
import scripts.fc.missions.fc_restless_ghost.tasks.impl.RecoverAmulet;
import scripts.fc.missions.fc_restless_ghost.tasks.impl.SearchAltar;
import scripts.fc.missions.fc_restless_ghost.tasks.impl.StartQuest;
import scripts.fc.missions.fc_restless_ghost.tasks.impl.UseSkullOnCoffin;

public enum RGTasks
{
	START_QUEST(new StartQuest()),
	FATHER_URHNEY_DIALOGUE(new FatherUrhneyDialogue()),
	RECOVER_AMULET(new RecoverAmulet()),
	GHOST_DIALOGUE(new GhostDialogue()),
	SEARCH_ALTAR(new SearchAltar()),
	USE_SKULL_ON_COFFIN(new UseSkullOnCoffin()),
	CUTSCENE(new Cutscene());
	
	public final Task TASK;
	RGTasks(Task t)
	{
		TASK = t;
	}
	
	public static Task[] getTasks()
	{
		List<RGTasks> rgTaskList = new ArrayList<>(Arrays.asList(values()));
		Collections.shuffle(rgTaskList);
		
		return rgTaskList.stream()
				.map(etc -> etc.TASK)
				.toArray(Task[]::new);
	}
}
