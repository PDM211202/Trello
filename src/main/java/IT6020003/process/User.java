package IT6020003.process;

import java.util.*;
import java.sql.*;
import IT6020003.objects.*;
import IT6020003.*;

public class User {
	// Kết nối để làm việc với CSDL
	private Connection con;

	// Bộ quản lý kết nối của riêng section
	private ConnectionPool cp;

	public User() {
		// Xác định bộ quản lý kết nối
		this.cp = new ConnectionPoolImpl();

		// Xin kết nối để làm việc
		try {
			this.con = this.cp.getConnection("User");

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
	public ArrayList<UserObject> getAllUserObjects(UserObject similar) {
		// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
		ArrayList<UserObject> items = new ArrayList<>();
		UserObject item;

		// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM user");

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
					item = new UserObject();

					// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_parent_id(rs.getInt("user_parent_id"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_created_date(rs.getString("user_created_date"));
					item.setUser_password(rs.getString("user_password"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_birthday(rs.getString("user_birthday"));
					item.setUser_mobilephone(rs.getString("user_mobilephone"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_jobarea(rs.getString("user_jobarea"));
					item.setUser_job(rs.getString("user_job"));
					item.setUser_roles(rs.getString("user_roles"));
					item.setUser_logined(rs.getBoolean("user_logined"));
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
	
	public UserObject getUserObjectByEmail(UserObject similar, String email) {
		// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
		UserObject item = null;

		// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM user WHERE user_email = ?");

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setString(1, email);
			// Thực hiện truy vấn và lấy kết quả
			ResultSet rs = pre.executeQuery();

			// Kiểm tra xem ResultSet có giá trị không
			if (rs != null) {
				// Duyệt qua tất cả các dòng kết quả
				while (rs.next()) {
					// Tạo đối tượng ProjectObject để lưu trữ thông tin từ ResultSet
					item = new UserObject();

					// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_parent_id(rs.getInt("user_parent_id"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_created_date(rs.getString("user_created_date"));
					item.setUser_password(rs.getString("user_password"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_birthday(rs.getString("user_birthday"));
					item.setUser_mobilephone(rs.getString("user_mobilephone"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_jobarea(rs.getString("user_jobarea"));
					item.setUser_job(rs.getString("user_job"));
					item.setUser_roles(rs.getString("user_roles"));
					item.setUser_logined(rs.getBoolean("user_logined"));
					// Thêm đối tượng ArticleObject vào danh sách
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
		return item;
	}
	
	public static void main(String[] args) {
		// tạo đối tượng làm việc với Article
		User u = new User();

		UserObject items = u.getUserObjectByEmail(null, "john.doe@example.com");

		// In ra màn hình
			System.out.println(items);
	}
}
