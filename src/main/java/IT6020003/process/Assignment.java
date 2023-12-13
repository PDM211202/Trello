package IT6020003.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import IT6020003.ConnectionPool;
import IT6020003.ConnectionPoolImpl;
import IT6020003.objects.AssignmentObject;

public class Assignment {
	// kết nối để làm việc vs csdl
	private Connection con;

	// bộ quản lý kết nối của riêng section
	private ConnectionPool cp;

	public Assignment() {
		// xác định bộ quản lý kết nối
		this.cp = new ConnectionPoolImpl();

		// Xin kết nối để làm việc
		try {
			this.con = this.cp.getConnection("Assignment");

			// kiểm tra chế độ thực thi của kết nối
			if (this.con.getAutoCommit()) {
				this.con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<AssignmentObject> getAllAssignmentObjects(AssignmentObject similar) {
		// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
		ArrayList<AssignmentObject> items = new ArrayList<>();
		AssignmentObject item;

		// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblassignment");

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
					item = new AssignmentObject();

					// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng AssignmentObject
					item.setAssignment_id(rs.getInt("assignment_id"));
					item.setUser_id(rs.getInt("user_id"));
					item.setTodo_id(rs.getInt("todo_id"));
					item.setAssignment_date(rs.getString("assignment_date"));
					// Thêm đối tượng AssignmentObject vào danh sách
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

		// Trả về danh sách các đối tượng AssignmentObject
		return items;
	}
	
	public ArrayList<AssignmentObject> getAllAssignmentObjectsByWorkSpaceId(AssignmentObject similar, int id) {
		// Khởi tạo một ArrayList để lưu trữ các đối tượng ProjectObject
		ArrayList<AssignmentObject> items = new ArrayList<>();
		AssignmentObject item;

		// Xây dựng câu truy vấn SQL để lấy tất cả dữ liệu từ bảng Project
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblassignment WHERE working_space_id= ?");

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
					item = new AssignmentObject();

					// Đọc dữ liệu từ ResultSet và set giá trị cho đối tượng AssignmentObject
					item.setAssignment_id(rs.getInt("assignment_id"));
					item.setUser_id(rs.getInt("user_id"));
					item.setTodo_id(rs.getInt("todo_id"));
					item.setAssignment_date(rs.getString("assignment_date"));
					// Thêm đối tượng AssignmentObject vào danh sách
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

		// Trả về danh sách các đối tượng AssignmentObject
		return items;
	}
	
	public boolean addAssignment(AssignmentObject item) {
	    // Xây dựng câu truy vấn SQL để chèn dữ liệu vào bảng tblassignment
	    StringBuilder sql = new StringBuilder();
	    sql.append("INSERT INTO tblassignment(");
	    sql.append("user_id, todo_id, assignment_date");
	    sql.append(") ");
	    sql.append("VALUES(?,?,?)");

	    try {
	        // Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
	        PreparedStatement pre = this.con.prepareStatement(sql.toString());
	        
	        // Truyền giá trị cho các tham số trong câu truy vấn từ đối tượng AssignmentObject
	        pre.setInt(1, item.getUser_id());
	        pre.setInt(2, item.getTodo_id());
	        pre.setString(3, item.getAssignment_date());

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
	public boolean updateArticle(AssignmentObject item, int id) {
	    // Xây dựng câu truy vấn SQL để cập nhật dữ liệu trong bảng tblassignment
	    StringBuilder sql = new StringBuilder();
	    sql.append("UPDATE tblassignment SET ");
	    sql.append("user_id = ?, ");
	    sql.append("todo_id = ?, ");
	    sql.append("assignment_date = ?, ");
	    sql.append("WHERE assignment_id = ?");

	    try {
	        // Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
	        PreparedStatement pre = this.con.prepareStatement(sql.toString());
	        
	        // Truyền giá trị cho các tham số trong câu truy vấn từ đối tượng AssignmentObject
	        pre.setInt(1, item.getUser_id());
	        pre.setInt(2, item.getTodo_id());
	        pre.setString(3, item.getAssignment_date());
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
	public boolean deleteAssignmentById(AssignmentObject item, int id) {
	    // Câu truy vấn SQL để xóa bản ghi từ bảng tblassignment dựa trên article_id
	    String sql = "DELETE FROM tblassignment WHERE assignment_id = ?";

	    try {
	        // Tạo đối tượng PreparedStatement để thực hiện câu truy vấn
	        PreparedStatement pre = this.con.prepareStatement(sql);
	        
	        // Truyền giá trị cho tham số trong câu truy vấn từ đối tượng AssignmentObject
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
