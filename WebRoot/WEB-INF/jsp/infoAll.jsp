<%@ page language="java" import="java.util.*"
	pageEncoding="Windows-1251"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Статистика</title>
		<link rel="stylesheet" type="text/css" href="css/style.css" />

	</head>
	<body>
		<div id="header">
			<hr />
			<table border=0>
				<tr>
					<td>
						<img src="images/logo.gif" height=140 />
					</td>
					<td width=50%>
						<h1>
							<i>Система оцінювання знань з ОП</i>
						</h1>
					</td>
				</tr>
			</table>
			<hr />
		</div>
		<div id="page">
			<div id="sidebar">
				<div class="box">
					<h2 class="title">
						Меню адміністратора
					</h2>
					<div class="content">
						<ul>
							<li>
								<a href="addchoice.htm"><strong>Додати тест</strong> </a>
								<br />
							<li>
								<a href="alltest.htm"><strong>Список тестів</strong> </a>
								<br />
							<li>
								<a href="statForAdmin.htm"><strong>Результати тестувань</strong> </a>
								<br />	
							<li>
								<a href="search.htm"><strong>Пошук</strong> </a>
								<br />	
							<li>
								<a href="allusers.htm"><strong>Інформація про студентів</strong> </a>
								<br />													
							<li>
								<a href="logout.htm"><strong>Вийти</strong> </a>
								<br />
							</li>
						</ul>
					</div>
					<h2 class="title">
						&nbsp
					</h2>
				</div>
			</div>
			<div id="content">
				<div class="post">
				    <center>
					<h2 class="title">
						Інформація про всіх студентів
					</h2>
					<div class="entry">					   
						<table class="tableHoriz">
							<tr align="center" class="header">
							    <td>
									Прізвище
								</td>
								<td>
									Ім'я
								</td>								
								<td>
									По-батькові
								</td>
								<td>
									Логін
								</td>
								<td>
									Пароль
								</td>
								<td>
									Група
								</td>
								<td>
									ВУЗ
								</td>								
							</tr>							
							<c:forEach items="${users}" var="user">
								<tr align="center">
								    <td>
										<c:out value="${user.surname}" />
									</td>
									<td>
										<c:out value="${user.firstName}" />
									</td>
									<td>
										<c:out value="${user.middleName}" />
									</td>
									<td>
										<c:out value="${user.login}" />
									</td>
									<td>
										<c:out value="${user.password}" />
									</td>
									<td>
										<c:out value="${user.group}" />
									</td>
									<td>
										<c:out value="${user.vuz}" />
									</td>																
								</tr>
							</c:forEach>
							
														
						</table>					
					</div>
					</center>
				</div>
			</div>
		</div>
	</body>
</html>