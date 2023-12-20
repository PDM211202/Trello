package IT6020003.view;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import IT6020003.objects.ProjectObject;
import IT6020003.objects.WorkSpaceObject;
import IT6020003.process.Project;
import IT6020003.process.WorkSpace;

/**
 * Servlet implementation class WorkspaceView
 */
public class WorkspaceView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkspaceView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		
		String WorkspaceId = request.getParameter("workspace_id");
		WorkSpace ws = new WorkSpace();
		WorkSpaceObject wsObject = ws.getAllWorkSpaceObjectsById(null, Integer.parseInt(WorkspaceId));
		
		out.append("<!doctype html>");
		out.append("<html lang=\"en\">");
		out.append("");
		out.append("<head>");
		out.append("    <!-- Required meta tags -->");
		out.append("    <meta charset=\"utf-8\">");
		out.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.append("");
		out.append("    <!-- Bootstrap CSS -->");
		out.append("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"");
		out.append("        integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
		out.append("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css\"");
		out.append("        integrity=\"sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==\"");
		out.append("        crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />");
		out.append("    <title>Hello, world!</title>");
		out.append("");
		out.append("    <link rel=\"stylesheet\" href=\"/itad/css/project.css\">");
		out.append("    <link rel=\"stylesheet\" href=\"/itad/css/workspace.css\">");
		out.append("</head>");
		out.append("");
		out.append("<body>");
		out.append("    <div class=\"container-fluid\">");
		out.append("        <div class=\"row\">");
		out.append("            <nav class=\"menu p-0 col\">");
		out.append("                <div class=\"menu__header\">");
		out.append("                    <div class=\"menu__header__left\">");
		out.append("                        <img src=\"/itad/img/logo.png\" alt=\"\">");
		out.append("                    </div>");
		out.append("                    <div class=\"menu__header__mid\">");
		out.append("                        <p>"+wsObject.getWorking_space_name()+"</p>");
		out.append("                        <span>Miễn phí</span>");
		out.append("                    </div>");
		out.append("                    <div class=\"menu__header__right\">");
		out.append("                        <div>");
		out.append("                            <i class=\"fa fa-angle-left\"></i>");
		out.append("                        </div>");
		out.append("                    </div>");
		out.append("                </div>");
		out.append("                <div class=\"menu__mid pt-1 mb-3\">");
		out.append("                    <div class=\"menu__mid__item\">");
		out.append("                        <i class=\"fa fa-table\"></i>");
		out.append("                        <span>Bảng</span>");
		out.append("                    </div>");
		out.append("                    <div class=\"menu__mid__item\">");
		out.append("                        <i class=\"fa fa-user\"></i>");
		out.append("                        <span>Thành viên</span>");
		out.append("                        <i class=\"fa fa-plus user__add\" data-bs-toggle=\"modal\" data-bs-target=\"#AddMemberModal\"></i>");
		out.append("                    </div>");
		out.append("                    <div class=\"menu__mid__item\">");
		out.append("                        <i class=\"fa fa-cog\"></i>");
		out.append("                        <span>Cài đặt</span>");
		out.append("                    </div>");
		out.append("                </div>");
		out.append("                <div class=\"menu__bottom\">");
		out.append("                    <div class=\"menu__bottom__title\">");
		out.append("                        <p>Các bảng của bạn</p>");
		out.append("                        <i data-bs-toggle=\"modal\" data-bs-target=\"#WorkSpaceModal\" class=\"fa fa-plus\"></i>");
		out.append("                    </div>");
		out.append("                    <ul class=\"list-group\">");
		
		Project p = new Project();
		ArrayList<ProjectObject> list_p = p.getAllProjectObjectsByWorkSpaceId(null, wsObject.getWorking_space_id());
		list_p.forEach(item_p -> {
			out.append("                        <li class=\"list-group-item-p\" aria-current=\"true\"> <a");
			out.append("                                href=\"/itad/ProjectView?project_id="+item_p.getProject_id()+"\"");
			out.append("                                style=\"color: #9fadbc; text-decoration: none;\"><img src=\"/itad/img/logo.png\" alt=\"\">" + "  " + item_p.getProject_name()+"</a></li>");
		});
		
		
		
		out.append("                    </ul>");
		out.append("                </div>");
		out.append("            </nav>");
		out.append("            <div class=\"content col\">");
		out.append("                <div class=\"content_header row\">");
		out.append("                    <div class=\"user_avatar col-2 p-0\">");
		out.append("                        <img src=\"/itad/img/logo.png\" alt=\"\">");
		out.append("                    </div>");
		out.append("                    <div class=\"workspace_name col-5 d-flex\">");
		out.append("                        <h3>"+wsObject.getWorking_space_name()+"</h3>");
		out.append("                        <i class=\"fa fa-edit edit_workspace\"></i>");
		out.append("                    </div>");
		out.append("<div class=\"workspace_update hide col-5\">");
		out.append("    <form action=\"/itad/WorkspaceView?workspace_id="+wsObject.getWorking_space_id()+"\" method=\"post\" class=\"d-flex\">");
		out.append("        <input type=\"text\" name=\"ws_name\" id=\"\">");
		out.append("        <div class=\"btn-option\">");
		out.append("            <button type=\"submit\" class=\"btn btn-primary\">Lưu</button>");
		out.append("            <button type=\"button\" class=\"btn close\">Hủy</button>");
		out.append("        </div>");
		out.append("    </form>");
		out.append("</div>");
		out.append("                    <div class=\"add_member col-5\">");
		out.append("                        <button type=\"button\" class=\"btn btn-primary\" data-bs-toggle=\"modal\"");
		out.append("                            data-bs-target=\"#AddMemberModal\">");
		out.append("                            <i class=\"fa fa-user-plus\"></i>");
		out.append("                            <span>Mời các thành viên vào Không gian làm việc</span>");
		out.append("                        </button>");
		out.append("                    </div>");
		out.append("                </div>");
		out.append("                <div id=\"board\" class=\"list_project mt-5\">");
		out.append("                    <h4 class=\"list_project_title mb-4\">Bảng</h4>");
		out.append("                    <div class=\"project_group row \">");
		out.append("                        <div data-bs-toggle=\"modal\" data-bs-target=\"#ProjectModal\" class=\"project_item_create col-4\">");
		out.append("                            <span>Tạo bảng mới</span>");
		out.append("                        </div>");
		out.append(this.addProject(wsObject.getWorking_space_id()));
		
		list_p.forEach(item_p -> {
			out.append("                        <div style=\"background-image: url("+item_p.getProject_background_src()+");\" class=\"project_item col-4\">");
			out.append("                            <a href=\"/itad/ProjectView?project_id="+item_p.getProject_id()+"\" class=\"project_name\">");
			out.append("                                "+item_p.getProject_name()+"");
			out.append("                            </a>");
			out.append("                        </div>");
		});
		
		out.append("                    </div>");
		out.append("                </div>");
		out.append("");
		out.append("                <div id=\"member\" class=\"list_project mt-5\">");
		out.append("                    <h4 class=\"list_member_title mb-4\">Thành viên</h4>");
		out.append("                    <h4 class=\"list_member_title mb-4\">Các thành viên trong không gian làm việc (1)</h4>");
		out.append("                    <p>Các thành viên trong Không gian làm việc có thể xem và tham gia tất cả các bảng Không gian làm");
		out.append("                        việc hiển thị và tạo ra các bảng mới trong Không gian làm việc.</p>");
		out.append("                    <div class=\"member_group\">");
		out.append("                        <div class=\"member_list mb-3 row\">");
		out.append("                            <div class=\"member_item_left d-flex col\">");
		out.append("                                <div class=\"logo_user\">");
		out.append("                                    <img src=\"/itad/img/logo.png\" alt=\"\">");
		out.append("                                </div>");
		out.append("                                <div class=\"name_user\">");
		out.append("                                    <p>Phó Đình Mạnh</p>");
		out.append("                                    <span>phodinhmanh2002@gmail.com</span>");
		out.append("                                </div>");
		out.append("                            </div>");
		out.append("                            <div class=\"member_item_right col\">");
		out.append("                                <button type=\"button\" class=\"btn btn-danger\">");
		out.append("                                    <i class=\"fa fa-times\"></i>");
		out.append("                                    Rời đi");
		out.append("                                </button>");
		out.append("                            </div>");
		out.append("                        </div>");
		out.append("                        <div class=\"member_list mb-3\">");
		out.append("                            <div class=\"member_item_left d-flex\">");
		out.append("                                <div class=\"logo_user\">");
		out.append("                                    <img src=\"/itad/img/logo.png\" alt=\"\">");
		out.append("                                </div>");
		out.append("                                <div class=\"name_user\">");
		out.append("                                    <p>Phó Đình Mạnh</p>");
		out.append("                                    <span>phodinhmanh2002@gmail.com</span>");
		out.append("                                </div>");
		out.append("                            </div>");
		out.append("                        </div>");
		out.append("                    </div>");
		out.append("                </div>");
		out.append("");
		out.append("                <div id=\"setting\" class=\"list_project mt-5\">");
		out.append("                    <h4 class=\"list_setting_title mb-4\">Cài đặt</h4>");
		out.append("                    <!-- Button trigger modal -->");
		out.append("                    <button type=\"button\" class=\"btn btn-danger\" data-bs-toggle=\"modal\" data-bs-target=\"#DeleteWorkSpaceModal\">");
		out.append("                        Xóa không gian làm việc này?");
		out.append("                    </button>");
		out.append("");
		out.append("                    <!-- Modal -->");
		out.append("                    <div class=\"modal fade\" id=\"DeleteWorkSpaceModal\" tabindex=\"-1\" aria-labelledby=\"DeleteWorkSpaceModalLabel\"");
		out.append("                        aria-hidden=\"true\">");
		out.append("                        <div class=\"modal-dialog\">");
		out.append("                            <div class=\"modal-content\">");
		out.append("                                <div class=\"modal-header\">");
		out.append("                                    <h5 class=\"modal-title\" id=\"DeleteWorkSpaceModalLabel\">Xóa không gian làm việc?</h5>");
		out.append("                                    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"");
		out.append("                                        aria-label=\"Close\"></button>");
		out.append("                                </div>");
		out.append("                                <div class=\"modal-body\">");
		out.append("                                    <h4>Nhập tên không gian làm việc \"PDM\" để xóa</h4>");
		out.append("                                    <span>Những điều cần biết:</span>");
		out.append("                                    <ul>");
		out.append("                                        <li>Điều này là vĩnh viễn và không thể hoàn tác.</li>");
		out.append("                                        <li>Tất cả các bảng trong Không gian làm việc này sẽ bị đóng.</li>");
		out.append("                                        <li>Các quản trị viên bảng có thể mở lại các bảng.</li>");
		out.append("                                        <li>Các thành viên bảng sẽ không thể tương tác với các bảng đã đóng.</li>");
		out.append("                                    </ul>");
		out.append("                                    <span>Nhập tên không gian làm việc để xóa</span>");
		out.append("                                    <form action=\"\" method=\"post\">");
		out.append("                                        <input type=\"text\" name=\"workspace_name\" id=\"\">");
		out.append("                                        <button type=\"submit\" class=\"btn btn-danger\">Xóa không gian làm việc</button>");
		out.append("                                    </form>");
		out.append("                                </div>");
		out.append("                            </div>");
		out.append("                        </div>");
		out.append("                    </div>");
		out.append("                </div>");
		out.append("            </div>");
		out.append("        </div>");
		out.append("    </div>");
		out.append("");
		out.append("    <!-- Modal -->");
		out.append("    <div class=\"modal fade\" id=\"AddMemberModal\" tabindex=\"-1\" aria-labelledby=\"AddMemberModalLabel\" aria-hidden=\"true\">");
		out.append("        <div class=\"modal-dialog\">");
		out.append("            <div class=\"modal-content\">");
		out.append("                <div class=\"modal-header\">");
		out.append("                    <h5 class=\"modal-title\" id=\"AddMemberModalLabel\">Mời vào không gian làm việc</h5>");
		out.append("                    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>");
		out.append("                </div>");
		out.append("                <div class=\"modal-body\">");
		out.append("                    <input type=\"text\" name=\"user_name\" id=\"\" placeholder=\"Địa chỉ email hoặc tên\">");
		out.append("                </div>");
		out.append("                <div class=\"modal-footer\">");
		out.append("                    <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Close</button>");
		out.append("                    <button type=\"button\" class=\"btn btn-primary\">Thêm</button>");
		out.append("                </div>");
		out.append("            </div>");
		out.append("        </div>");
		out.append("    </div>");
		out.append("");
		out.append("    <!-- Modal -->");
		out.append("    <div class=\"modal fade\" id=\"WorkSpaceModal\" tabindex=\"-1\" aria-labelledby=\"WorkSpaceModalLabel\" aria-hidden=\"true\">");
		out.append("        <div class=\"modal-dialog\">");
		out.append("            <div class=\"modal-content\">");
		out.append("                <div class=\"modal-header\">");
		out.append("                    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>");
		out.append("                </div>");
		out.append("                <div class=\"modal-body\">");
		out.append("                    <form action=\"\" method=\"post\">");
		out.append("                        <h3>Hãy xây dựng một không gian làm việc</h3>");
		out.append("                        <p>Tên không gian làm việc</p>");
		out.append("                        <input type=\"text\" name=\"working_space_name\" id=\"\" placeholder=\"Công ty của ...\">");
		out.append("                        <span>Đây là tên công ty, nhóm hoặc tổ chức của bạn.</span>");
		out.append("                        <p>Mô tả không gian làm việc</p>");
		out.append("                        <textarea name=\"working_space\" id=\"\" rows=\"10\"></textarea>");
		out.append("                        <span>Đưa các thành viên của bạn vào bảng với mô tả ngắn về Không gian làm việc của bạn.</span>");
		out.append("                    </form>");
		out.append("                </div>");
		out.append("                <div class=\"modal-footer\">");
		out.append("                    <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Close</button>");
		out.append("                    <button type=\"button\" class=\"btn btn-primary\">Save changes</button>");
		out.append("                </div>");
		out.append("            </div>");
		out.append("        </div>");
		out.append("    </div>");
		out.append("");
		out.append("    <script src=\"/itad/js/index.js\"></script>");
		out.append("    <script src=\"/itad/js/workspace.js\"></script>");
		out.append("");
		out.append("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"");
		out.append("        integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\"");
		out.append("        crossorigin=\"anonymous\"></script>");
		out.append("</body>");
		out.append("");
		out.append("</html>");


	}
	
	private StringBuilder addProject(int ws_id) {
		StringBuilder out = new StringBuilder();
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
		out.append("                <form action=\"/itad/WorkspaceView?workspace_id="+ws_id+"\" method=\"post\">");
		out.append("            		<div class=\"body-header mb-4\">");
		out.append(
				"            			<div class=\"modal-img mb-3\" style=\"background-image: url(http://localhost:8080/itad/img/background.jpg);\">");
		out.append("            				<img src=\"https://trello.com/assets/14cda5dc635d1f13bc48.svg\">");
		out.append("            			</div>");
		out.append("						<input type='hidden' value=\"http://localhost:8080/itad/img/project_bg_2.jpg\" name='backgroundImage' id='backgroundImageInput'>");
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

		return out;
	}
	
	protected void updateWorkSpaceName(String WorkspaceId, String WorkspaceName) {
		WorkSpace ws = new WorkSpace();
		WorkSpaceObject wsObject = ws.getAllWorkSpaceObjectsById(null, Integer.parseInt(WorkspaceId));
		wsObject.setWorking_space_name(WorkspaceName);
		
		if (!ws.updateWorkSpace(wsObject)) {
			System.out.println("-----KHÔNG THÀNH CÔNG-----");
		}
	}
	
	protected void addProject(String WorkspaceId, String ProjectName, String backgroundImage) {
		Project p = new Project();
		ProjectObject pObject = new ProjectObject();
		pObject.setProject_name(ProjectName);
		pObject.setWorking_space_id(Integer.parseInt(WorkspaceId));
		pObject.setProject_background_src(backgroundImage);
		
		if (!p.addProject(pObject)) {
			System.out.println("-----KHÔNG THÀNH CÔNG-----");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String WorkspaceId = request.getParameter("workspace_id");
		String WorkspaceName = request.getParameter("ws_name");
		String ProjectName = request.getParameter("project_name");
		String backgroundImage = request.getParameter("backgroundImage");

		if (WorkspaceName != "" && WorkspaceName != null) {
			updateWorkSpaceName(WorkspaceId, WorkspaceName);
			response.sendRedirect("http://localhost:8080/itad/WorkspaceView?workspace_id=" + WorkspaceId);
		}
		
		if (ProjectName != "" && ProjectName != null) {
			addProject(WorkspaceId, ProjectName, backgroundImage);
			response.sendRedirect("http://localhost:8080/itad/WorkspaceView?workspace_id=" + WorkspaceId);
		}
		
		doGet(request, response);
	}

}
