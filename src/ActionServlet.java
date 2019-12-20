package project.simplechat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ActionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		
		Chat chat = (Chat)context.getAttribute("chat");
		if(chat == null) {
			chat = new Chat();
			context.setAttribute("chat", chat);
		}
	}
	
}
