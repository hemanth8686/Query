<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 


<!DOCTYPE html>
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<style type="text/css">
table {
	table-layout: fixed;
	width: 100%;
	border-collapse: collapse;
	border: 3px solid purple;
}

thead th:nth-child(1) {
	width: 30%;
}

thead th:nth-child(2) {
	width: 20%;
}

thead th:nth-child(3) {
	width: 15%;
}

thead th:nth-child(4) {
	width: 35%;
}

th, td {
	padding: 30px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="queryReport" method="post">
		<table>
			<tr>
				<td>FromDate:<input type="date" name="fromDate">
				</td>
				<td>ToDate:<input type="date" name="toDate">
				</td>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>

		<table border="1">

			<tr style="bgcolor: 4682B4" bordercolor="blue">


				<c:forEach items="${queryReport}" var="dlist">
					<tr>
						<td></td>
					<tr>

	<td nowrap="nowrap" >ID:<fmt:formatDate pattern="dd-MM-yyyy" value="${dlist.Id}" /></td>

						<td nowrap="nowrap" >RAISEDDATE:<fmt:formatDate pattern="dd-MM-yyyy" value="${dlist.raisedDate}" /></td>
					
						<td nowrap="nowrap">RAISEDBY:<c:out value="${dlist.raisedBy}" />	</td>
						<td nowrap="nowrap">CLIENT:<c:out value="${dlist.client}" /></td>
						<td nowrap="nowrap">QUERY:<c:out value="${dlist.query}" /></td>
						<td nowrap="nowrap">ATTENTEDBY:<c:out value="${dlist.attentedBy}" /></td>
						<td nowrap="nowrap"> RAISEDTHROUGH:<c:out value="${dlist.raisedThrough}" /></td>
						<td nowrap="nowrap">CLOSEDDATE:	<fmt:formatDate pattern="dd-MM-yyyy" value="${dlist.closedDate}" /></td>
						<td nowrap="nowrap">CLOSEDBY:<c:out value="${dlist.closedBy}" /></td>
						<td nowrap="nowrap">STATUS:<c:out value="${dlist.status}" /></td>
					</tr>


				</c:forEach>
				
				
				
				<td>
				  <select id="selectedRecord" name="selectedRecord">
				
				 <c:forEach items="${queryReport}" var="dlist">

                <option value="${dlist}">${dlist.raisedBy}</option>

            </c:forEach>
            </select>
				</td>

           



			</tr>
		</table>
	</form>

</body>
</html>