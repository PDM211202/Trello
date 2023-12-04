package IT6020003.objects;

public class TaskObject {
	private int task_id;
    private String task_name;
    private int task_position;
    private String task_create_date;
    private String task_description;
    private String task_start_date;
    private String task_due_date;
    private String task_status;
    private int work_id;
    
    public TaskObject() {
    	
    }
    
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public int getTask_position() {
		return task_position;
	}
	public void setTask_position(int task_position) {
		this.task_position = task_position;
	}
	public String getTask_create_date() {
		return task_create_date;
	}
	public void setTask_create_date(String task_create_date) {
		this.task_create_date = task_create_date;
	}
	public String getTask_description() {
		return task_description;
	}
	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}
	public String getTask_start_date() {
		return task_start_date;
	}
	public void setTask_start_date(String task_start_date) {
		this.task_start_date = task_start_date;
	}
	public String getTask_due_date() {
		return task_due_date;
	}
	public void setTask_due_date(String task_due_date) {
		this.task_due_date = task_due_date;
	}
	public String getTask_status() {
		return task_status;
	}
	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}
	public int getWork_id() {
		return work_id;
	}
	public void setWork_id(int work_id) {
		this.work_id = work_id;
	}

	@Override
	public String toString() {
		return "TaskObject [task_id=" + task_id + ", task_name=" + task_name + ", task_position=" + task_position
				+ ", task_create_date=" + task_create_date + ", task_description=" + task_description
				+ ", task_start_date=" + task_start_date + ", task_due_date=" + task_due_date + ", task_status="
				+ task_status + ", work_id=" + work_id + "]";
	}
	
	
}
