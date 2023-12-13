package IT6020003.objects;

public class TodoListObject {
	private int todolist_id;
	private String todolist_name;
	private int task_id;
	
	public TodoListObject() {}
	
	public int getTodolist_id() {
		return todolist_id;
	}
	public void setTodolist_id(int todolist_id) {
		this.todolist_id = todolist_id;
	}
	public String getTodolist_name() {
		return todolist_name;
	}
	public void setTodolist_name(String todolist_name) {
		this.todolist_name = todolist_name;
	}
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	@Override
	public String toString() {
		return "TodoList [todolist_id=" + todolist_id + ", todolist_name=" + todolist_name + ", task_id=" + task_id
				+ "]";
	}
	
	
}
