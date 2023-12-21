package IT6020003.view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import IT6020003.objects.ProjectObject;
import IT6020003.objects.UserObject;
import IT6020003.objects.WorkSpaceObject;
import IT6020003.process.Project;
import IT6020003.process.User;
import IT6020003.process.WorkSpace;

/**
 * Servlet implementation class HomeView
 */
@WebServlet("/home/view")
public class HomeView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);

		String email = request.getParameter("email");

		User u = new User();
		PrintWriter out = response.getWriter();
		UserObject items = u.getUserObjectByEmail(null, email);

		out.append("<!doctype html>");
		out.append("<html lang=\"en\">");

		out.append("<head>");
		out.append("    <!-- Required meta tags -->");
		out.append("    <meta charset=\"utf-8\">");
		out.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.append("    <!-- Bootstrap CSS -->");
		out.append(
				"    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"");
		out.append(
				"        integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
		out.append("    <title>Hello, world!</title>");
		out.append("    <link rel=\"stylesheet\" href=\"/itad/css/home.css\">");
		out.append("</head>");

		out.append("<body>");
		out.append("    <header>");
		out.append("    </header>");
		out.append("    <div class=\"container\">");
		out.append("        <div class=\"home row\">");
		out.append("            <div class=\"home__left col-3\">");
		out.append("                <ul class=\"list-group\">");
		out.append("                    <li class=\"list-group-item d-flex mt-2 active\">");
		out.append("                        <i class=\"fa fa-list-alt\"></i>");
		out.append("                        <p>Bảng</p>");
		out.append("                    </li>");
		out.append("                    <li class=\"list-group-item d-flex mt-2\">");
		out.append("                        <i class=\"fa fa-columns\"></i>");
		out.append("                        <p>Mẫu</p>");
		out.append("                    </li>");
		out.append("                    <li class=\"list-group-item d-flex mt-2\">");
		out.append("                        <i class=\"fa fa-home\"></i>");
		out.append("                        <p>Trang chủ</p>");
		out.append("                    </li>");
		out.append("                </ul>");
		out.append("                <div class=\"line\"></div>");
		out.append("                <ul class=\"list-group mt-3\">");
		out.append("                    <div class=\"menu_work_space\">");
		out.append("                        <p>Các không gian làm việc</p>");
		out.append(
				"                        <i data-bs-toggle=\"modal\" data-bs-target=\"#WorkSpaceModal\" class=\"fa fa-plus\"></i>");
		out.append(this.addWorkSpace(items));
		out.append("                    </div>");

		WorkSpace ws = new WorkSpace();
		ArrayList<WorkSpaceObject> list_ws = ws.getAllWorkSpaceObjectsByUserId(null, items.getUser_id());
		list_ws.forEach(item_ws -> {
			out.append("                    <li class=\"list-group-item\">");
			out.append("                        <div >");
			out.append("                        	<a class=\"d-flex\" href=\"http://localhost:8080/itad/WorkspaceView?workspace_id="+item_ws.getWorking_space_id()+"\">");
			out.append("                            	<img class=\"img_lg\" style=\"width: 24px; height: 24px;\" src=\""+ item_ws.getWorking_space_avatar_src() + "\" alt=\"\">");
			out.append("                            	<p class=\"m-0\">" + item_ws.getWorking_space_name() + "</p>");
			out.append("                        	</a>");
			out.append("                        </div>");
			out.append("                    </li>");
		});

		out.append("                </ul>");
		out.append("            </div>");
		out.append("            <div class=\"home__right col-9\">");
		out.append("                <div class=\"tick__star hide\">");
		out.append("                    <div class=\"tick__star__header d-flex\">");
		out.append("                        <i class=\"fa fa-star\"></i>");
		out.append(
				"                        <h3 style=\"font-size: 16px; font-weight: bold; margin: 20px 0;\">Bảng Đánh Dấu Sao</h3>");
		out.append("                    </div>");
		out.append("                    <div class=\"tick__star__body row\">");
		out.append("                        <div class=\"working_space_list_item col-3\" style=\"background-image:");
		out.append(
				"                            url(/itad/img/melody_wallpaper_by_kj_designer_dan9r5u-fullview.jpg);\">");
		out.append(
				"                            <a href=\"http://localhost:8080/itad/ProjectView?project_id=1\">Work</a>");
		out.append("                        </div>");
		out.append("                        <div class=\"working_space_list_item col-3\" style=\"background-image:");
		out.append(
				"                            url(/itad/img/melody_wallpaper_by_kj_designer_dan9r5u-fullview.jpg);\">");
		out.append(
				"                            <a href=\"http://localhost:8080/itad/ProjectView?project_id=1\">Work</a>");
		out.append("                        </div>");
		out.append("                    </div>");
		out.append("                </div>");
		out.append("                <div class=\"working__space\">");
		out.append(
				"                    <h3 style=\"font-size: 16px; font-weight: bold; margin: 20px 0;\">CÁC KHÔNG GIAN LÀM VIỆC CỦA BẠN</h3>");

		list_ws.forEach(item_ws -> {
			out.append("                    <div class=\"working_space_header row mb-5\">");
			out.append("                        <div class=\"working_space_name col-4 d-flex\">");
			out.append(
					"                            <img class=\"img_lg\" src=\"http://localhost:8080/itad/img/logo.png\" alt=\"\">");
			out.append("                            <h3 style=\"font-size: 16px;\">" + item_ws.getWorking_space_name()
					+ "</h3>");
			out.append("                        </div>");
			out.append(
					"                        <div class=\"working_space_options col-8 d-flex justify-content-end mb-3\">");
			out.append("                            <div class=\"option__item d-flex\">");
			
			out.append("                            	<a href=\"http://localhost:8080/itad/WorkspaceView?workspace_id="+item_ws.getWorking_space_id()+"#board\" class=\"d-flex\">");
			out.append("                                	<i class=\"fa fa-list-alt\"></i>");
			out.append("                                	<p>Bảng</p>");
			out.append("                                </a>");
			out.append("                            </div>");
			out.append("                            <div class=\"option__item d-flex\">");
			out.append("                                <i class=\"fa fa-grip-vertical\"></i>");
			out.append("                                <p>Dạng xem</p>");
			out.append("                            </div>");
			out.append("                            <div class=\"option__item d-flex\">");
			out.append("                            	<a href=\"http://localhost:8080/itad/WorkspaceView?workspace_id="+item_ws.getWorking_space_id()+"#member\" class=\"d-flex\">");
			out.append("                                	<i class=\"fa fa-user\"></i>");
			out.append("                                	<p>Thành viên</p>");
			out.append("                                </a>");
			out.append("                            </div>");
			out.append("                            <div class=\"option__item d-flex\">");
			out.append("                            	<a href=\"http://localhost:8080/itad/WorkspaceView?workspace_id="+item_ws.getWorking_space_id()+"#setting\" class=\"d-flex\">");
			out.append("                                	<i class=\"fa fa-cog\"></i>");
			out.append("                                	<p>Cài đặt</p>");
			out.append("                                </a>");
			out.append("                            </div>");
			out.append("                        </div>");

			Project p = new Project();
			ArrayList<ProjectObject> list_p = p.getAllProjectObjectsByWorkSpaceId(null, item_ws.getWorking_space_id());
			list_p.forEach(item_p -> {
				out.append(
						"                        <div class=\"working_space_list_item col-3\" style=\"background-image:");
				out.append("                            url(http://localhost:8080/itad/img/background.jpg);\">");
				out.append("                            <a href=\"http://localhost:8080/itad/ProjectView?project_id="
						+ item_p.getProject_id() + "\">" + item_p.getProject_name() + "</a>");
				out.append("                        </div>");
			});

			out.append(this.addProject(item_ws.getWorking_space_id()));
			out.append("                    </div>");
		});

		out.append("                </div>");
		out.append("            </div>");
		out.append("        </div>");
		out.append("    </div>");
		out.append("    <script src=\"/itad/js/index.js\"></script>");
		out.append("    <!-- Optional JavaScript; choose one of the two! -->");
		out.append("    <!-- Option 1: Bootstrap Bundle with Popper -->");
		out.append("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"");
		out.append("        integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\"");
		out.append("        crossorigin=\"anonymous\"></script>");
		out.append("    <!-- Option 2: Separate Popper and Bootstrap JS -->");
		out.append("    <!--");
		out.append(
				"    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js\" integrity=\"sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB\" crossorigin=\"anonymous\"></script>");
		out.append(
				"    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js\" integrity=\"sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13\" crossorigin=\"anonymous\"></script>");
		out.append("    -->");
		out.append("</body>");

		out.append("</html>");

	}

	private StringBuilder addWorkSpace(UserObject user) {
		StringBuilder out = new StringBuilder();
		out.append(
				"<div class=\"modal fade\" id=\"WorkSpaceModal\" tabindex=\"-1\" aria-labelledby=\"WorkSpaceModalLabel\" aria-hidden=\"true\">");
		out.append("    <div class=\"modal-dialog\">");
		out.append("        <div class=\"modal-content\">");
		out.append("            <div class=\"modal-header\">");
		out.append(
				"                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>");
		out.append("            </div>");
		out.append("            <div class=\"modal-body\">");
		out.append(
				"                <form action=\"/itad/HomeView?email=" + user.getUser_email() + "\" method=\"post\">");
		out.append("                    <h3>Hãy xây dựng một không gian làm việc</h3>");
		out.append("                    <p>Tên không gian làm việc</p>");
		out.append(
				"                    <input type=\"text\" name=\"working_space_name\" id=\"\" placeholder=\"Công ty của ...\">");
		out.append("                    <span>Đây là tên công ty, nhóm hoặc tổ chức của bạn.</span>");
		out.append("                    <p>Mô tả không gian làm việc</p>");
		out.append("                    <textarea name=\"working_space\" id=\"\" rows=\"10\"></textarea>");
		out.append(
				"                    <span>Đưa các thành viên của bạn vào bảng với mô tả ngắn về Không gian làm việc của bạn.</span>");
		out.append("            		<div class=\"modal-footer\">");
		out.append(
				"                		<button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Close</button>");
		out.append("                		<button type=\"submit\" class=\"btn btn-primary\">Save changes</button>");
		out.append("            		</div>");
		out.append("                </form>");
		out.append("            </div>");
		out.append("        </div>");
		out.append("    </div>");
		out.append("</div>");

		return out;
	}

	private StringBuilder addProject(int ws_id) {
		StringBuilder out = new StringBuilder();
		out.append(
				"                        <div class=\"working_space_list_item col-3\" style=\"position: relative; background-color: #091e420f;\">");
		out.append(
				"                            <span id=\""+ws_id+"\" data-bs-toggle=\"modal\" data-bs-target=\"#ProjectModal\" style=\"cursor: pointer; width: 100%; height: 100%; display: inline-block; text-align: center; line-height: 110px;\">Tạo bảng mới "+ws_id+"</span>");
		out.append(
				"<div class=\"modal fade\" id=\"ProjectModal\" tabindex=\"-1\" aria-labelledby=\"ProjectModalLabel\" aria-hidden=\"true\">");
		out.append("    <div class=\"modal-dialog\">");
		out.append("        <div class=\"modal-content\">");
		out.append("            <div class=\"modal-header\">");
		out.append("            	<h4>Tạo bảng<h4>");
		out.append(
				"                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>");
		out.append("            </div>");
		out.append("            <div class=\"modal-body\">");
		out.append("                <form action=\"http://localhost:8080/itad/HomeView?email=user1@gmail.com\" method=\"post\">");
		out.append("            		<div class=\"body-header mb-4\">");
		out.append(
				"            			<div class=\"modal-img mb-3\" style=\"background-image: url(http://localhost:8080/itad/img/background.jpg);\">");
		out.append("            				<img src=\"https://trello.com/assets/14cda5dc635d1f13bc48.svg\">");
		out.append("            			</div>");
		out.append("						<input type='hidden' name='workspace_id'>");
		out.append("						<input type='hidden' name='backgroundImage' id='backgroundImageInput'>");
		out.append("            			<span>Phông nền</span>");
		out.append("            			<div class=\"project_bg\">");
		out.append(
				"            				<div class=\"bg_item\" style=\"background-image: url(http://localhost:8080/itad/img/project_bg_1.png);\">");
		out.append("            				</div>");
		out.append(
				"            				<div class=\"bg_item\" style=\"background-image: url(http://localhost:8080/itad/img/project_bg_2.jpg);\">");
		out.append("            				</div>");
		out.append(
				"            				<div class=\"bg_item\" style=\"background-image: url(http://localhost:8080/itad/img/project_bg.jpg);\">");
		out.append("            				</div>");
		out.append(
				"            				<div class=\"bg_item\" style=\"background-image: url(http://localhost:8080/itad/img/background.jpg);\">");
		out.append("            				</div>");
		out.append("            			</div>");
		out.append("            			<span>Tiêu đề bảng</span>");
		out.append("                    	<input class=\"m-3\" type=\"text\" value=\"demo "+ws_id+"\" name=\"project_name\" id=\"\">");
		out.append("            		</div>");
		out.append("            		<div class=\"modal-footer\">");
		out.append(
				"                		<button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Close</button>");
		out.append("                		<button type=\"submit\" class=\"btn btn-primary\">Tạo mới</button>");
		out.append("            		</div>");
		out.append("                </form>");
		out.append("            </div>");
		out.append("        </div>");
		out.append("    </div>");
		out.append("</div>");
		out.append("                       </div>");

		return out;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Đặt kiểu nội dung và charset cho phản hồi
		response.setContentType(CONTENT_TYPE);

		// Lấy dữ liệu từ form
		String workingSpaceName = request.getParameter("working_space_name");
		User u = new User();
		String email = request.getParameter("email");
        UserObject items = u.getUserObjectByEmail(null, email);
		
		if (workingSpaceName != null && !workingSpaceName.trim().isEmpty()) {
	        // Nếu workingSpaceName hợp lệ, tiếp tục xử lý
	        
	        
	        
	        // Tạo đối tượng WorkSpaceObject và thiết lập các giá trị
	        WorkSpaceObject wsObject = new WorkSpaceObject();
	        wsObject.setWorking_space_name(workingSpaceName);
	        if (items != null) {
	            wsObject.setUser_id(items.getUser_id());
	            wsObject.setWorking_space_avatar_src(items.getUser_background_avatar_src());
	        }

	        // Tạo đối tượng WorkSpace để xử lý logic nghiệp vụ
	        WorkSpace ws = new WorkSpace();
	        boolean isSuccess = ws.addWorkSpace(wsObject);

	        if (isSuccess) {
	            // Chuyển hướng đến trang thành công
	            response.sendRedirect("http://localhost:8080/itad/HomeView?email=" + items.getUser_email());
	        } else {
	            // Xử lý trường hợp thêm không thành công
	            // Ví dụ: hiển thị thông báo lỗi
	        }
	    } else {
	    	String backgroundImage = request.getParameter("backgroundImage");
	    	String workspaceId = request.getParameter("workspace_id");
	    	String project_name = request.getParameter("project_name");
	    	
	    	ProjectObject pObject = new ProjectObject();
	    	pObject.setProject_background_src(backgroundImage);
	    	pObject.setProject_name(project_name);
	    	pObject.setWorking_space_id(Integer.parseInt(workspaceId));
	    	System.out.println("workspace_id: " + workspaceId);
	    	Project p = new Project();
	    	boolean isSuccess = p.addProject(pObject);
	    	if (isSuccess) {
	            // Chuyển hướng đến trang thành công
	            response.sendRedirect("http://localhost:8080/itad/HomeView?email=" + items.getUser_email());
	        } else {
	            // Xử lý trường hợp thêm không thành công
	            // Ví dụ: hiển thị thông báo lỗi
	        }
	    }

		
		doGet(request, response);
	}

}
