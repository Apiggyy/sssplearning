<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
    <title>添加员工</title>
    <form:form action="${pageContext.request.contextPath}/emp/add" method="post" modelAttribute="employee">
        LastName: <form:input path="lastName"/>
        <br>
        Email: <form:input path="email"/>
        <br>
        Birth: <form:input path="birth"/>
        <br>
        createTime: <form:input path="createTime"/>
        <br>
        Department: <form:select path="dept" items="${departments}" itemLabel="deptName" itemValue="id"/>
        <br>
        <input type="submit" value="Submit"/>
    </form:form>
</head>
<body>
</body>
</html>
