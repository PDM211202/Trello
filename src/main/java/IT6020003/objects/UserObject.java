package IT6020003.objects;

public class UserObject {
	private int user_id;
	private int user_parent_id;
	private String user_email;
	private String user_background_src;
	private String user_background_avatar_src;
	private String user_created_date;
	private String user_recently_viewed;
	private String user_password;
	private String user_name;
	private String user_fullname;
	private String user_birthday;
	private String user_mobilephone;
	private String user_homephone;
	private String user_address;
	private String user_jobarea;
	private String user_job;
	private String user_roles;
	private boolean user_logged_in;
	
	public UserObject() {}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getUser_parent_id() {
		return user_parent_id;
	}
	public void setUser_parent_id(int user_parent_id) {
		this.user_parent_id = user_parent_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_background_src() {
		return user_background_src;
	}
	public void setUser_background_src(String user_background_src) {
		this.user_background_src = user_background_src;
	}
	public String getUser_background_avatar_src() {
		return user_background_avatar_src;
	}
	public void setUser_background_avatar_src(String user_background_avatar_src) {
		this.user_background_avatar_src = user_background_avatar_src;
	}
	public String getUser_created_date() {
		return user_created_date;
	}
	public void setUser_created_date(String user_created_date) {
		this.user_created_date = user_created_date;
	}
	public String getUser_recently_viewed() {
		return user_recently_viewed;
	}
	public void setUser_recently_viewed(String user_recently_viewed) {
		this.user_recently_viewed = user_recently_viewed;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_fullname() {
		return user_fullname;
	}
	public void setUser_fullname(String user_fullname) {
		this.user_fullname = user_fullname;
	}
	public String getUser_birthday() {
		return user_birthday;
	}
	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}
	public String getUser_mobilephone() {
		return user_mobilephone;
	}
	public void setUser_mobilephone(String user_mobilephone) {
		this.user_mobilephone = user_mobilephone;
	}
	public String getUser_homephone() {
		return user_homephone;
	}
	public void setUser_homephone(String user_homephone) {
		this.user_homephone = user_homephone;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_jobarea() {
		return user_jobarea;
	}
	public void setUser_jobarea(String user_jobarea) {
		this.user_jobarea = user_jobarea;
	}
	public String getUser_job() {
		return user_job;
	}
	public void setUser_job(String user_job) {
		this.user_job = user_job;
	}
	public String getUser_roles() {
		return user_roles;
	}
	public void setUser_roles(String user_roles) {
		this.user_roles = user_roles;
	}
	public boolean isUser_logged_in() {
		return user_logged_in;
	}
	public void setUser_logged_in(boolean user_logged_in) {
		this.user_logged_in = user_logged_in;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_parent_id=" + user_parent_id + ", user_email=" + user_email
				+ ", user_background_src=" + user_background_src + ", user_background_avatar_src="
				+ user_background_avatar_src + ", user_created_date=" + user_created_date + ", user_recently_viewed="
				+ user_recently_viewed + ", user_password=" + user_password + ", user_name=" + user_name
				+ ", user_fullname=" + user_fullname + ", user_birthday=" + user_birthday + ", user_mobilephone="
				+ user_mobilephone + ", user_homephone=" + user_homephone + ", user_address=" + user_address
				+ ", user_jobarea=" + user_jobarea + ", user_job=" + user_job + ", user_roles=" + user_roles
				+ ", user_logged_in=" + user_logged_in + "]";
	}
	
	
}
