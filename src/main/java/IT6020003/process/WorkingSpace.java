package IT6020003.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import IT6020003.ConnectionPool;
import IT6020003.ConnectionPoolImpl;
import IT6020003.objects.WorkingSpaceObject;

public class WorkingSpace {
	// Kết nối để làm việc với CSDL
	private Connection con;

	// Bộ quản lý kết nối của riêng section
	private ConnectionPool cp;

	public WorkingSpace() {
		// Xác định bộ quản lý kết nối
		this.cp = new ConnectionPoolImpl();

		// Xin kết nối để làm việc
		try {
			this.con = this.cp.getConnection("WorkingSpace");

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
	
	// Phương thức trả về danh sách tất cả các đối tượng ProjectObject từ cơ sở dữ
		// liệu
		public ArrayList<WorkingSpaceObject> getAllWorkingSpaceObjects(WorkingSpaceObject similar) {
			// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
			ArrayList<WorkingSpaceObject> items = new ArrayList<>();
			WorkingSpaceObject item;

			// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM working_space");

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
						item = new WorkingSpaceObject();

						// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
						item.setWorking_space_id(rs.getInt("working_space_id"));
						item.setWorking_space_name(rs.getString("working_space_name"));
						item.setWorking_space_create_date(rs.getString("working_space_create_date"));
						item.setWorking_space_url(rs.getString("working_space_url"));
						item.setUser_id(rs.getInt("user_id"));
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
		
		public ArrayList<WorkingSpaceObject> getAllWorkingSpaceObjectsByUserId(WorkingSpaceObject similar, int user_id) {
			// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
			ArrayList<WorkingSpaceObject> items = new ArrayList<>();
			WorkingSpaceObject item;

			// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM working_space WHERE user_id= ?");

			try {
				// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
				PreparedStatement pre = this.con.prepareStatement(sql.toString());
				pre.setInt(1, user_id);
				// Thực hiện truy vấn và lấy kết quả
				ResultSet rs = pre.executeQuery();

				// Kiểm tra xem ResultSet có giá trị không
				if (rs != null) {
					// Duyệt qua tất cả các dòng kết quả
					while (rs.next()) {
						// Tạo đối tượng ProjectObject để lưu trữ thông tin từ ResultSet
						item = new WorkingSpaceObject();

						// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
						item.setWorking_space_id(rs.getInt("working_space_id"));
						item.setWorking_space_name(rs.getString("working_space_name"));
						item.setWorking_space_create_date(rs.getString("working_space_create_date"));
						item.setWorking_space_url(rs.getString("working_space_url"));
						item.setUser_id(rs.getInt("user_id"));
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
			WorkingSpace ws = new WorkingSpace();

			ArrayList<WorkingSpaceObject> items = ws.getAllWorkingSpaceObjects(null);

			// In ra màn hình
			items.forEach(item -> {
				System.out.println(item);
			});
		}
}
