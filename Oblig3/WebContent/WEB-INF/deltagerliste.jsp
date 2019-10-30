<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		<c:forEach items="${deltagerliste}" var="d">
			<c:choose>
				<c:when test="${d.mobil eq mobil}">  
					<tr bgcolor="#aaffaa">
						<c:set var="kjonn" value="${deltager.kjonn}"/>
						<c:choose>
							<c:when test="${kjonn eq 'M'.charAt(0)}">
								<td align="center"><font color="#071ff7">&#9792;</font></td>
							</c:when>
							<c:otherwise>
								<td align="center"><font color="#f24bef">&#9792;</font></td>
							</c:otherwise>
						</c:choose>
						<td><c:out value="${d.fornavn}"/>  <c:out value="${d.etternavn}"/></td>
						<td><c:out value="${d.mobil}"/></td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr bgcolor="#ffffff">
						<c:set var="kjonn" value="${deltager.kjonn}"/>
						<c:choose>
							<c:when test="${kjonn eq 'M'.charAt(0)}">
								<td align="center"><font color="#071ff7">&#9792;</font></td>
							</c:when>
							<c:otherwise>
								<td align="center"><font color="#f24bef">&#9792;</font></td>
							</c:otherwise>
						</c:choose>
						<td><c:out value="${d.fornavn}"/>  <c:out value="${d.etternavn}"/></td>
						<td><c:out value="${d.mobil}"/></td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table>
	<p>
		<a href="utlogget">Ferdig</a>
	</p>
</body>
</html>