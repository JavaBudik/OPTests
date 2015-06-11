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
		<title>����������</title>
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
							<i>������� ���������� ����� � ��</i>
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
						���� ������������
					</h2>
					<div class="content">
						<ul>
							<li>
								<a href="addchoice.htm"><strong>������ ����</strong> </a>
								<br />
							<li>
								<a href="alltest.htm"><strong>������ �����</strong> </a>
								<br />
							<li>
								<a href="statForAdmin.htm"><strong>���������� ���������</strong> </a>
								<br />	
							<li>
								<a href="search.htm"><strong>�����</strong> </a>
								<br />	
							<li>
								<a href="allusers.htm"><strong>���������� ��� ��������</strong> </a>
								<br />							
							<li>
								<a href="logout.htm"><strong>�����</strong> </a>
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
						����������
					</h2>
					<div class="entry">
					<center>					   
						<table class="tableHoriz">
							<tr align="center" class="header">
							    <td>
									ϲ�
								</td>
								<td>
									�����
								</td>
								<td>
									����
								</td>								
								<td>
									����� �����
								</td>
								<td>
									������
								</td>
								<td>
									ʳ������ ����
								</td>
								<td>
									����
								</td>
							</tr>
							<c:forEach items="${results}" var="res">
								<tr align="center">
								    <td>
										<c:out value="${res.pib}" />
									</td>
									<td>
										<c:out value="${res.group}" />
									</td>
									<td>
										<c:out value="${res.login}" />
									</td>
									<td>
										<c:out value="${res.test}" />
									</td>
									<td>
										<c:out value="${res.mark}" />
									</td>
									<td>
										<c:out value="${res.ball}" />
									</td>
									<td>
										<c:out value="${res.date}" />
									</td>
								</tr>
							</c:forEach>
						</table>					
						<br/>&nbsp
					</div>
					</center>
				</div>
			</div>
		</div>
	</body>
</html>