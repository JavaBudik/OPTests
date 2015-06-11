<%@ page language="java" contentType="text/html; charset=Windows-1251"
    pageEncoding="Windows-1251"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-1251">
<title>������� ���������</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>

<body>
<div id="header">
	<hr/><table border=0><tr><td>
	<img src="images/logo.gif" height=140></td><td width=50%><h1 align=center><i>������� ���������� ����� � ��</i></h1></td></tr></table>
	<hr/>
</div>
<div id="bg">
	<div id="page">
		
		<h2>���� �����, �������� ����������� �����</h2>
                         <form:form>
								<table border=1 class="tableHoriz">
								<tr>                                        
										<td class="header">
										����
										</td>
										<td width="150">
										<form:input path="login"/>
										<form:errors path="login" />										
										</td>
										
								</tr>
                                 <tr>
                                 <td class="header">
										������
										</td>
										<td width="150">
										<form:password path="password"/>
										<form:errors path="password" />										
										</td>
										
								</tr>
								<tr>
								<td class="header">
										��'�
										</td>
										<td width="150">
										<form:input path="firstName"/>
										<form:errors path="firstName" />										
										</td>
										
								</tr>
								<tr>
								<td class="header">
										��-�������
										</td>
										<td width="150">
										<form:input path="middleName"/>
										<form:errors path="middleName" />										
										</td>
										
								</tr>
								<tr>
								<td class="header">
										�������
										</td>
										<td width="150">
										<form:input path="surname"/>
										<form:errors path="surname" />										
										</td>										
								</tr>
								<tr>
								<td class="header">
										���
										</td>
										<td width="150">
										<form:input path="vuz"/>
										<form:errors path="vuz" />										
										</td>
										
								</tr>
								<tr>
								<td class="header">
										�����
										</td>
										<td width="150">
										<form:input path="group"/>
										<form:errors path="group" />										
										</td>										
								</tr>								
								</table>
								<tr>
								    <td>
									<input type="submit" name="back" value="<< �����"/>	
									</td>
									<td>
									<input type="submit" name="control" value="��������������"/>
									</td>
								</tr>										
								
						</form:form>
			</div>					
</div>
</body>
</html>