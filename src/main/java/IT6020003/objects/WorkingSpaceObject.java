package IT6020003.objects;

public class WorkingSpaceObject {
	private int working_space_id;
    private String working_space_name;
    private String working_space_create_date;
    private String working_space_url;
    private int user_id;
    
    public WorkingSpaceObject() {
    	
    }

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

	public String getWorking_space_create_date() {
		return working_space_create_date;
	}

	public void setWorking_space_create_date(String working_space_create_date) {
		this.working_space_create_date = working_space_create_date;
	}

	public String getWorking_space_url() {
		return working_space_url;
	}

	public void setWorking_space_url(String working_space_url) {
		this.working_space_url = working_space_url;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "WorkingSpaceObject [working_space_id=" + working_space_id + ", working_space_name=" + working_space_name
				+ ", working_space_create_date=" + working_space_create_date + ", working_space_url="
				+ working_space_url + ", user_id=" + user_id + "]";
	}
    
    
}
