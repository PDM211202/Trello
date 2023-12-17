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
import IT6020003.objects.WorkObject;
import IT6020003.objects.TaskObject;
import IT6020003.process.Project;
import IT6020003.process.Task;
import IT6020003.process.Work;

/**
 * Servlet implementation class ProjectView
 */
@WebServlet("/project/view")
public class ProjectView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		
		String projectId = request.getParameter("project_id");
//	    if (projectId != null && !projectId.isEmpty()) {
//	        // Gọi phương thức xử lý project ID
//	        getAllProjectId(projectId);
//	    }
		
		out.append("<!doctype html>");
		out.append("<html lang=\"en\">");

		out.append("<head>");
		out.append("    <!-- Required meta tags -->");
		out.append("    <meta charset=\"utf-8\">");
		out.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");

		out.append("    <!-- Bootstrap CSS -->");
		out.append("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"");
		out.append("        integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
		out.append("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css\"");
		out.append("        integrity=\"sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==\"");
		out.append("        crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />");
		out.append("    <title>Hello, world!</title>");

		out.append("    <link rel=\"stylesheet\" href=\"/itad/css/project.css\">");
		out.append("</head>");

		out.append("<body style=\"background-image: url(/itad/img/project_bg_2.jpg); \">");
		out.append("    <div class=\"container-fluid\">");
		out.append("        <div class=\"row\">");
		out.append("            <nav class=\"menu p-0 col\">");
		out.append("                <div class=\"menu__header\">");
		out.append("                    <div class=\"menu__header__left\">");
		out.append("                        <img src=\"/itad/img/logo.png\" alt=\"\">");
		out.append("                    </div>");
		out.append("                    <div class=\"menu__header__mid\">");
		out.append("                        <p>PDM's work</p>");
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
		out.append("                        <i class=\"fa fa-plus user__add\"></i>");
		out.append("                    </div>");
		out.append("                    <div class=\"menu__mid__item\">");
		out.append("                        <i class=\"fa fa-cog\"></i>");
		out.append("                        <span>Cài đặt</span>");
		out.append("                    </div>");
		out.append("                </div>");
		out.append("                <div class=\"menu__bottom\">");
		out.append("                    <div class=\"menu__bottom__title\">");
		out.append("                        <p>Các bảng của bạn</p>");
		out.append("                        <i class=\"fa fa-plus\"></i>");
		out.append("                    </div>");
		out.append("                    <ul class=\"list-group\">");
		out.append("                        <li class=\"list-group-item-p\" aria-current=\"true\"> <a");
		out.append("                                href=\"http://localhost:8080/itad/ProjectView?project_id=1\"");
		out.append("                                style=\"color: #9fadbc; text-decoration: none;\">12312312</a></li>");
		out.append("                        <li class=\"list-group-item-p\" aria-current=\"true\"> <a");
		out.append("                                href=\"http://localhost:8080/itad/ProjectView?project_id=1\"");
//		----------------------------------------------------------
		out.append("                                style=\"color: #9fadbc; text-decoration: none;\">12312312</a></li>");
		out.append("                        <li class=\"list-group-item-p\" aria-current=\"true\"> <a");
		out.append("                                href=\"http://localhost:8080/itad/ProjectView?project_id=1\"");
		out.append("                                style=\"color: #9fadbc; text-decoration: none;\">12312312</a></li>");
		out.append("                    </ul>");
		out.append("                </div>");
		out.append("            </nav>");
		out.append("            <div class=\"content col p-0\">");
		out.append("                <div class=\"content__bar\">");
		out.append("                    <div class=\"content__bar__left\">");
		out.append("                        <span>Project</span>");
		out.append("                        <button type=\"button\">");
		out.append("                            <i class=\"fa fa-star\"></i>");
		out.append("                        </button>");
		out.append("                        <button type=\"button\">");
		out.append("                            <i class=\"fa fa-user-friends\"></i>");
		out.append("                        </button>");
		out.append("                    </div>");
		out.append("                    <div class=\"content__bar__right\">");
		out.append("                    </div>");
		out.append("                </div>");
		out.append("                <div class=\"content__main\">");
		out.append("                    <div class=\"card\" draggable=\"true\" data-drop-target-for-element=\"true\" work-position");
		out.append("                        style=\"width: 19rem;\">");
		out.append("                        <!-- <img src=\"...\" class=\"card-img-top\" alt=\"...\"> -->");
		out.append("                        <div class=\"card-body\">");
		out.append("                            <div class=\"card__header\">");
		out.append("                                <h5 class=\"card-title\" style=\"width: 86%;\">Card 1</h5>");
		out.append("                                <i class=\"fa fa-bars\"></i>");
		out.append("                            </div>");
		out.append("                            <div class=\"card__content\">");
		out.append("                                <div class=\"list-group\" data-drop-target-for-element=\"true\">");
		out.append("                                    <div class=\"list-group-item\" task-position draggable=\"true\"");
		out.append("                                        data-drop-target-for-element=\"true\">");
		out.append("                                        <div class=\"overlay\" data-bs-toggle=\"modal\" data-bs-target=\"#TodoListModal\">");
		out.append("                                            <i class=\"fa fa-edit\"></i>");
		out.append("                                        </div>");
		out.append("                                        <div class=\"item__top\">");
		out.append("                                            item 1");
		out.append("                                        </div>");
		out.append("                                        <div class=\"item__bottom mt-1\">");
		out.append("                                            card 1");
		out.append("                                        </div>");
		out.append("                                    </div>");
		out.append("                                </div>");
		out.append("                            </div>");
		out.append("                            <div class=\"card__bottom mt-2\">");
		out.append("                                <button class=\"btn_show\" type=\"submit\">");
		out.append("                                    <i class=\"fa fa-plus\"></i>");
		out.append("                                    <span>Thêm thẻ</span>");
		out.append("                                </button>");
		out.append("                                <div class=\"add_task hidden\">");
		out.append("                                    <form action=\"\" method=\"post\">");
		out.append("                                        <input id=\"task_name\" type=\"text\" placeholder=\"Nhập tiêu đề cho thẻ này\">");
		out.append("                                        <div class=\"add_option\">");
		out.append("                                            <button class=\"btn btn-primary btn_add\" onclick=\"addTask()\">Thêm");
		out.append("                                                thẻ</button>");
		out.append("                                            <div class=\"btn_close\" onclick=\"\"><i class=\"fa fa-times\"></i></div>");
		out.append("                                        </div>");
		out.append("                                    </form>");
		out.append("                                </div>");
		out.append("                            </div>");
		out.append("                        </div>");
		out.append("                    </div>");
		out.append("                </div>");
		out.append("                <!-- Modal -->");
		out.append("                <div class=\"modal fade\" id=\"TodoListModal\" tabindex=\"-1\" aria-labelledby=\"TodoListModalLabel\"");
		out.append("                    aria-hidden=\"true\">");
		out.append("                    <div class=\"modal-dialog\">");
		out.append("                        <div class=\"modal-content\">");
		out.append("                            <div class=\"modal-header\">");
		out.append("                                <h5 class=\"modal-title \" id=\"TodoListModalLabel\">Modal title</h5>");
		out.append("                                <input type=\"text\" class=\"TodoList_name\" name=\"TodoList_name\">");
//		----------------------------------------------

		out.append("                                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"");
		out.append("                                    aria-label=\"Close\"></button>");
		out.append("                            </div>");
		out.append("                            <div class=\"modal-show mt-4 mb-3 d-flex\">");
		out.append("                                <div class=\"modal-user \">");
		out.append("                                    <p>Thành viên</p>");
		out.append("                                    <div class=\"user-show d-flex justify-content-start mt-2\">");
		out.append("                                        <div class=\"user-avatar\">");
		out.append("                                            <img src=\"/itad/img/logo.png\" alt=\"\">");
		out.append("                                        </div>");
		out.append("                                        <div class=\"user-avatar\">");
		out.append("                                            <img src=\"/itad/img/logo.png\" alt=\"\">");
		out.append("                                        </div>");
		out.append("                                        <div style=\"background-color: #9fadbc;\" class=\" user-avatar\">");
		out.append("                                            <i class=\"fa fa-plus\"></i>");
		out.append("                                        </div>");
		out.append("                                    </div>");
		out.append("                                </div>");
		out.append("                                <div class=\"modal-tag\">");
		out.append("                                    <p>Nhãn</p>");
		out.append("                                </div>");
		out.append("                            </div>");
		out.append("                            <div class=\"modal-body d-flex\">");
		out.append("                                <div class=\"body_left\">");
		out.append("                                    <div class=\"description\">");
		out.append("                                        <div class=\"description__title d-flex\">");
		out.append("                                            <i class=\"fa fa-align-justify\"></i>");
		out.append("                                            <h5>Mô tả</h5>");
		out.append("                                        </div>");
		out.append("                                        <div class=\"description__content\">");
		out.append("                                            <div class=\"description__add \">Thêm mô tả chi tiết hơn...</div>");
		out.append("                                            <form class=\"hide\" action=\"\">");
		out.append("                                                <textarea class=\"description_text\" name=\"description_text\"");
		out.append("                                                    id=\"description_text\" cols=\"30\" rows=\"10\"></textarea>");
		out.append("                                                <button class=\"btn btn-primary \" type=\"submit\">Lưu</button>");
		out.append("                                                <button class=\"btn\" type=\"reset\">Hủy</button>");
		out.append("                                            </form>");
		out.append("                                        </div>");
		out.append("                                    </div>");
		out.append("                                    <div class=\"todolist\">");
		out.append("                                        <div class=\"todolist-header d-flex justify-content-between\">");
		out.append("                                            <div class=\"todolist_title d-flex\">");
		out.append("                                                <i style=\"font-size: 16px; line-height: 50px; margin: 0 10px; \" class=\"fa fa-calendar-check\"></i>");
		out.append("                                                <h5>Việc cần làm</h5>");
		out.append("                                            </div>");
		out.append("                                            <div class=\"todolist_option d-flex\">");
		out.append("                                                <div class=\"hide_todo\">");
		out.append("                                                    Ẩn các mục đã chọn");
		out.append("                                                </div>");
		out.append("                                                <div class=\"delete_todolist\">");
		out.append("                                                    Xóa");
		out.append("                                                </div>");
		out.append("                                            </div>");
		out.append("                                        </div>");
		out.append("                                        <div class=\"progress_per\">");
		out.append("                                            <span>50%</span>");
		out.append("                                            <div class=\"progress_persen\">");
		out.append("                                                <div class=\"persen\">");
		out.append("                                                </div>");
		out.append("                                            </div>");
		out.append("                                        </div>");
		out.append("                                        <div class=\"form-check\">");
		out.append("                                            <input class=\"form-check-input\" type=\"checkbox\" value=\"\"");
		out.append("                                                id=\"flexCheckDefault\">");
		out.append("                                            <label class=\"form-check-label\" for=\"flexCheckDefault\">");
		out.append("                                                Default checkbox 1");
		out.append("                                            </label>");
		out.append("                                            <button type=\"button\" class=\"btn btn-update-todo\">Chỉnh sửa</button>");
		out.append("                                            <div class=\"update_todo hide\">");
		out.append("                                                <textarea name=\"update_todo\" id=\"update_todo\" cols=\"30\" rows=\"10\"></textarea>");
		out.append("                                                <div class=\"todo_btn m-0\">");
		out.append("                                                    <button type=\"button\" class=\"btn btn-primary\">Lưu</button>");
		out.append("                                                    <button class=\"btn\" type=\"reset\">Hủy</button>");
//		----------------------------------------------------
		out.append("                                                </div>");
		out.append("                                            </div>");
		out.append("                                        </div>");
		out.append("                                        <div class=\"form-check\">");
		out.append("                                            <input class=\"form-check-input\" type=\"checkbox\" value=\"\"");
		out.append("                                                id=\"flexCheckChecked\">");
		out.append("                                            <label class=\"form-check-label\" for=\"flexCheckChecked\">");
		out.append("                                                Checked checkbox 2");
		out.append("                                            </label>");
		out.append("                                            <button type=\"button\" class=\"btn btn-update-todo\">Chỉnh sửa</button>");
		out.append("                                            <div class=\"update_todo hide\">");
		out.append("                                                <textarea name=\"update_todo\" id=\"update_todo\" cols=\"30\" rows=\"10\"></textarea>");
		out.append("                                                <div class=\"todo_btn m-0\">");
		out.append("                                                    <button type=\"button\" class=\"btn btn-primary\">Lưu</button>");
		out.append("                                                    <button class=\"btn\" type=\"reset\">Hủy</button>");
		out.append("                                                </div>");
		out.append("                                            </div>");
		out.append("                                        </div>");
		out.append("                                        <div class=\"form-check\">");
		out.append("                                            <input class=\"form-check-input\" type=\"checkbox\" value=\"\"");
		out.append("                                                id=\"flexCheckDefault\">");
		out.append("                                            <label class=\"form-check-label\" for=\"flexCheckDefault\">");
		out.append("                                                Default checkbox 3");
		out.append("                                            </label>");
		out.append("                                            <button type=\"button\" class=\"btn btn-update-todo\">Chỉnh sửa</button>");
		out.append("                                            <div class=\"update_todo hide\">");
		out.append("                                                <textarea name=\"update_todo\" id=\"update_todo\" cols=\"30\" rows=\"10\"></textarea>");
		out.append("                                                <div class=\"todo_btn m-0\">");
		out.append("                                                    <button type=\"button\" class=\"btn btn-primary\">Lưu</button>");
		out.append("                                                    <button class=\"btn\" type=\"reset\">Hủy</button>");
		out.append("                                                </div>");
		out.append("                                            </div>");
		out.append("                                        </div>");
		out.append("                                        <div class=\"form-check\">");
		out.append("                                            <input class=\"form-check-input\" type=\"checkbox\" value=\"\"");
		out.append("                                                id=\"flexCheckDefault\">");
		out.append("                                            <label class=\"form-check-label\" for=\"flexCheckDefault\">");
		out.append("                                                Default checkbox 4");
		out.append("                                            </label>");
		out.append("                                            <button type=\"button\" class=\"btn btn-update-todo\">Chỉnh sửa</button>");
		out.append("                                            <div class=\"update_todo hide\">");
		out.append("                                                <textarea name=\"update_todo\" id=\"update_todo\" cols=\"30\" rows=\"10\"></textarea>");
		out.append("                                                <div class=\"todo_btn m-0\">");
		out.append("                                                    <button type=\"button\" class=\"btn btn-primary\">Lưu</button>");
		out.append("                                                    <button class=\"btn\" type=\"reset\">Hủy</button>");
		out.append("                                                </div>");
		out.append("                                            </div>");
		out.append("                                        </div>");
		out.append("                                        <div class=\"add_todo\">");
		out.append("                                            <button type=\"button\" class=\"btn btn_addtodo\">Thêm một mục</button>");
		out.append("                                            <div class=\"todo_info hide\">");
		out.append("                                                <textarea name=\"todo\" id=\"\" cols=\"50\" rows=\"3\"></textarea>");
		out.append("                                                <div class=\"todo_btn\">");
		out.append("                                                    <button type=\"button\" class=\"btn btn-primary\">Thêm</button>");
		out.append("                                                    <button class=\"btn\" type=\"reset\">Hủy</button>");
		out.append("                                                </div>");
		out.append("                                            </div>");
		out.append("                                        </div>");
		out.append("                                        <div class=\"comment\">");
		out.append("                                            <div class=\"add_comment d-flex\">");
		out.append("                                                <div class=\"user-avatar\">");
		out.append("                                                    <img src=\"/itad/img/logo.png\" alt=\"\">");
		out.append("                                                </div>");
		out.append("                                                <input type=\"text\" name=\"comment_text\" placeholder=\"Viết bình luận...\">");
		out.append("                                                <button type=\"button\" class=\"btn btn-primary\">Lưu</button>");
		out.append("                                            </div>");
		out.append("                                            <div class=\"comment_content d-flex mt-3\">");
		out.append("                                                <div class=\"user-avatar\">");
		out.append("                                                    <img src=\"/itad/img/logo.png\" alt=\"\">");
		out.append("                                                </div>");
//		-------------------------------------

		out.append("                                                <div class=\"comment_item\">");
		out.append("                                                    <div class=\"item_title\">");
		out.append("                                                        <label>PDM user</label>");
		out.append("                                                        <span>11 phút trước</span>");
		out.append("                                                    </div>");
		out.append("                                                    <div class=\"item_body\">");
		out.append("                                                        <div class=\"comment_user mt-2\">");
		out.append("                                                            2");
		out.append("                                                        </div>");
		out.append("                                                        <div class=\"comment_option\">");
		out.append("                                                            <span class=\"btn_update_comment\">Chỉnh sửa</span>");
		out.append("                                                            <span class=\"btn_delete_comment\">Xóa</span>");
		out.append("                                                        </div>");
		out.append("                                                    </div>");
		out.append("                                                    <div class=\"update_comment mt-2\">");
		out.append("                                                        <textarea name=\"update_comment\" id=\"update_comment\" cols=\"30\" rows=\"10\"></textarea>");
		out.append("                                                        <div class=\"comment_btn\">");
		out.append("                                                            <button type=\"button\" class=\"btn btn-primary\">Lưu</button>");
		out.append("                                                            <button class=\"btn\" type=\"reset\">Hủy</button>");
		out.append("                                                        </div>");
		out.append("                                                    </div>");
		out.append("                                                </div>");
		out.append("                                            </div>");
		out.append("                                            <div class=\"comment_content d-flex mt-3\">");
		out.append("                                                <div class=\"user-avatar\">");
		out.append("                                                    <img src=\"/itad/img/logo.png\" alt=\"\">");
		out.append("                                                </div>");
		out.append("                                                <div class=\"comment_item\">");
		out.append("                                                    <div class=\"item_title\">");
		out.append("                                                        <label>PDM user</label>");
		out.append("                                                        <span>11 phút trước</span>");
		out.append("                                                    </div>");
		out.append("                                                    <div class=\"item_body\">");
		out.append("                                                        <div class=\"comment_user mt-2\">");
		out.append("                                                            2");
		out.append("                                                        </div>");
		out.append("                                                        <div class=\"comment_option\">");
		out.append("                                                            <span class=\"btn_update_comment\">Chỉnh sửa</span>");
		out.append("                                                            <span class=\"btn_delete_comment\">Xóa</span>");
		out.append("                                                        </div>");
		out.append("                                                    </div>");
		out.append("                                                    <div class=\"update_comment mt-2\">");
		out.append("                                                        <textarea name=\"update_comment\" id=\"update_comment\" cols=\"30\" rows=\"10\"></textarea>");
		out.append("                                                        <div class=\"comment_btn\">");
		out.append("                                                            <button type=\"button\" class=\"btn btn-primary\">Lưu</button>");
		out.append("                                                            <button class=\"btn\" type=\"reset\">Hủy</button>");
		out.append("                                                        </div>");
		out.append("                                                    </div>");
		out.append("                                                </div>");
		out.append("                                            </div>");
		out.append("                                        </div>");
		out.append("                                    </div>");
		out.append("                                </div>");
		out.append("                                <div class=\"body_right\">");
		out.append("                                    <span>Thêm vào thẻ</span>");
		out.append("                                    <div class=\"body_item\">");
		out.append("                                        <i class=\"fa fa-user\"></i>");
		out.append("                                        <p>Thành viên</p>");
		out.append("                                        <div class=\"add_user show_add\">");
		out.append("                                            <div class=\"add_user_title\">");
		out.append("                                                Thành viên");
		out.append("                                            </div>");
		out.append("                                            <input type=\"text\" name=\"search_user\" id=\"\">");
		out.append("                                            <p>Thành viên của bảng</p>");
		out.append("                                            <div class=\"list_user d-flex\">");
		out.append("                                                <div class=\"user-avatar\">");
		out.append("                                                    <img src=\"/itad/img/logo.png\" alt=\"\">");
		out.append("                                                </div>");
		out.append("                                                <p class=\"user_name\">PDM</p>");
		out.append("                                            </div>");
		out.append("                                            <div class=\"list_user added d-flex\">");
		out.append("                                                <div class=\"user-avatar\">");
		out.append("                                                    <img src=\"/itad/img/logo.png\" alt=\"\">");
		out.append("                                                </div>");
		out.append("                                                <p class=\"user_name\">PDM</p>");
		out.append("                                            </div>");
		out.append("                                        </div>");
		out.append("                                    </div>");
//		------------------------------
		out.append("                                    <div class=\"body_item\">");
		out.append("                                        <i class=\"fa fa-tags\"></i>");
		out.append("                                        <p>Nhãn</p>");
		out.append("                                        <div class=\"add_todo show_add\">");

		out.append("                                        </div>");
		out.append("                                    </div>");
		out.append("                                    <div class=\"body_item\">");
		out.append("                                        <i class=\"fa fa-check-square\"></i>");
		out.append("                                        <p>Việc cần làm</p>");
		out.append("                                        <div class=\"create_todo show_add\">");
		out.append("                                            <div class=\"create_todo_title\">");
		out.append("                                                Thêm danh sách công việc");
		out.append("                                            </div>");
		out.append("                                            <input type=\"text\" name=\"todo_name\" id=\"\" placeholder=\"Việc cần làm\">");
		out.append("                                            <button type=\"button\" class=\"btn btn-primary\">Thêm</button>");
		out.append("                                        </div>");
		out.append("                                    </div>");
		out.append("                                </div>");
		out.append("                            </div>");
		out.append("                            <div class=\"modal-footer\">");
		out.append("                                <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Close</button>");
		out.append("                                <button type=\"button\" class=\"btn btn-primary\">Save changes</button>");
		out.append("                            </div>");
		out.append("                        </div>");
		out.append("                    </div>");
		out.append("                </div>");
		out.append("            </div>");
		out.append("        </div>");
		out.append("    </div>");
		out.append("    <script src=\"/itad/js/project.js\"></script>");
		out.append("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"");
		out.append("        integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\"");
		out.append("        crossorigin=\"anonymous\"></script>");
		out.append("</body>");
		out.append("</html>");



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
