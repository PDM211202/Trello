package IT6020003.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import IT6020003.ConnectionPool;
import IT6020003.ConnectionPoolImpl;
import IT6020003.objects.CoverObject;

public class Cover {
	// kết nối để làm việc vs csdl
	private Connection con;

	// bộ quản lý kết nối của riêng section
	private ConnectionPool cp;

	public Cover() {
				// xác định bộ quản lý kết nối
				this.cp = new ConnectionPoolImpl();

				// Xin kết nối để làm việc
				try {
					this.con = this.cp.getConnection("Cover");

					// kiểm tra chế độ thực thi của kết nối
					if (this.con.getAutoCommit()) {
						this.con.setAutoCommit(false);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

	public ArrayList<CoverObject> getAllCoverObjects(CoverObject similar) {
		// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
		ArrayList<CoverObject> items = new ArrayList<>();
		CoverObject item;

		// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblcover");

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
					item = new CoverObject();

					// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
					item.setCover_id(rs.getInt("cover_id"));
					item.setTodo_id(rs.getInt("todo_id"));
					item.setCover_name(rs.getString("cover_name"));
					item.setCover_color(rs.getString("cover_color"));
					item.setCover_image_src(rs.getString("cover_image_src"));
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

	public ArrayList<CoverObject> getAllCoverObjectsByTodoId(CoverObject similar, int id) {
		// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
		ArrayList<CoverObject> items = new ArrayList<>();
		CoverObject item;

		// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblcover WHERE todo_id= ?");

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
					item = new CoverObject();

					// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
					item.setCover_id(rs.getInt("cover_id"));
					item.setTodo_id(rs.getInt("todo_id"));
					item.setCover_name(rs.getString("cover_name"));
					item.setCover_color(rs.getString("cover_color"));
					item.setCover_image_src(rs.getString("cover_image_src"));
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

	public boolean addCover(CoverObject item) {
		// Xây dựng câu truy vấn SQL để chèn dữ liệu vào bảng tblcover
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tblcover(");
		sql.append("todo_id, cover_name, cover_color, cover_image_src");
		sql.append(") ");
		sql.append("VALUES(?,?,?,?)");

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			// Truyền giá trị cho các tham số trong câu truy vấn từ đối tượng
			// CoverObject
			pre.setInt(1, item.getTodo_id());
			pre.setString(2, item.getCover_name());
			pre.setString(3, item.getCover_color());
			pre.setString(4, item.getCover_image_src());

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
	public boolean updateCover(CoverObject item, int id) {
		// Xây dựng câu truy vấn SQL để cập nhật dữ liệu trong bảng tblcover
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tblcover SET ");
		sql.append("todo_id = ?, ");
		sql.append("cover_name = ?, ");
		sql.append("cover_color = ?, ");
		sql.append("cover_image_src = ? ");
		sql.append("WHERE cover_id = ?");

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			// Truyền giá trị cho các tham số trong câu truy vấn từ đối tượng
			// CoverObject
			pre.setInt(1, item.getTodo_id());
			pre.setString(2, item.getCover_name());
			pre.setString(3, item.getCover_color());
			pre.setString(4, item.getCover_image_src());
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
	public boolean deleteCoverById(CoverObject item, int id) {
		// Câu truy vấn SQL để xóa bản ghi từ bảng tblcover dựa trên article_id
		String sql = "DELETE FROM tblcover WHERE cover_id = ?";

		try {
			// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
			PreparedStatement pre = this.con.prepareStatement(sql);

			// Truyền giá trị cho tham số trong câu truy vấn từ đối tượng CoverObject
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
