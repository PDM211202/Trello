package IT6020003.objects;

public class MemberObject {
	private int member_id;
	private int user_id;
	private int working_space_id;
	
	public MemberObject() {

	}
	
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getWorking_space_id() {
		return working_space_id;
	}
	public void setWorking_space_id(int working_space_id) {
		this.working_space_id = working_space_id;
	}
	@Override
	public String toString() {
		return "Member [member_id=" + member_id + ", user_id=" + user_id + ", working_space_id=" + working_space_id
				+ "]";
	}
	
	
}
