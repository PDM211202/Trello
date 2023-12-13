package IT6020003.objects;

public class CoverObject {
	private int cover_id;
	private int todo_id;
	private String cover_name;
	private String cover_color;
	private String cover_image_src;
	
	public CoverObject() {

	}
	
	public int getCover_id() {
		return cover_id;
	}
	public void setCover_id(int cover_id) {
		this.cover_id = cover_id;
	}
	public int getTodo_id() {
		return todo_id;
	}
	public void setTodo_id(int todo_id) {
		this.todo_id = todo_id;
	}
	public String getCover_name() {
		return cover_name;
	}
	public void setCover_name(String cover_name) {
		this.cover_name = cover_name;
	}
	public String getCover_color() {
		return cover_color;
	}
	public void setCover_color(String cover_color) {
		this.cover_color = cover_color;
	}
	public String getCover_image_src() {
		return cover_image_src;
	}
	public void setCover_image_src(String cover_image_src) {
		this.cover_image_src = cover_image_src;
	}
	@Override
	public String toString() {
		return "Cover [cover_id=" + cover_id + ", todo_id=" + todo_id + ", cover_name=" + cover_name + ", cover_color="
				+ cover_color + ", cover_image_src=" + cover_image_src + "]";
	}
	
	
}
