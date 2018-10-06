<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>

<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<div class="container">

        <form:form width="100%" action="search" method="post" modelAttribute="searchRequest">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>HEB Inventory Search</h2></td>
                </tr>
                <tr>
                    <td><form:input path="searchText" width="100%" size="100" /></td>
                    <td colspan="2" align="center"><input type="submit" value="Search" /></td>
                </tr>
            </table>
        </form:form>

        <br>

        <table width="100%" cellspacing="4" cellpadding="4">
            <c:if test="${grocList.size()>0}">
                <tr>
                    <td>ID</td>
                    <td>Description</td>
                    <td>Last Sold</td>
                    <td>Shelf Life</td>
                    <td>Department</td>
                    <td>Price</td>
                    <td>Unit</td>
                    <td>xFor</td>
                    <td>Cost</td>
                </tr>
            </c:if>
            <c:forEach var = "listValue" items = "${grocList}">
                <tr>
                    <td><c:out value="${listValue.getId()}"/></td>
                    <td><c:out value="${listValue.getDescription()}"/></td>
                    <td><c:out value="${listValue.getLastSold()}"/></td>
                    <td><c:out value="${listValue.getShelfLife()}"/></td>
                    <td><c:out value="${listValue.getDepartment()}"/></td>
                    <td><c:out value="${listValue.getPrice()}"/></td>
                    <td><c:out value="${listValue.getUnit()}"/></td>
                    <td><c:out value="${listValue.getXFor()}"/></td>
                    <td><c:out value="${listValue.getCost()}"/></td>
                </tr>
            </c:forEach>
        </table>

	</div>
	<!-- /.container -->

	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
