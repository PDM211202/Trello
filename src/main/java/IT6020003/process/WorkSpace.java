package IT6020003.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import IT6020003.ConnectionPool;
import IT6020003.ConnectionPoolImpl;
import IT6020003.objects.WorkSpaceObject;

public class WorkSpace {
	// kết nối để làm việc vs csdl
	private Connection con;

	// bộ quản lý kết nối của riêng section
	private ConnectionPool cp;

	public WorkSpace() {
		// xác định bộ quản lý kết nối
		this.cp = new ConnectionPoolImpl();

		// Xin kết nối để làm việc
		try {
			this.con = this.cp.getConnection("WorkSpace");

			// kiểm tra chế độ thực thi của kết nối
			if (this.con.getAutoCommit()) {
				this.con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<WorkSpaceObject> getAllWorkSpaceObjects(WorkSpaceObject similar) {
		// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
		ArrayList<WorkSpaceObject> items = new ArrayList<>();
		WorkSpaceObject item;

		// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblworkspace");

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
					item = new WorkSpaceObject();

					// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
					item.setWorking_space_id(rs.getInt("working_space_id"));
					item.setWorking_space_name(rs.getString("working_space_name"));
					item.setUser_id(rs.getInt("user_id"));
					item.setWorking_space_create_date(rs.getString("working_space_create_date"));
					item.setWorking_space_background_src(rs.getString("working_space_background_src"));
					item.setWorking_space_avatar_src(rs.getString("working_space_avatar_src"));
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

	public ArrayList<WorkSpaceObject> getAllWorkSpaceObjectsByUserId(WorkSpaceObject similar, int id) {
		// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
		ArrayList<WorkSpaceObject> items = new ArrayList<>();
		WorkSpaceObject item;

		// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblworkspace WHERE user_id= ?");

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
					item = new WorkSpaceObject();

					// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
					item.setWorking_space_id(rs.getInt("working_space_id"));
					item.setWorking_space_name(rs.getString("working_space_name"));
					item.setUser_id(rs.getInt("user_id"));
					item.setWorking_space_create_date(rs.getString("working_space_create_date"));
					item.setWorking_space_background_src(rs.getString("working_space_background_src"));
					item.setWorking_space_avatar_src(rs.getString("working_space_avatar_src"));
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

	public boolean addWorkSpace(WorkSpaceObject item) {
		// Xây dựng câu truy vấn SQL để chèn dữ liệu vào bảng workspace
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tblworkspace(");
		sql.append(
				"working_space_name, user_id, working_space_create_date, working_space_background_src, working_space_avatar_src");
		sql.append(") ");
		sql.append("VALUES(?,?,?,?,?)");

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			// Truyền giá trị cho các tham số trong câu truy vấn từ đối tượng
			// WorkSpaceObject
			pre.setString(1, item.getWorking_space_name());
			pre.setInt(2, item.getUser_id());
			pre.setString(3, item.getWorking_space_create_date());
			pre.setString(4, item.getWorking_space_background_src());
			pre.setString(5, item.getWorking_space_avatar_src());
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
	public boolean updateWorkSpace(WorkSpaceObject item, int id) {
		// Xây dựng câu truy vấn SQL để cập nhật dữ liệu trong bảng workspace
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tblworkspace SET ");
		sql.append("working_space_name = ?, ");
		sql.append("user_id = ?, ");
		sql.append("working_space_create_date = ?, ");
		sql.append("working_space_background_src = ?, ");
		sql.append("working_space_avatar_src = ?, ");
		sql.append("WHERE working_space_id = ?");

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			// Truyền giá trị cho các tham số trong câu truy vấn từ đối tượng
			// WorkSpaceObject
			pre.setString(1, item.getWorking_space_name());
			pre.setInt(2, item.getUser_id());
			pre.setString(3, item.getWorking_space_create_date());
			pre.setString(4, item.getWorking_space_background_src());
			pre.setString(6, item.getWorking_space_avatar_src());
			pre.setInt(5, id);

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
	public boolean deleteWorkSpaceById(WorkSpaceObject item, int id) {
		// Câu truy vấn SQL để xóa bản ghi từ bảng workspace dựa trên article_id
		String sql = "DELETE FROM tblworkspace WHERE working_space_id = ?";

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql);

			// Truyền giá trị cho tham số trong câu truy vấn từ đối tượng WorkSpaceObject
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
		WorkSpaceObject w = new WorkSpaceObject();
		w.setWorking_space_name("WS1");
		w.setUser_id(1);
		WorkSpace ws = new WorkSpace();

		if (!ws.addWorkSpace(w)) {
			System.out.println("-----KHÔNG THÀNH CÔNG-----");
		}

		// Lấy danh sách đối tượng
		ArrayList<WorkSpaceObject> items = ws.getAllWorkSpaceObjects(null);

		// In ra màn hình
		items.forEach(item -> {
			System.out.println(item);
		});
	}
}
