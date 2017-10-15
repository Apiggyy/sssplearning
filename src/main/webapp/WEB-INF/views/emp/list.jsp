<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
    <title>员工列表</title>
</head>
<body>
    <c:choose>
        <c:when test="${page == null || page.numberOfElements == 0}">
            没有任何记录
        </c:when>
        <c:otherwise>
            <table border="1" cellspacing="0" cellpadding="10">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>LastName</th>
                    <th>Email</th>
                    <th>Birth</th>
                    <th>CreateTime</th>
                    <th>Department</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.content}" var="emp">
                    <tr>
                        <td>${emp.id}</td>
                        <td>${emp.lastName}</td>
                        <td>${emp.email}</td>
                        <td><fmt:formatDate value="${emp.birth}" pattern="yyyy-MM-dd" /></td>
                        <td><fmt:formatDate value="${emp.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                        <td>${emp.dept.deptName}</td>
                        <td><a href="${pageContext.request.contextPath}/emp/edit/${emp.id}">Edit</a></td>
                        <td><a href="${pageContext.request.contextPath}/emp/delete/${emp.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="8">
                        共${page.totalElements}条记录&nbsp;
                        共${page.totalPages}页&nbsp;
                        当前第${page.number + 1}页&nbsp;
                        <c:choose>
                            <c:when test="${page.firstPage}">
                                <c:set var="prevPage" value="1"/>
                            </c:when>
                            <c:otherwise>
                                <c:set var="prevPage" value="${page.number + 1 -1}"/>
                            </c:otherwise>
                        </c:choose>
                        <a href="?pageNo=${prevPage}">上一页</a>
                        <c:choose>
                            <c:when test="${page.lastPage}">
                                <c:set var="nextPage" value="${page.number + 1}"/>
                            </c:when>
                            <c:otherwise>
                                <c:set var="nextPage" value="${page.number + 1 + 1}"/>
                            </c:otherwise>
                        </c:choose>
                        <a href="?pageNo=${nextPage}">下一页</a>
                        <%--<a href="?pageNo=${page.number + 1 -1}">上一页</a>&nbsp;--%>
                        <%--<a href="?pageNo=${page.number + 1 + 1}">下一页</a>--%>
                    </td>
                </tr>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</body>
</html>
