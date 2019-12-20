package project.simplechat;


public class StatementHelper {

	public static String toJson(Statement statement) {
		StringBuilder builder = new StringBuilder();
		toJson(statement, builder);
		return builder.toString();
	}

	public static void toJson(Statement statement, StringBuilder builder) {
		builder.append("{");
		builder.append("\"user\":");
		UserHelper.toJson(statement.getUser(), builder);
		builder.append(",");
		builder.append("\"message\":\"").append(statement.getMessage()).append("\"");
		builder.append("}");
	}

}
