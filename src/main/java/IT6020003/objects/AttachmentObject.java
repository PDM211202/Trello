package IT6020003.objects;

public class AttachmentObject {
	private int attachment_id;
	private int todo_id;
	private String attachment_name;
	private String attachment_src;
	
	public AttachmentObject() {
		
	}
	
	public int getAttachment_id() {
		return attachment_id;
	}
	public void setAttachment_id(int attachment_id) {
		this.attachment_id = attachment_id;
	}
	public int getTodo_id() {
		return todo_id;
	}
	public void setTodo_id(int todo_id) {
		this.todo_id = todo_id;
	}
	public String getAttachment_name() {
		return attachment_name;
	}
	public void setAttachment_name(String attachment_name) {
		this.attachment_name = attachment_name;
	}
	public String getAttachment_src() {
		return attachment_src;
	}
	public void setAttachment_src(String attachment_src) {
		this.attachment_src = attachment_src;
	}
	@Override
	public String toString() {
		return "Attachment [attachment_id=" + attachment_id + ", todo_id=" + todo_id + ", attachment_name="
				+ attachment_name + ", attachment_src=" + attachment_src + "]";
	}
	
	
}
