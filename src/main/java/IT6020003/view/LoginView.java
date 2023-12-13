package IT6020003.view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import IT6020003.objects.UserObject;
import IT6020003.process.User;

/**
 * Servlet implementation class LoginView
 */
@WebServlet("/login/view")
public class LoginView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginView() {
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
		
		out.append("<!doctype html>");
		out.append("<html lang=\"en\">");
		out.append("<head>");
		out.append("<!-- Required meta tags -->");
		out.append("<meta charset=\"utf-8\">");
		out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.append("<!-- Bootstrap CSS -->");
		out.append("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"");
		out.append("integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
		out.append("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css\"");
		out.append("integrity=\"sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==\"");
		out.append("crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />");
		out.append("<title>Trello</title>");
		out.append("<link rel=\"stylesheet\" href=\"/itad/css/login.css\">");
		out.append("</head>");
		out.append("<body>");
		out.append("<div class=\"form\">");
		out.append("<div class=\"form__header\">");
		out.append("<i class=\"fa fa-columns\"></i>");
		out.append("<h2>Trello</h2>");
		out.append("</div>");
		out.append("<div class=\"form__title\">");
		out.append("<p>Log in to continue</p>");
		out.append("</div>");
		out.append("<div class=\"form__input\">");
		out.append("<form action=\"http://localhost:8080/itad/LoginView\" method=\"post\">");
		out.append("<input id=\"email\" type=\"text\" name=\"email\" placeholder=\"Enter your email\">");
		out.append("<br>");
		out.append("<input id=\"password\" type=\"password\" name=\"password\" placeholder=\"Enter your password\">");
		out.append("<button class=\"btn btn-primary\" type=\"submit\">Log in</button>");
		out.append("</form>");
		out.append("</div>");
		
		
		out.append("</div>");
//		out.append("<script src=\"/itad/js/login.js\"></script>");
		out.append("<!-- Optional JavaScript; choose one of the two! -->");
		out.append("<!-- Option 1: Bootstrap Bundle with Popper -->");
		out.append("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"");
		out.append("integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\"");
		out.append("crossorigin=\"anonymous\"></script>");
		out.append("<!-- Option 2: Separate Popper and Bootstrap JS -->");
		out.append("<!--");
		out.append("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js\" integrity=\"sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB\" crossorigin=\"anonymous\"></script>");
		out.append("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js\" integrity=\"sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13\" crossorigin=\"anonymous\"></script>");
		out.append("-->");
		out.append("</body>");
		out.append("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User u = new User();
		UserObject items = u.getUserObjectByEmail(null, email);
		if (!password.equals(items.getUser_password())) {
			response.sendRedirect("http://localhost:8080/itad/LoginView");
		} else {
			response.sendRedirect("http://localhost:8080/itad/HomeView?email="+items.getUser_email()+"");
		}
	}

}
