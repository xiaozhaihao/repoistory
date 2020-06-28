
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>

<!doctype html>
<html lang="en">
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ems1.0/css/style.css" />
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
                    <br />
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                Welcome:    ${sessionScope.employee.name}!
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Salary
                    </td>
                    <td>
                        Age
                    </td>
                    <td>
                        Operation
                    </td>
                </tr>
                <c:forEach var="em" items="${list}" varStatus="p">
                    <tr class="row1">
                        <td>
                            ${p.index+1}
                        </td>
                        <td>
                            ${em.name}
                        </td>
                        <td>
                            ${em.salary}
                        </td>
                        <td>
                            ${em.age}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/employee/delete?id=${em.id}">delete emp</a>&nbsp;<a href="${pageContext.request.contextPath}/employee/preUpdate?id=${em.id}">update emp</a>
                        </td>
                    </tr>
                </c:forEach>


            </table>
            <p>
                <input type="button" class="button" value="Add Employee" onclick="location='${pageContext.request.contextPath}/ems1.0/addEmp.jsp'"/>
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>

</html>