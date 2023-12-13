package IT6020003.objects;

public class TaskObject {
	private int task_id;
	private String task_name;
	private int work_id;
	private int task_position;
	private String task_description;
	private String task_cover_img_src;
	private String task_start_date;
	private String task_expiration_date;
	
	public TaskObject() {}
	
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
	public int getWork_id() {
		return work_id;
	}
	public void setWork_id(int work_id) {
		this.work_id = work_id;
	}
	public int getTask_position() {
		return task_position;
	}
	public void setTask_position(int task_position) {
		this.task_position = task_position;
	}
	public String getTask_description() {
		return task_description;
	}
	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}
	public String getTask_cover_img_src() {
		return task_cover_img_src;
	}
	public void setTask_cover_img_src(String task_cover_img_src) {
		this.task_cover_img_src = task_cover_img_src;
	}
	public String getTask_start_date() {
		return task_start_date;
	}
	public void setTask_start_date(String task_start_date) {
		this.task_start_date = task_start_date;
	}
	public String getTask_expiration_date() {
		return task_expiration_date;
	}
	public void setTask_expiration_date(String task_expiration_date) {
		this.task_expiration_date = task_expiration_date;
	}
	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", task_name=" + task_name + ", work_id=" + work_id + ", task_position="
				+ task_position + ", task_description=" + task_description + ", task_cover_img_src="
				+ task_cover_img_src + ", task_start_date=" + task_start_date + ", task_expiration_date="
				+ task_expiration_date + "]";
	}
	
	
}
