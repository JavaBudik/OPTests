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
		<title>Список доступних тестів</title>
		<link rel="stylesheet" type="text/css" href="css/style.css" />

	</head>
	<body>
		<div id="header">
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
						Меню користувача
					</h2>
					<div class="content">
						<ul>
							<li>
								<a href="profile.htm"><strong>Профіль</strong> </a>
								<br />
							<li>
								<a href="testList.htm"><strong>Список тестів</strong> </a>
								<br />
							<li>
								<a href="userStat.htm"><strong>Результати тестувань</strong>
								</a>
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
					<h2 class="title">
						Результати тесту<br/>
					</h2>
					<div class="entry">
						<center>
						<b> Максимальна кількість балів: <c:out value="${maxBall}" />
							<BR /> Максимальна оцінка 100 <br /> Набрана кількість балів: <c:out
								value="${mark}" /> <br /> Оцінка: <c:out
								value="${yourMark}" /> <br /> </b>
						<br />
					</div>
					</center>
				</div>
			</div>
		</div>
	</body>
</html>