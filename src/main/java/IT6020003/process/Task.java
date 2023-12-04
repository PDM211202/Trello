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
	// Kết nối để làm việc với CSDL
	private Connection con;

	// Bộ quản lý kết nối của riêng section
	private ConnectionPool cp;

	public Task() {
		// Xác định bộ quản lý kết nối
		this.cp = new ConnectionPoolImpl();

		// Xin kết nối để làm việc
		try {
			this.con = this.cp.getConnection("Task");

			// Kiểm tra chế độ thực thi của kết nối
			if (this.con.getAutoCommit()) {
				// Hủy chế độ thực thi tự động
				this.con.setAutoCommit(false);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<TaskObject> getAllTaskObjectsByWorkId(TaskObject similar, int id) {
		// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
		ArrayList<TaskObject> items = new ArrayList<>();
		TaskObject item;

		// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM task WHERE work_id= ?");

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
					item = new TaskObject();

					// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
					item.setTask_id(rs.getInt("task_id"));
					item.setTask_name(rs.getString("task_name"));
					item.setTask_position(rs.getInt("task_position"));
					item.setTask_create_date(rs.getString("task_create_date"));
					item.setTask_description(rs.getString("task_description"));
					item.setTask_start_date(rs.getString("task_start_date"));
					item.setTask_due_date(rs.getString("task_due_date"));
					item.setTask_status(rs.getString("task_status"));
					item.setWork_id(rs.getInt("work_id"));
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
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO task(");
		sql.append("task_name, task_position, ");
		sql.append("task_create_date, task_description, task_start_date, ");
		sql.append("task_due_date, task_status, ");
		sql.append("work_id) ");
		sql.append("VALUES(?,?,?,?,?,?,?,?)");
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getTask_name());
			pre.setInt(2, item.getTask_position());
			pre.setString(3, item.getTask_create_date());
			pre.setString(4, item.getTask_description());
			pre.setString(5, item.getTask_start_date());
			pre.setString(6, item.getTask_due_date());
			pre.setString(7, item.getTask_status());
			pre.setInt(8, item.getWork_id());

			// Thực thi
			int result = pre.executeUpdate();
			if (result == 0) {
				this.con.rollback();
				return false;
			}

			// Ghi nhận thực thi sau cùng
			this.con.commit();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return false;
	}
	
	public static void main(String[] args) {
		// tạo đối tượng làm việc với Article
		Task w = new Task();
		
		TaskObject ntask = new TaskObject();
		ntask.setTask_name("demo function add task");
		
		if(!w.addTask(ntask)) {
			System.out.println("-----KHÔNG THÀNH CÔNG-----");
		}

		ArrayList<TaskObject> items = w.getAllTaskObjectsByWorkId(null, 1);

		// In ra màn hình
		items.forEach(item -> {
			System.out.println(item);
		});
	}
}
