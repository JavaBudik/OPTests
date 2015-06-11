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
<title>Register page</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>

<body>
<div id="header">
	<hr/><table border=0><tr><td>
	<img src="images/logo.gif" height=140></td><td width=50%><h1 align=center><i>Система оцінювання знань з охорони праці</i></h1></td></tr></table>
	<hr/>
</div>
<div id="bg">
	<div id="page">
		
		<h2>Будь-ласка, заповніть реєстраційну форму</h2>
		<form action="/OPTests/reg2.htm" method="POST">
		<table border=1 class="tableHoriz">
			<tr>                                        
	        <td class="header">
		    Логін</td>
		    <td width="150">	    
           <p><input type="text" name="login"></p>           
           </td>
           </tr>  
           </table>
           <input type="submit" value="log in">      
		</form>                       
	</div>					
</div>
</body>
</html>








