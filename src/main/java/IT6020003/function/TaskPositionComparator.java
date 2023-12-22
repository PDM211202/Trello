package IT6020003.function;

import java.util.Comparator;

import IT6020003.objects.TaskObject;

public class TaskPositionComparator implements Comparator<TaskObject> {
	@Override
	public int compare(TaskObject o1, TaskObject o2) {
		return Integer.compare(o1.getTask_position(), o2.getTask_position());
	}
}
