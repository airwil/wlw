<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("ctx", path);
//out.print(path);
%>
<!DOCTYPE html>
<html>
<body>
<h2>Hello World!aa</h2>
${ctx}<br>
${pageContext.request.contextPath}/views
</body>
</html>
