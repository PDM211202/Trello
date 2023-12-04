package IT6020003.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import IT6020003.ConnectionPool;
import IT6020003.ConnectionPoolImpl;
import IT6020003.objects.WorkObject;

public class Work {
	// kết nối để làm việc vs csdl
		private Connection con;

		// bộ quản lý kết nối của riêng section
		private ConnectionPool cp;

		public Work() {
			// xác định bộ quản lý kết nối
			this.cp = new ConnectionPoolImpl();

			// Xin kết nối để làm việc
			try {
				this.con = this.cp.getConnection("Work");

				// kiểm tra chế độ thực thi của kết nối
				if (this.con.getAutoCommit()) {
					this.con.setAutoCommit(false);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// Phương thức trả về danh sách tất cả các đối tượng ProjectObject từ cơ sở dữ liệu
		public ArrayList<WorkObject> getAllWorkObjects(WorkObject similar) {
			// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
			ArrayList<WorkObject> items = new ArrayList<>();
			WorkObject item;

			// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM work");

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
						item = new WorkObject();

						// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
						item.setWork_id(rs.getInt("work_id"));
						item.setWork_name(rs.getString("work_name"));
						item.setWork_position(rs.getInt("work_position"));
						item.setWork_create_date(rs.getString("work_create_date"));
						item.setProject_id(rs.getInt("project_id"));
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
		
		// Phương thức trả về danh sách tất cả các đối tượng ProjectObject từ cơ sở dữ liệu
				public ArrayList<WorkObject> getAllWorkObjectsByProjectId(WorkObject similar, int id) {
					// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
					ArrayList<WorkObject> items = new ArrayList<>();
					WorkObject item;

					// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
					StringBuilder sql = new StringBuilder();
					sql.append("SELECT * FROM work WHERE project_id = ?");

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
								item = new WorkObject();

								// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng ArticleObject
								item.setWork_id(rs.getInt("work_id"));
								item.setWork_name(rs.getString("work_name"));
								item.setWork_position(rs.getInt("work_position"));
								item.setWork_create_date(rs.getString("work_create_date"));
								item.setProject_id(rs.getInt("project_id"));
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
			Work w = new Work();


			ArrayList<WorkObject> items = w.getAllWorkObjectsByProjectId(null, 1);

			// In ra màn hình
			items.forEach(item -> {
				System.out.println(item);
			});
		}
}
