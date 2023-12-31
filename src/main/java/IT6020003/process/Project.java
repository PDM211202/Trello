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

	public ArrayList<ProjectObject> getAllProjectObjects(ProjectObject similar) {
		// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
		ArrayList<ProjectObject> items = new ArrayList<>();
		ProjectObject item;

		// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblproject");

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
					item.setWorking_space_id(rs.getInt("working_space_id"));
					item.setProject_create_date(rs.getString("project_create_date"));
					item.setProject_start_date(rs.getString("project_start_date"));
					item.setProject_end_date(rs.getString("project_end_date"));
					item.setProject_status(rs.getString("project_status"));
					item.setProject_background_src(rs.getString("project_background_src"));
					item.setProject_icon_url(rs.getString("project_icon_url"));

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

	public ArrayList<ProjectObject> getAllProjectObjectsByWorkSpaceId(ProjectObject similar, int id) {
		// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
		ArrayList<ProjectObject> items = new ArrayList<>();
		ProjectObject item;

		// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblproject WHERE working_space_id= ?");

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
					item = new ProjectObject();

					// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
					item.setProject_id(rs.getInt("project_id"));
					item.setProject_name(rs.getString("project_name"));
					item.setWorking_space_id(rs.getInt("working_space_id"));
					item.setProject_create_date(rs.getString("project_create_date"));
					item.setProject_start_date(rs.getString("project_start_date"));
					item.setProject_end_date(rs.getString("project_end_date"));
					item.setProject_status(rs.getString("project_status"));
					item.setProject_background_src(rs.getString("project_background_src"));
					item.setProject_icon_url(rs.getString("project_icon_url"));
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

	public boolean addProject(ProjectObject item) {
		// Xây dựng câu truy vấn SQL để chèn dữ liệu vào bảng tblproject
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tblproject(");
		sql.append(
				"project_name, working_space_id, project_create_date, project_start_date, project_end_date, project_status, project_background_src, project_icon_url");
		sql.append(") ");
		sql.append("VALUES(?,?,?,?,?,?,?,?)");

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			// Truyền giá trị cho các tham số trong câu truy vấn từ đối tượng
			// ProjectObject
			pre.setString(1, item.getProject_name());
			pre.setInt(2, item.getWorking_space_id());
			pre.setString(3, item.getProject_create_date());
			pre.setString(4, item.getProject_start_date());
			pre.setString(5, item.getProject_end_date());
			pre.setString(6, item.getProject_status());
			pre.setString(7, item.getProject_background_src());
			pre.setString(8, item.getProject_icon_url());

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
	public boolean updateProject(ProjectObject item, int id) {
		// Xây dựng câu truy vấn SQL để cập nhật dữ liệu trong bảng tblproject
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tblproject SET ");
		sql.append("project_name = ?, ");
		sql.append("working_space_id = ?, ");
		sql.append("project_create_date = ?, ");
		sql.append("project_start_date = ?, ");
		sql.append("project_end_date = ?, ");
		sql.append("project_status = ?, ");
		sql.append("project_background_src = ?, ");
		sql.append("project_icon_url = ? ");
		sql.append("WHERE project_id = ?");

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			// Truyền giá trị cho các tham số trong câu truy vấn từ đối tượng
			// ProjectObject
			pre.setString(1, item.getProject_name());
			pre.setInt(2, item.getWorking_space_id());
			pre.setString(3, item.getProject_create_date());
			pre.setString(4, item.getProject_start_date());
			pre.setString(5, item.getProject_end_date());
			pre.setString(6, item.getProject_status());
			pre.setString(7, item.getProject_background_src());
			pre.setString(8, item.getProject_icon_url());
			pre.setInt(9, id);
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
	public boolean deleteProjectById(ProjectObject item, int id) {
		// Câu truy vấn SQL để xóa bản ghi từ bảng tblproject dựa trên article_id
		String sql = "DELETE FROM tblproject WHERE project_id = ?";

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql);

			// Truyền giá trị cho tham số trong câu truy vấn từ đối tượng ProjectObject
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
