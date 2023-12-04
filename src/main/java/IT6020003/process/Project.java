package IT6020003.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import IT6020003.ConnectionPool;
import IT6020003.ConnectionPoolImpl;
import IT6020003.objects.ProjectObject;

public class Project {
	// kết nối để làm việc vs csdl
	private Connection con;

	// bộ quản lý kết nối của riêng section
	private ConnectionPool cp;

	public Project() {
		// xác định bộ quản lý kết nối
		this.cp = new ConnectionPoolImpl();

		// Xin kết nối để làm việc
		try {
			this.con = this.cp.getConnection("Project");

			// kiểm tra chế độ thực thi của kết nối
			if (this.con.getAutoCommit()) {
				this.con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Phương thức trả về danh sách tất cả các đối tượng ProjectObject từ cơ sở dữ liệu
	public ArrayList<ProjectObject> getAllProjectObjects(ProjectObject similar) {
		// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
		ArrayList<ProjectObject> items = new ArrayList<>();
		ProjectObject item;

		// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM project");

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
					item = new ProjectObject();

					// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
					item.setProject_id(rs.getInt("project_id"));
					item.setProject_name(rs.getString("project_name"));
					item.setProject_create_date(rs.getString("project_create_date"));
					item.setProject_start_date(rs.getString("project_start_date"));
					item.setProject_end_date(rs.getString("project_end_date"));
					item.setProject_status(rs.getString("project_status"));
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
	
	public static void main(String[] args) {
		// tạo đối tượng làm việc với Article
		Project a = new Project();


		ArrayList<ProjectObject> items = a.getAllProjectObjects(null);

		// In ra màn hình
		items.forEach(item -> {
			System.out.println(item);
		});
	}
}
