package IT6020003.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import IT6020003.ConnectionPool;
import IT6020003.ConnectionPoolImpl;
import IT6020003.objects.TagObject;

public class Tag {
	// kết nối để làm việc vs csdl
		private Connection con;

		// bộ quản lý kết nối của riêng section
		private ConnectionPool cp;

		public Tag() {
					// xác định bộ quản lý kết nối
					this.cp = new ConnectionPoolImpl();

					// Xin kết nối để làm việc
					try {
						this.con = this.cp.getConnection("Tag");

						// kiểm tra chế độ thực thi của kết nối
						if (this.con.getAutoCommit()) {
							this.con.setAutoCommit(false);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

		public ArrayList<TagObject> getAllTagObjects(TagObject similar) {
			// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
			ArrayList<TagObject> items = new ArrayList<>();
			TagObject item;

			// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM tbltag");

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
						item = new TagObject();

						// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
						item.setTag_id(rs.getInt("tag_id"));
						item.setTask_id(rs.getInt("task_id"));
						item.setTag_name(rs.getString("tag_name"));
						item.setTag_color(rs.getString("tag_color"));
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

		public ArrayList<TagObject> getAllTagObjectsByTaskId(TagObject similar, int id) {
			// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
			ArrayList<TagObject> items = new ArrayList<>();
			TagObject item;

			// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM tbltag WHERE task_id= ?");

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
						item = new TagObject();

						// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
						item.setTag_id(rs.getInt("tag_id"));
						item.setTask_id(rs.getInt("task_id"));
						item.setTag_name(rs.getString("tag_name"));
						item.setTag_color(rs.getString("tag_color"));
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

		public boolean addTag(TagObject item) {
			// Xây dựng câu truy vấn SQL để chèn dữ liệu vào bảng tbltag
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tbltag(");
			sql.append("task_id, tag_name, tag_color");
			sql.append(") ");
			sql.append("VALUES(?,?,?)");

			try {
				// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
				PreparedStatement pre = this.con.prepareStatement(sql.toString());

				// Truyền giá trị cho các tham số trong câu truy vấn từ đối tượng
				// TagObject
				pre.setInt(1, item.getTask_id());
				pre.setString(2, item.getTag_name());
				pre.setString(3, item.getTag_color());

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
		public boolean updateTag(TagObject item, int id) {
			// Xây dựng câu truy vấn SQL để cập nhật dữ liệu trong bảng tbltag
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tbltag SET ");
			sql.append("task_id = ?, ");
			sql.append("tag_name = ?, ");
			sql.append("tag_color = ? ");
			sql.append("WHERE tag_id = ?");

			try {
				// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
				PreparedStatement pre = this.con.prepareStatement(sql.toString());

				// Truyền giá trị cho các tham số trong câu truy vấn từ đối tượng
				// TagObject
				pre.setInt(1, item.getTask_id());
				pre.setString(2, item.getTag_name());
				pre.setString(3, item.getTag_color());
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
		public boolean deleteTagById(TagObject item, int id) {
			// Câu truy vấn SQL để xóa bản ghi từ bảng tbltag dựa trên article_id
			String sql = "DELETE FROM tbltag WHERE tag_id = ?";

			try {
				// Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
				PreparedStatement pre = this.con.prepareStatement(sql);

				// Truyền giá trị cho tham số trong câu truy vấn từ đối tượng TagObject
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
