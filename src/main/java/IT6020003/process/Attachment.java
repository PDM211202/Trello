package IT6020003.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import IT6020003.ConnectionPool;
import IT6020003.ConnectionPoolImpl;
import IT6020003.objects.AttachmentObject;

public class Attachment {
	// kết nối để làm việc vs csdl
	private Connection con;

	// bộ quản lý kết nối của riêng section
	private ConnectionPool cp;

	public Attachment() {
		// xác định bộ quản lý kết nối
		this.cp = new ConnectionPoolImpl();

		// Xin kết nối để làm việc
		try {
			this.con = this.cp.getConnection("Attachment");

			// kiểm tra chế độ thực thi của kết nối
			if (this.con.getAutoCommit()) {
				this.con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<AttachmentObject> getAllAttachmentObjects(AttachmentObject similar) {
		// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
		ArrayList<AttachmentObject> items = new ArrayList<>();
		AttachmentObject item;

		// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblattachment");

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			// Thực hiện truy vấn và lấy kết quả
			ResultSet rs = pre.executeQuery();

			// Kiểm tra xem ResultSet có giá trị không
			if (rs != null) {
				// Duyệt qua tất cả các dòng kết quả
				while (rs.next()) {
					// Tạo đối tượng ProjectObject để lưu trữ thông tin từ ResultSet
					item = new AttachmentObject();

					// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng AttachmentObject
					item.setAttachment_id(rs.getInt("attachment_id"));
					item.setTodo_id(rs.getInt("todo_id"));
					item.setAttachment_name(rs.getString("attachment_name"));
					item.setAttachment_src(rs.getString("attachment_src"));
					// Thêm đối tượng AttachmentObject vào danh sách
					items.add(item);
				}
			}

		} catch (SQLException e) {
			// Xử lý ngoại lệ và in thông báo lỗi
			e.printStackTrace();

			try {
				// Rollback lại trạng thái trước khi xảy ra lỗi
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		// Trả về danh sách các đối tượng AttachmentObject
		return items;
	}

	public ArrayList<AttachmentObject> getAllAttachmentObjectsByTodoId(AttachmentObject similar, int id) {
		// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
		ArrayList<AttachmentObject> items = new ArrayList<>();
		AttachmentObject item;

		// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblattachment WHERE todo_id= ?");

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setInt(1, id);
			// Thực hiện truy vấn và lấy kết quả
			ResultSet rs = pre.executeQuery();

			// Kiểm tra xem ResultSet có giá trị không
			if (rs != null) {
				// Duyệt qua tất cả các dòng kết quả
				while (rs.next()) {
					// Tạo đối tượng ProjectObject để lưu trữ thông tin từ ResultSet
					item = new AttachmentObject();

					// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng AttachmentObject
					item.setAttachment_id(rs.getInt("attachment_id"));
					item.setTodo_id(rs.getInt("todo_id"));
					item.setAttachment_name(rs.getString("attachment_name"));
					item.setAttachment_src(rs.getString("attachment_src"));
					// Thêm đối tượng AttachmentObject vào danh sách
					items.add(item);
				}
			}

		} catch (SQLException e) {
			// Xử lý ngoại lệ và in thông báo lỗi
			e.printStackTrace();

			try {
				// Rollback lại trạng thái trước khi xảy ra lỗi
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		// Trả về danh sách các đối tượng AttachmentObject
		return items;
	}

	public boolean addAttachment(AttachmentObject item) {
		// Xây dựng câu truy vấn SQL để chèn dữ liệu vào bảng tblAttachment
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tblattachment(");
		sql.append("todo_id, attachment_name, attachment_src");
		sql.append(") ");
		sql.append("VALUES(?,?,?)");

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			// Truyền giá trị cho các tham số trong câu truy vấn từ đối tượng
			// AttachmentObject
			pre.setInt(1, item.getTodo_id());
			pre.setString(2, item.getAttachment_name());
			pre.setString(3, item.getAttachment_src());

			// Thực hiện câu truy vấn chèn dữ liệu
			int result = pre.executeUpdate();

			// Kiểm tra kết quả thực hiện câu truy vấn
			if (result == 0) {
				// Nếu không thành công, rollback lại trạng thái trước khi xảy ra lỗi
				this.con.rollback();
				return false;
			}

			// Ghi nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// Xử lý ngoại lệ và in thông báo lỗi
			e.printStackTrace();

			try {
				// Rollback lại trạng thái trước khi xảy ra lỗi
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		// Trả về false nếu có lỗi xảy ra
		return false;
	}

	// Phương thức cập nhật thông tin một bài viết trong cơ sở dữ liệu
	public boolean updateAttachment(AttachmentObject item, int id) {
		// Xây dựng câu truy vấn SQL để cập nhật dữ liệu trong bảng tblAttachment
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tblattachment SET ");
		sql.append("todo_id = ?, ");
		sql.append("attachment_name = ?, ");
		sql.append("attachment_src = ? ");
		sql.append("WHERE attachment_id = ?");

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			// Truyền giá trị cho các tham số trong câu truy vấn từ đối tượng
			// AttachmentObject
			pre.setInt(1, item.getTodo_id());
			pre.setString(2, item.getAttachment_name());
			pre.setString(3, item.getAttachment_src());
			pre.setInt(4, id);

			// Thực hiện câu truy vấn cập nhật dữ liệu
			int result = pre.executeUpdate();

			// Kiểm tra kết quả thực hiện câu truy vấn
			if (result == 0) {
				// Nếu không thành công, rollback lại trạng thái trước khi xảy ra lỗi
				this.con.rollback();
				return false;
			}

			// Ghi nhận thực thi sau cùng
			this.con.commit();
			return true;

		} catch (SQLException e) {
			// Xử lý ngoại lệ và in thông báo lỗi
			e.printStackTrace();

			try {
				// Rollback lại trạng thái trước khi xảy ra lỗi
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		// Trả về false nếu có lỗi xảy ra
		return false;
	}

	// Phương thức xóa một bài viết từ cơ sở dữ liệu theo ID
	public boolean deleteAttachmentById(AttachmentObject item, int id) {
		// Câu truy vấn SQL để xóa bản ghi từ bảng tblAttachment dựa trên Attachment_id
		String sql = "DELETE FROM tblattachment WHERE attachment_id = ?";

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql);

			// Truyền giá trị cho tham số trong câu truy vấn từ đối tượng AttachmentObject
			pre.setInt(1, id);

			// Thực hiện câu truy vấn xóa bản ghi
			int result = pre.executeUpdate();

			// Kiểm tra kết quả thực hiện câu truy vấn
			if (result == 0) {
				// Nếu không thành công, rollback lại trạng thái trước khi xảy ra lỗi
				this.con.rollback();
				return false;
			}

			// Ghi nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// Xử lý ngoại lệ và in thông báo lỗi
			e.printStackTrace();

			try {
				// Rollback lại trạng thái trước khi xảy ra lỗi
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		// Trả về false nếu có lỗi xảy ra
		return false;
	}
}
