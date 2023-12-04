package IT6020003.objects;

public class ProjectObject {
	private int project_id;
	private String project_name;
	private String project_create_date;
	private String project_start_date;
	private String project_end_date;
	private String project_status;
	
	public ProjectObject() {
		
	}
	
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_create_date() {
		return project_create_date;
	}
	public void setProject_create_date(String project_create_date) {
		this.project_create_date = project_create_date;
	}
	public String getProject_start_date() {
		return project_start_date;
	}
	public void setProject_start_date(String project_start_date) {
		this.project_start_date = project_start_date;
	}
	public String getProject_end_date() {
		return project_end_date;
	}
	public void setProject_end_date(String project_end_date) {
		this.project_end_date = project_end_date;
	}
	public String getProject_status() {
		return project_status;
	}
	public void setProject_status(String project_status) {
		this.project_status = project_status;
	}

	@Override
	public String toString() {
		return "ProjectObject [project_id=" + project_id + ", project_name=" + project_name + ", project_create_date="
				+ project_create_date + ", project_start_date=" + project_start_date + ", project_end_date="
				+ project_end_date + ", project_status=" + project_status + "]";
	}
}