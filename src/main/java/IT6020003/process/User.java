package IT6020003.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import IT6020003.ConnectionPool;
import IT6020003.ConnectionPoolImpl;
import IT6020003.objects.UserObject;

public class User {
		// kết nối để làm việc vs csdl
		private Connection con;

		// bộ quản lý kết nối của riêng section
		private ConnectionPool cp;

		public User() {
			// xác định bộ quản lý kết nối
			this.cp = new ConnectionPoolImpl();

			// Xin kết nối để làm việc
			try {
				this.con = this.cp.getConnection("User");

				// kiểm tra chế độ thực thi của kết nối
				if (this.con.getAutoCommit()) {
					this.con.setAutoCommit(false);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public ArrayList<UserObject> getAllUserObjects(UserObject similar) {
			// Khởi tạo một ArrayList để lưu trữ các đối tượng UserObject
			ArrayList<UserObject> items = new ArrayList<>();
			UserObject item;

			// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng User
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM tbluser");

			try {
				// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
				PreparedStatement pre = this.con.prepareStatement(sql.toString());

				// Thực hiện truy vấn và lấy kết quả
				ResultSet rs = pre.executeQuery();

				// Kiểm tra xem ResultSet có giá trị không
				if (rs != null) {
					// Duyệt qua tất cả các dòng kết quả
					while (rs.next()) {
						// Tạo đối tượng UserObject để lưu trữ thông tin từ ResultSet
						item = new UserObject();

						// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
						item.setUser_id(rs.getInt("user_id"));
						item.setUser_parent_id(rs.getInt("user_parent_id"));
						item.setUser_email(rs.getString("user_email"));
						item.setUser_background_src(rs.getString("user_background_src"));
						item.setUser_background_avatar_src(rs.getString("user_background_avatar_src"));
						item.setUser_created_date(rs.getString("user_created_date"));
						item.setUser_recently_viewed(rs.getString("user_recently_viewed"));
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
						item.setUser_logged_in(rs.getBoolean("user_logged_in"));

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
			sql.append("SELECT * FROM tbluser WHERE user_email= ?");

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
						item.setUser_background_src(rs.getString("user_background_src"));
						item.setUser_background_avatar_src(rs.getString("user_background_avatar_src"));
						item.setUser_created_date(rs.getString("user_created_date"));
						item.setUser_recently_viewed(rs.getString("user_recently_viewed"));
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
						item.setUser_logged_in(rs.getBoolean("user_logged_in"));
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
		
		public UserObject getUserObjectByWorkSpaceId(UserObject similar, int id) {
			// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
			UserObject item = null;

			// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM tbluser WHERE working_space_id= ?");

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
						item = new UserObject();

						// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
						item.setUser_id(rs.getInt("user_id"));
						item.setUser_parent_id(rs.getInt("user_parent_id"));
						item.setUser_email(rs.getString("user_email"));
						item.setUser_background_src(rs.getString("user_background_src"));
						item.setUser_background_avatar_src(rs.getString("user_background_avatar_src"));
						item.setUser_created_date(rs.getString("user_created_date"));
						item.setUser_recently_viewed(rs.getString("user_recently_viewed"));
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
						item.setUser_logged_in(rs.getBoolean("user_logged_in"));
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

		public boolean addUser(UserObject item) {
			// Xây dựng câu truy vấn SQL để chèn dữ liệu vào bảng tbluser
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tbluser(");
			sql.append(
					"user_parent_id, user_email, user_background_src, user_background_avatar_src, user_created_date, user_recently_viewed, user_password, user_name, user_fullname, user_birthday, user_mobilephone, user_homephone, user_address, user_jobarea, user_job, user_roles, user_logged_in");
			sql.append(") ");
			sql.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			try {
				// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
				PreparedStatement pre = this.con.prepareStatement(sql.toString());

				// Truyền giá trị cho các tham số trong câu truy vấn từ đối tượng
				// UserObject
				pre.setInt(1, item.getUser_parent_id());
				pre.setString(2, item.getUser_email());
				pre.setString(3, item.getUser_background_src());
				pre.setString(4, item.getUser_background_avatar_src());
				pre.setString(5, item.getUser_created_date());
				pre.setString(6, item.getUser_recently_viewed());
				pre.setString(7, item.getUser_password());
				pre.setString(8, item.getUser_name());
				pre.setString(9, item.getUser_fullname());
				pre.setString(10, item.getUser_birthday());
				pre.setString(11, item.getUser_mobilephone());
				pre.setString(12, item.getUser_homephone());
				pre.setString(13, item.getUser_address());
				pre.setString(14, item.getUser_jobarea());
				pre.setString(15, item.getUser_job());
				pre.setString(16, item.getUser_roles());
				pre.setBoolean(17, item.isUser_logged_in());

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
		public boolean updateUser(UserObject item, int id) {
			// Xây dựng câu truy vấn SQL để cập nhật dữ liệu trong bảng tbluser
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tbluser SET ");
			sql.append("user_parent_id = ?, ");
			sql.append("user_email = ?, ");
			sql.append("user_background_src = ?, ");
			sql.append("user_background_avatar_src = ?, ");
			sql.append("user_created_date = ?, ");
			sql.append("user_recently_viewed = ?, ");
			sql.append("user_password = ?, ");
			sql.append("user_name = ?, ");
			sql.append("user_fullname = ?, ");
			sql.append("user_birthday = ?, ");
			sql.append("user_mobilephone = ?, ");
			sql.append("user_homephone = ?, ");
			sql.append("user_address = ?, ");
			sql.append("user_jobarea = ?, ");
			sql.append("user_job = ?, ");
			sql.append("user_roles = ?, ");
			sql.append("user_logged_in = ? ");
			sql.append("WHERE user_id = ?");

			try {
				// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
				PreparedStatement pre = this.con.prepareStatement(sql.toString());

				// Truyền giá trị cho các tham số trong câu truy vấn từ đối tượng
				// UserObject
				pre.setInt(1, item.getUser_parent_id());
				pre.setString(2, item.getUser_email());
				pre.setString(3, item.getUser_background_src());
				pre.setString(4, item.getUser_background_avatar_src());
				pre.setString(5, item.getUser_created_date());
				pre.setString(6, item.getUser_recently_viewed());
				pre.setString(7, item.getUser_password());
				pre.setString(8, item.getUser_name());
				pre.setString(9, item.getUser_fullname());
				pre.setString(10, item.getUser_birthday());
				pre.setString(11, item.getUser_mobilephone());
				pre.setString(12, item.getUser_homephone());
				pre.setString(13, item.getUser_address());
				pre.setString(14, item.getUser_jobarea());
				pre.setString(15, item.getUser_job());
				pre.setString(16, item.getUser_roles());
				pre.setBoolean(17, item.isUser_logged_in());
				pre.setInt(18, id);
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
		public boolean deleteUserById(UserObject item, int id) {
			// Câu truy vấn SQL để xóa bản ghi từ bảng tbluser dựa trên article_id
			String sql = "DELETE FROM tbluser WHERE user_id = ?";

			try {
				// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
				PreparedStatement pre = this.con.prepareStatement(sql);

				// Truyền giá trị cho tham số trong câu truy vấn từ đối tượng UserObject
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
			User u = new User();
			UserObject user = u.getUserObjectByWorkSpaceId(null, 1);
			System.out.println("user: " + user);
		}
}
