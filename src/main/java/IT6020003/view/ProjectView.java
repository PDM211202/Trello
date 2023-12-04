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
		out.append("");
		out.append("<head>");
		out.append("  <!-- Required meta tags -->");
		out.append("  <meta charset=\"utf-8\">");
		out.append("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.append("");
		out.append("  <!-- Bootstrap CSS -->");
		out.append("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"");
		out.append("    integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
		out.append("");
		out.append("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css\"");
		out.append("    integrity=\"sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==\"");
		out.append("    crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />");
		out.append("");
		out.append("  <title>Trello</title>");
		out.append("");
		out.append("  <link rel=\"stylesheet\" href=\"/itad/css/index.css\">");
		out.append("</head>");
		out.append("");
		out.append("<body>");
		out.append("  <div class=\"container-fluid\">");
		out.append("    <header class=\"header\">");
		out.append("");
		out.append("    </header>");
		out.append("");
		out.append("    <div class=\"row col\">");
		out.append("      <nav class=\"menu p-0\">");
		out.append("        <div class=\"menu__header\">");
		out.append("          <div class=\"menu__header__left\">");
		out.append("            <img src=\"./melody_wallpaper_by_kj_designer_dan9r5u-fullview.jpg\" alt=\"\">");
		out.append("          </div>");
		out.append("          <div class=\"menu__header__mid\">");
		out.append("            <p>PDM's work</p>");
		out.append("            <span>Miễn phí</span>");
		out.append("          </div>");
		out.append("          <div class=\"menu__header__right\">");
		out.append("            <div>");
		out.append("              <i class=\"fa fa-angle-left\"></i>");
		out.append("            </div>");
		out.append("          </div>");
		out.append("        </div>");
		out.append("        <div class=\"menu__mid pt-1 mb-3\">");
		out.append("          <div class=\"menu__mid__item\">");
		out.append("            <i class=\"fa fa-table\"></i>");
		out.append("            <span>Bảng</span>");
		out.append("          </div>");
		out.append("          <div class=\"menu__mid__item\">");
		out.append("            <i class=\"fa fa-user\"></i>");
		out.append("            <span>Thành viên</span>");
		out.append("            <i class=\"fa fa-plus user__add\"></i>");
		out.append("          </div>");
		out.append("          <div class=\"menu__mid__item\">");
		out.append("            <i class=\"fa fa-cog\"></i>");
		out.append("            <span>Cài đặt</span>");
		out.append("          </div>");
		out.append("        </div>");
		out.append("        <div class=\"menu__bottom\">");
		out.append("          <div class=\"menu__bottom__title\">");
		out.append("            <p>Các bảng của bạn</p>");
		out.append("            <i class=\"fa fa-plus\"></i>");
		out.append("          </div>");
		out.append("          <ul class=\"list-group\">");
		
		Project p = new Project();
		ArrayList<ProjectObject> list = p.getAllProjectObjects(null);
		list.forEach(item -> {
			out.append("            <li class=\"list-group-item\" aria-current=\"true\"> <a href=\"http://localhost:8080/itad/ProjectView?project_id="+item.getProject_id()+"\" style=\"color: #9fadbc; text-decoration: none;\">"+item.getProject_name()+"</a></li>");
		});
		
		out.append("          </ul>");
		out.append("        </div>");
		out.append("      </nav>");
		out.append("      <div class=\"content col p-0\">");
		out.append("        <div class=\"content__bar\">");
		out.append("          <div class=\"content__bar__left\">");
		out.append("            <span>Project</span>");
		out.append("            <button type=\"button\">");
		out.append("              <i class=\"fa fa-star\"></i>");
		out.append("            </button>");
		out.append("            <button type=\"button\">");
		out.append("              <i class=\"fa fa-user-friends\"></i>");
		out.append("            </button>");
		out.append("");
		out.append("          </div>");
		out.append("          <div class=\"content__bar__right\">");
		out.append("");
		out.append("          </div>");
		out.append("        </div>");
		out.append("        <div class=\"content__main\" draggable=\"true\" data-drop-target-for-element=\"true\">");
		
		Work w = new Work();
		ArrayList<WorkObject> listWork = w.getAllWorkObjectsByProjectId(null, Integer.parseInt(projectId));
		listWork.forEach(item -> {
			out.append("          <div class=\"card\" draggable=\"true\" data-drop-target-for-element=\"true\" work-position style=\"width: 19rem;\">");
			out.append("            <!-- <img src=\"...\" class=\"card-img-top\" alt=\"...\"> -->");
			out.append("            <div class=\"card-body\">");
			out.append("              <div class=\"card__header\">");
			out.append("                <h5 class=\"card-title\" style=\"width: 86%;\">"+item.getWork_name()+"</h5>");
			out.append("                <i class=\"fa fa-bars\"></i>");
			out.append("              </div>");
			out.append("              <div class=\"card__content\">");
			out.append("                <div class=\"list-group\" data-drop-target-for-element=\"true\">");
			
			Task t = new Task();
			ArrayList<TaskObject> listTask = t.getAllTaskObjectsByWorkId(null, item.getWork_id());
			listTask.forEach(item_task -> {
				out.append("                  <div class=\"list-group-item\" task-position draggable=\"true\" data-drop-target-for-element=\"true\" >");
				out.append("                    <div class=\"overlay\">");
				out.append("                      <i class=\"fa fa-edit\"></i>");
				out.append("                    </div>");
				out.append("                    <div class=\"item__top\">");
				out.append("                      "+item_task.getTask_name()+"");
				out.append("                    </div>");
				out.append("                    <div class=\"item__bottom mt-1\">");
				out.append("                      card 1");
				out.append("                    </div>");
				out.append("                  </div>");
			});
			
			out.append("                </div>");
			out.append("              </div>");
			out.append("              <div class=\"card__bottom mt-2\">");
			out.append("                <button class=\"btn_show\" type=\"submit\">");
			out.append("                  <i class=\"fa fa-plus\"></i>");
			out.append("                  <span>Thêm thẻ</span>");
			out.append("                </button>");
			out.append("                <div class=\"add_task hidden\">");
			out.append("                	<input id=\"task_name\" type=\"text\" placeholder=\"Nhập tiêu đề cho thẻ này\">");
			out.append("                	<div class=\"add_option\">");
			out.append("						<button class=\"btn btn-primary btn_add\" onclick=\"addTask()\">Thêm thẻ</button>");
			out.append("						<div class=\"btn_close\" onclick=\"\"><i class=\"fa fa-times\"></i></div>");
			out.append("                	</div>");
			out.append("                </div>");
			out.append("              </div>");
			out.append("            </div>");
			out.append("          </div>");
		});
		
		out.append("");
		out.append("      </div>");
		out.append("    </div>");
		out.append("  </div>");
		out.append("");
		out.append("");
		out.append("");
		out.append("  <script src=\"/itad/js/index.js\"></script>");
		out.append("  <!-- <script src=\"./main.js\"></script> -->");
		out.append("");
		out.append("  <!-- Optional JavaScript; choose one of the two! -->");
		out.append("");
		out.append("  <!-- Option 1: Bootstrap Bundle with Popper -->");
		out.append("  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"");
		out.append("    integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\"");
		out.append("    crossorigin=\"anonymous\"></script>");
		out.append("");
		out.append("  <!-- Option 2: Separate Popper and Bootstrap JS -->");
		out.append("  <!--");
		out.append("    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js\" integrity=\"sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB\" crossorigin=\"anonymous\"></script>");
		out.append("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js\" integrity=\"sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13\" crossorigin=\"anonymous\"></script>");
		out.append("    -->");
		out.append("</body>");
		out.append("");
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
