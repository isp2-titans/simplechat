package project.simplechat;

import java.util.Iterator;

public class ChatHelper {
	
	public static String toJson(Chat chat) {
		StringBuilder builder = new StringBuilder();
		toJson(chat, builder);
		return builder.toString();
	}

	public static void toJson(Chat chat, StringBuilder builder) {
		builder.append("{");
		builder.append("\"userList\":[");
		Iterator<User> userIterator = chat.getUserList().iterator();
		if(userIterator.hasNext()) {
			User user = userIterator.next();
			UserHelper.toJson(user, builder);
		}
		while(userIterator.hasNext()) {
			builder.append(",");
			User user = userIterator.next();
			UserHelper.toJson(user, builder);
		}
		builder.append("]");
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
	}	
	
}
