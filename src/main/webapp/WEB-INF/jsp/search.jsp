<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <c:url value="/css/main.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />
    <link rel="shortcut icon" href="https://www.heb.com/img/favicon.ico" type="image/x-icon">
</head>

<body style="background-image: url('/images/food.jpg')">

	<div class="container">

        <form:form width="100%" action="search" method="post" modelAttribute="searchRequest">
            <table border="0" width="100%" >
                <tr>
                    <td colspan="2" cellpadding="10" align="center">
                        <br>
                        <a href="/"><img src="/images/heb.png" height="68" width="206" /></a>
                        <h3 style="font-family: Georgia;">Inventory Quick Search</h3>
                        <br>
                    </td>
                </tr>
                <tr>
                    <td width="90%"><form:input path="searchText" style="display:table-cell; width:100%" /></td>
                    <td width="10%"><input type="submit" value="Search" style="display:table-cell; width:100%" /></td>
                </tr>
            </table>
        </form:form>

        <br>

        <!-- Print when search result list is empty -->
        <c:if test="${grocList.size()<=0}">
           No results.
        </c:if>

        <table border="0" width="100%" cellspacing="4" cellpadding="4" style="font-family: Georgia;">
            <c:if test="${grocList.size()>0}">
                <tr style="font-weight: bold">
                    <td width="10%" style="text-align: center; vertical-align: middle;">ID</td>
                    <td width="20%" style="text-align: center; vertical-align: middle;">Description</td>
                    <td width="10%" style="text-align: center; vertical-align: middle;">Last Sold</td>
                    <td width="8%" style="text-align: center; vertical-align: middle;">Shelf Life</td>
                    <td width="15%" style="text-align: center; vertical-align: middle;">Department</td>
                    <td width="8%" style="text-align: center; vertical-align: middle;">Price</td>
                    <td width="8%" style="text-align: center; vertical-align: middle;">Unit</td>
                    <td width="8%" style="text-align: center; vertical-align: middle;">xFor</td>
                    <td width="8%" style="text-align: center; vertical-align: middle;">Cost</td>
                </tr>
            </c:if>

            <!-- Print a table row for each item in search result list -->
            <c:forEach var = "listValue" items = "${grocList}">
                <tr>
                    <td style="text-align: center; vertical-align: middle;"><c:out value="${listValue.getId()}"/></td>
                    <td style="text-align: center; vertical-align: middle;"><c:out value="${listValue.getDescription()}"/></td>
                    <td style="text-align: center; vertical-align: middle;"><c:out value="${listValue.getLastSoldDayOnly()}"/></td>
                    <td style="text-align: center; vertical-align: middle;"><c:out value="${listValue.getShelfLife()}"/></td>
                    <td style="text-align: center; vertical-align: middle;"><c:out value="${listValue.getDepartment()}"/></td>
                    <td style="text-align: center; vertical-align: middle;"><c:out value="${listValue.getPriceFormatted()}"/></td>
                    <td style="text-align: center; vertical-align: middle;"><c:out value="${listValue.getUnit()}"/></td>
                    <td style="text-align: center; vertical-align: middle;"><c:out value="${listValue.getXFor()}"/></td>
                    <td style="text-align: center; vertical-align: middle;"><c:out value="${listValue.getCostFormatted()}"/></td>
                </tr>
            </c:forEach>
        </table>

	</div>

	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

<footer class="footer" align="center">
    <br><br>Copyright © 2018 H-E-B<br><p> </p><br>
</footer>

</html>
