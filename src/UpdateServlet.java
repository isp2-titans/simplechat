package project.simplechat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/project/simplechat/update")
public class UpdateServlet extends ActionServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user != null) {
			ServletContext context = this.getServletContext();
			Chat chat = (Chat)context.getAttribute("chat");

			StringBuilder builder = new StringBuilder();
			builder.append("{");
			builder.append("\"user\":");
			UserHelper.toJson(user, builder);
			builder.append(",");
			builder.append("\"statementList\":[");
			Iterator<Statement> statementIterator = chat.getStatementList().iterator();
			if(statementIterator.hasNext()) {
				Statement statement = statementIterator.next();
				StatementHelper.toJson(statement, builder);
			}
			while(statementIterator.hasNext()) {
				builder.append(",");
				Statement statement = statementIterator.next();
				StatementHelper.toJson(statement, builder);
			}
			builder.append("]");
			builder.append("}");
			String json = builder.toString();

			response.setContentType("application/json");
			PrintWriter writer = response.getWriter();
			writer.append(json);
			System.out.println(json);
			writer.flush();
		}
	}

}
