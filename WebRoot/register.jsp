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
<title>Сторінка реєстрації</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>

<body>
<div id="header">
	<hr/><table border=0><tr><td>
	<img src="images/logo.gif" height=140></td><td width=50%><h1 align=center><i>Система оцінювання знань з ОП</i></h1></td></tr></table>
	<hr/>
</div>
<div id="bg">
	<div id="page">
		
		<h2>Будь ласка, заповніть реєстраційну форму</h2>
                         <form:form>
								<table border=1 class="tableHoriz">
								<tr>                                        
										<td class="header">
										Логін
										</td>
										<td width="150">
										<form:input path="login"/>
										<form:errors path="login" />										
										</td>
										
								</tr>
                                 <tr>
                                 <td class="header">
										Пароль
										</td>
										<td width="150">
										<form:password path="password"/>
										<form:errors path="password" />										
										</td>
										
								</tr>
								<tr>
								<td class="header">
										Ім'я
										</td>
										<td width="150">
										<form:input path="firstName"/>
										<form:errors path="firstName" />										
										</td>
										
								</tr>
								<tr>
								<td class="header">
										По-батькові
										</td>
										<td width="150">
										<form:input path="middleName"/>
										<form:errors path="middleName" />										
										</td>
										
								</tr>
								<tr>
								<td class="header">
										Прізвище
										</td>
										<td width="150">
										<form:input path="surname"/>
										<form:errors path="surname" />										
										</td>										
								</tr>
								<tr>
								<td class="header">
										ВУЗ
										</td>
										<td width="150">
										<form:input path="vuz"/>
										<form:errors path="vuz" />										
										</td>
										
								</tr>
								<tr>
								<td class="header">
										Група
										</td>
										<td width="150">
										<form:input path="group"/>
										<form:errors path="group" />										
										</td>										
								</tr>								
								</table>
								<tr>
								    <td>
									<input type="submit" name="back" value="<< Назад"/>	
									</td>
									<td>
									<input type="submit" name="control" value="Зареєструватися"/>
									</td>
								</tr>										
								
						</form:form>
			</div>					
</div>
</body>
</html>