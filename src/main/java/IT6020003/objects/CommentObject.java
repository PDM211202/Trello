package IT6020003.objects;

public class CommentObject {
	private int comment_id;
	private int todo_id;
	private int user_id;
	private String comment_text;
	private String comment_date;

	public CommentObject() {

	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getTodo_id() {
		return todo_id;
	}

	public void setTodo_id(int todo_id) {
		this.todo_id = todo_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

	public String getComment_date() {
		return comment_date;
	}

	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}

	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", todo_id=" + todo_id + ", user_id=" + user_id + ", comment_text="
				+ comment_text + ", comment_date=" + comment_date + "]";
	}

}
