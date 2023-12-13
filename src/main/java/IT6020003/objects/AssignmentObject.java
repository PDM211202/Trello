package IT6020003.objects;

public class AssignmentObject {
	private int assignment_id;
	private int user_id;
	private int todo_id;
	private String assignment_date;
	
	public AssignmentObject() {
		
	}
	
	public int getAssignment_id() {
		return assignment_id;
	}
	public void setAssignment_id(int assignment_id) {
		this.assignment_id = assignment_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getTodo_id() {
		return todo_id;
	}
	public void setTodo_id(int todo_id) {
		this.todo_id = todo_id;
	}
	public String getAssignment_date() {
		return assignment_date;
	}
	public void setAssignment_date(String assignment_date) {
		this.assignment_date = assignment_date;
	}
	@Override
	public String toString() {
		return "Assignment [assignment_id=" + assignment_id + ", user_id=" + user_id + ", todo_id=" + todo_id
				+ ", assignment_date=" + assignment_date + "]";
	}
	
	
}
