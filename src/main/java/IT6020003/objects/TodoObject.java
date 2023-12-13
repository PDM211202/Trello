package IT6020003.objects;

public class TodoObject {
	private int todo_id;
	private String todo_name;
	private int todolist_id;
	private String todo_expiration_date;
	
	public TodoObject() {}
	
	public int getTodo_id() {
		return todo_id;
	}
	public void setTodo_id(int todo_id) {
		this.todo_id = todo_id;
	}
	public String getTodo_name() {
		return todo_name;
	}
	public void setTodo_name(String todo_name) {
		this.todo_name = todo_name;
	}
	public int getTodolist_id() {
		return todolist_id;
	}
	public void setTodolist_id(int todolist_id) {
		this.todolist_id = todolist_id;
	}
	public String getTodo_expiration_date() {
		return todo_expiration_date;
	}
	public void setTodo_expiration_date(String todo_expiration_date) {
		this.todo_expiration_date = todo_expiration_date;
	}
	@Override
	public String toString() {
		return "Todo [todo_id=" + todo_id + ", todo_name=" + todo_name + ", todolist_id=" + todolist_id
				+ ", todo_expiration_date=" + todo_expiration_date + "]";
	}
	
	
}
