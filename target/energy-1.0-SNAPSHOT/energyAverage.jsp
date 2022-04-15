<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>蚂蚁森林</title>
    <link rel="stylesheet" href="styles/energy.css">
</head>
<body>
<jsp:include page="include_header.jsp"></jsp:include>
${average};
<%--显示班级平均能朗数字（保留整数），展示文字和形式自定义--%>
<%--html元素中签入JSP表达式模式--%>

<jsp:include page="include_footer.jsp"></jsp:include>
</body>
</html>