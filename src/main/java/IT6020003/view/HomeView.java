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
import IT6020003.objects.WorkingSpaceObject;
import IT6020003.process.Project;
import IT6020003.process.User;
import IT6020003.process.WorkingSpace;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User u = new User();
		PrintWriter out = response.getWriter();
		UserObject items = u.getUserObjectByEmail(null, email);
		
		if (!password.equals(items.getUser_password())) {
			response.sendRedirect("http://localhost:8080/itad/LoginView");
		} else {
			out.append("<!doctype html>");
			out.append("<html lang=\"en\">");
			out.append("");
			out.append("<head>");
			out.append("  <!-- Required meta tags -->");
			out.append("  <meta charset=\"utf-8\">");
			out.append("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
			out.append("");
			out.append("  <!-- Bootstrap CSS -->");
			out.append("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\";");
			out.append("    integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
			out.append("");
			out.append("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css\";");
			out.append("    integrity=\"sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==\";");
			out.append("    crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />");
			out.append("");
			out.append("  <title>Trello</title>");
			out.append("");
			out.append("  <link rel=\"stylesheet\" href=\"/itad/css/home.css\">");
			out.append("</head>");
			out.append("");
			out.append("<body>");
			out.append("  <header>");
			out.append("");
			out.append("  </header>");
			out.append("");
			out.append("  <div class=\"container\">");
			out.append("    <div class=\"home row\">");
			out.append("      <div class=\"home__left col-3\">");
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
			out.append("                	<div class=\"menu_work_space\">");
			out.append("                		<p>Các không gian làm việc</p>");
			out.append("                	</div>");
			out.append("                    <li class=\"list-group-item d-flex\">");
			out.append("                        <i class=\"fa fa-list-alt\"></i>");
			out.append("                        <p>Bảng</p>");
			out.append("                    </li>");
			out.append("                    <li class=\"list-group-item d-flex\">");
			out.append("                        <i class=\"fa fa-columns\"></i>");
			out.append("                        <p>Mẫu</p>");
			out.append("                    </li>");
			out.append("                    <li class=\"list-group-item d-flex\">");
			out.append("                        <i class=\"fa fa-home\"></i>");
			out.append("                        <p>Trang chủ</p>");
			out.append("                    </li>");
			out.append("                </ul>");
			out.append("");
			out.append("            </div>");
			out.append("            <div class=\"home__right col-9\">");
			out.append("                <div class=\"working__space\">");
			out.append("                    <h3 style=\"font-size: 16px; margin: 20px 0;\">CÁC KHÔNG GIAN LÀM VIỆC CỦA BẠN</h3>");
			
			WorkingSpace ws = new WorkingSpace();
			ArrayList<WorkingSpaceObject> list_ws = ws.getAllWorkingSpaceObjectsByUserId(null, items.getUser_id());
			list_ws.forEach(item_ws -> {
				out.append("                    <div class=\"working_space_header row mb-5\">");
				out.append("                        <div class=\"working_space_name col-4 d-flex\">");
				out.append("                        	<img class=\"img_lg\" src=\""+item_ws.getWorking_space_url()+"\" alt=\"\">");
				out.append("                            <h3 style=\"font-size: 16px;\">"+item_ws.getWorking_space_name()+"</h3>");
				out.append("                        </div>");
				out.append("                        <div class=\"working_space_options col-8 d-flex\">");
				out.append("                            <div class=\"option__item d-flex\">");
				out.append("                                <i class=\"fa fa-list-alt\"></i>");
				out.append("                                <p>Bảng</p>");
				out.append("                            </div>");
				out.append("                            <div class=\"option__item d-flex\">");
				out.append("                                <i class=\"fa fa-grip-vertical\"></i>");
				out.append("                                <p>Dạng xem</p>");
				out.append("                            </div>");
				out.append("                            <div class=\"option__item d-flex\">");
				out.append("                                <i class=\"fa fa-user\"></i>");
				out.append("                                <p>Thành viên</p>");
				out.append("                            </div>");
				out.append("                            <div class=\"option__item d-flex\">");
				out.append("                                <i class=\"fa fa-cog\"></i>");
				out.append("                                <p>Cài đặt</p>");
				out.append("                            </div>");
				out.append("                        </div>");
				out.append("                        <div class=\"working_space_list row mt-3\">");
				
				Project p = new Project();
				ArrayList<ProjectObject> list = p.getAllProjectObjects(null);
				list.forEach(item -> {
					out.append("                            <div class=\"working_space_list_item col-3\" style=\"background-image: url(/itad/img/melody_wallpaper_by_kj_designer_dan9r5u-fullview.jpg);\">");
					out.append("                                <a href=\"http://localhost:8080/itad/ProjectView?project_id="+item.getProject_id()+"\">Work</a>");
					out.append("                            </div>");
				});
				
				out.append("                        </div>");
				out.append("                    </div>");
			});
			
			
			out.append("                </div>");
			out.append("");
			out.append("            </div>");
			out.append("        </div>");
			out.append("    </div>");
			out.append("");
			out.append("	<script src=\"/itad/js/main.js\"></script>");
			out.append("    <!-- Optional JavaScript; choose one of the two! -->");
			out.append("");
			out.append("    <!-- Option 1: Bootstrap Bundle with Popper -->");
			out.append("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"");
			out.append("        integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\"");
			out.append("        crossorigin=\"anonymous\"></script>");
			out.append("");
			out.append("    <!-- Option 2: Separate Popper and Bootstrap JS -->");
			out.append("    <!--");
			out.append("    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js\" integrity=\"sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB\" crossorigin=\"anonymous\"></script>");
			out.append("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js\" integrity=\"sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13\" crossorigin=\"anonymous\"></script>");
			out.append("    -->");
			out.append("</body>");
			out.append("");
			out.append("</html>");
		}
		
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
