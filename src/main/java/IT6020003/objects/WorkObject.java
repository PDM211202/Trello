package IT6020003.objects;

public class WorkObject {
	private int work_id;
	private String work_name;
    private int work_position;
    private String work_create_date;
    private int project_id;
    
    public WorkObject() {
    	
    }
    
	public int getWork_id() {
		return work_id;
	}
	public void setWork_id(int work_id) {
		this.work_id = work_id;
	}
	public String getWork_name() {
		return work_name;
	}
	public void setWork_name(String work_name) {
		this.work_name = work_name;
	}
	public int getWork_position() {
		return work_position;
	}
	public void setWork_position(int work_position) {
		this.work_position = work_position;
	}
	public String getWork_create_date() {
		return work_create_date;
	}
	public void setWork_create_date(String work_create_date) {
		this.work_create_date = work_create_date;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	@Override
	public String toString() {
		return "WorkObject [work_id=" + work_id + ", work_name=" + work_name + ", work_position=" + work_position
				+ ", work_create_date=" + work_create_date + ", project_id=" + project_id + "]";
	}
}
