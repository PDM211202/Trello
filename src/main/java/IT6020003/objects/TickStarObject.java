package IT6020003.objects;

public class TickStarObject {
	private int tick_star_id;
	private int user_id;
	private int project_id;
	private boolean user_tick_star;
	
	public TickStarObject() {}
	
	public int getTick_star_id() {
		return tick_star_id;
	}
	public void setTick_star_id(int tick_star_id) {
		this.tick_star_id = tick_star_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public boolean isUser_tick_star() {
		return user_tick_star;
	}
	public void setUser_tick_star(boolean user_tick_star) {
		this.user_tick_star = user_tick_star;
	}
	@Override
	public String toString() {
		return "TickStar [tick_star_id=" + tick_star_id + ", user_id=" + user_id + ", project_id=" + project_id
				+ ", user_tick_star=" + user_tick_star + "]";
	}
	
	
}
