package IT6020003.objects;

public class WorkSpaceObject {
	private int working_space_id;
	private String working_space_name;
	private int user_id;
	private String working_space_create_date;
	private String working_space_background_src;
	private String working_space_avatar_src;
	
	public WorkSpaceObject() {}
	
	public int getWorking_space_id() {
		return working_space_id;
	}
	public void setWorking_space_id(int working_space_id) {
		this.working_space_id = working_space_id;
	}
	public String getWorking_space_name() {
		return working_space_name;
	}
	public void setWorking_space_name(String working_space_name) {
		this.working_space_name = working_space_name;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getWorking_space_create_date() {
		return working_space_create_date;
	}
	public void setWorking_space_create_date(String working_space_create_date) {
		this.working_space_create_date = working_space_create_date;
	}
	public String getWorking_space_background_src() {
		return working_space_background_src;
	}
	public void setWorking_space_background_src(String working_space_background_src) {
		this.working_space_background_src = working_space_background_src;
	}
	public String getWorking_space_avatar_src() {
		return working_space_avatar_src;
	}
	public void setWorking_space_avatar_src(String working_space_avatar_src) {
		this.working_space_avatar_src = working_space_avatar_src;
	}
	@Override
	public String toString() {
		return "WorkSpace [working_space_id=" + working_space_id + ", working_space_name=" + working_space_name
				+ ", user_id=" + user_id + ", working_space_create_date=" + working_space_create_date
				+ ", working_space_background_src=" + working_space_background_src + ", working_space_avatar_src="
				+ working_space_avatar_src + "]";
	}
	
}
