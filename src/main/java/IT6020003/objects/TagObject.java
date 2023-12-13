package IT6020003.objects;

public class TagObject {
	private int tag_id;
	private int task_id;
	private String tag_name;
	private String tag_color;
	
	public TagObject() {}
	public int getTag_id() {
		return tag_id;
	}
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	public String getTag_color() {
		return tag_color;
	}
	public void setTag_color(String tag_color) {
		this.tag_color = tag_color;
	}
	@Override
	public String toString() {
		return "Tag [tag_id=" + tag_id + ", task_id=" + task_id + ", tag_name=" + tag_name + ", tag_color=" + tag_color
				+ "]";
	}
	
	
}
