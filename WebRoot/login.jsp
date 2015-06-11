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
<title>Сторінка авторизації</title>
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
		<div id="sidebar">
			<div id="useful-links" class="box">
				<h2 class="title">Вхід до системи</h2>
				<div class="content">
                  <form:form>
                 <table border=1 class="tableHoriz">
								<tr>                                        
										<td class="header">
										Логін
										</td>
										<td>
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
								<tr align=right>
								<td></td>
								    <td align="right">
										<input type="submit" name="control" value="Увійти"/>
									</td>
								</tr>
								</table>		
                 </form:form>      
			            <center>       
                        <p align="center">
                        	<a href="register.htm">Зареєструватися</a>	
                        </p>
                        
                         </br>		
				</div>
			</div>
		</div>		
		<div id="content">
			<div class="post">
				<h2 class="title"> 	</h2>
				<div class="entry">
					<center><h2>Ласкаво просимо в систему оцінювання знань з охорони праці<br/></h2><h3>Щоб увійти до системи, введіть свої логін та пароль, будь ласка!</h3>
                              
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>