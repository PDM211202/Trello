package IT6020003.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import IT6020003.ConnectionPool;
import IT6020003.ConnectionPoolImpl;
import IT6020003.objects.TaskObject;

public class Task {
	// kết nối để làm việc vs csdl
	private Connection con;

	// bộ quản lý kết nối của riêng section
	private ConnectionPool cp;

	public Task() {
		// xác định bộ quản lý kết nối
		this.cp = new ConnectionPoolImpl();

		// Xin kết nối để làm việc
		try {
			this.con = this.cp.getConnection("Task");

			// kiểm tra chế độ thực thi của kết nối
			if (this.con.getAutoCommit()) {
				this.con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<TaskObject> getAllTaskObjects(TaskObject similar) {
		// Khởi tạo một ArrayList để lưu trữ các đối tượng TaskObject
		ArrayList<TaskObject> items = new ArrayList<>();
		TaskObject item;

		// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Task
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tbltask");

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			// Thực hiện truy vấn và lấy kết quả
			ResultSet rs = pre.executeQuery();

			// Kiểm tra xem ResultSet có giá trị không
			if (rs != null) {
				// Duyệt qua tất cả các dòng kết quả
				while (rs.next()) {
					// Tạo đối tượng TaskObject để lưu trữ thông tin từ ResultSet
					item = new TaskObject();

					// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
					item.setTask_id(rs.getInt("task_id"));
					item.setTask_name(rs.getString("task_name"));
					item.setWork_id(rs.getInt("work_id"));
					item.setTask_position(rs.getInt("task_position"));
					item.setTask_description(rs.getString("task_description"));
					item.setTask_cover_img_src(rs.getString("task_cover_img_src"));
					item.setTask_start_date(rs.getString("task_start_date"));
					item.setTask_expiration_date(rs.getString("task_expiration_date"));

					// Thêm đối tượng ArticleObject vào danh sách
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

		// Trả về danh sách các đối tượng ArticleObject
		return items;
	}

	public ArrayList<TaskObject> getAllTaskObjectsByWorkId(TaskObject similar, int id) {
		// Khởi tạo một ArrayList để lưu trữ các đối tượng TaskObject
		ArrayList<TaskObject> items = new ArrayList<>();
		TaskObject item;

		// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Task
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tbltask WHERE work_id= ?");

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
					// Tạo đối tượng TaskObject để lưu trữ thông tin từ ResultSet
					item = new TaskObject();

					// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
					item.setTask_id(rs.getInt("task_id"));
					item.setTask_name(rs.getString("task_name"));
					item.setWork_id(rs.getInt("work_id"));
					item.setTask_position(rs.getInt("task_position"));
					item.setTask_description(rs.getString("task_description"));
					item.setTask_cover_img_src(rs.getString("task_cover_img_src"));
					item.setTask_start_date(rs.getString("task_start_date"));
					item.setTask_expiration_date(rs.getString("task_expiration_date"));
					// Thêm đối tượng ArticleObject vào danh sách
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

		// Trả về danh sách các đối tượng ArticleObject
		return items;
	}

	public boolean addTask(TaskObject item) {
		// Xây dựng câu truy vấn SQL để chèn dữ liệu vào bảng tbltask
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tbltask(");
		sql.append("task_name, work_id, task_position, task_description, task_cover_img_src, task_start_date, task_expiration_date");
		sql.append(") ");
		sql.append("VALUES(?,?,?,?,?,?,?)");

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			// Truyền giá trị cho các tham số trong câu truy vấn từ đối tượng
			// TaskObject
			pre.setString(1, item.getTask_name());
			pre.setInt(2, item.getWork_id());
			pre.setInt(3, item.getTask_position());
			pre.setString(4, item.getTask_description());
			pre.setString(5, item.getTask_cover_img_src());
			pre.setString(6, item.getTask_start_date());
			pre.setString(7, item.getTask_expiration_date());

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
	public boolean updateTask(TaskObject item, int id) {
		// Xây dựng câu truy vấn SQL để cập nhật dữ liệu trong bảng tbltask
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbltask SET ");
		sql.append("task_name = ?, ");
		sql.append("work_id = ?, ");
		sql.append("task_position = ?, ");
		sql.append("task_description = ?, ");
		sql.append("task_cover_img_src = ?, ");
		sql.append("task_start_date = ?, ");
		sql.append("task_expiration_date = ?, ");
		sql.append("WHERE task_id = ?");

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			// Truyền giá trị cho các tham số trong câu truy vấn từ đối tượng
			// TaskObject
			pre.setString(1, item.getTask_name());
			pre.setInt(2, item.getWork_id());
			pre.setInt(3, item.getTask_position());
			pre.setString(4, item.getTask_description());
			pre.setString(5, item.getTask_cover_img_src());
			pre.setString(6, item.getTask_start_date());
			pre.setString(7, item.getTask_expiration_date());
			pre.setInt(8, id);
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
	public boolean deleteTaskById(TaskObject item, int id) {
		// Câu truy vấn SQL để xóa bản ghi từ bảng tbltask dựa trên article_id
		String sql = "DELETE FROM tbltask WHERE task_id = ?";

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql);

			// Truyền giá trị cho tham số trong câu truy vấn từ đối tượng TaskObject
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
	
	public static void main(String[] args) {
		Task t = new Task();
		ArrayList<TaskObject> list_t = t.getAllTaskObjectsByWorkId(null, 1);
		
		System.out.println(list_t);
	}
}
