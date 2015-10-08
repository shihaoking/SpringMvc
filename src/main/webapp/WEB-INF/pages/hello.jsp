<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <script src="js/main.js"></script>
</head>
	<h1>${message}</h1>
    <a href="<%= request.getContextPath()%>/hello/getSchedules.json">获取Json格式</a><br/>
    <a href="<%= request.getContextPath()%>/hello/getSchedules.xml">获取XML格式</a>
</body>
</html>