<%@ page import="java.util.*" %><%--language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
</head>
<body>

	<h3>Product Information</h3>
	<p>
		<%
			List<String> styles = (List<String>) request.getAttribute("styles");
			//out.print(styles);
			Iterator it = styles.iterator();
			while(it.hasNext()) {
				out.print("<br>" + it.next());
			}
		%>
	</p>
</body>
</html>