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
		<title>���� �������</title>
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
				<h2 class="title">
			���������� ������� � ����� ���������� �������� ������
			</h2>					
					<div class="entry">
					<center>
					<form:form>
						<table border=1 class="tableHoriz">
						       <tr>                                        
										<td class="header">
										������ �������:
										</td>
										<td width="150" class="header">
										<form:textarea path="login" rows="5" cols="20"/>
										<form:errors path="login" />										
										</td>										
							   </tr>
						       <tr>                                        
										<td class="header">
										������ ������ ������ ������
										</td>
										<td width="150" class="header">
										<form:input path="var1"/>
										<form:errors path="var1" />										
										</td>
										
								</tr>
								<tr>                                        
										<td class="header">
										������ ������ ������ ������
										</td>
										<td width="150" class="header">
										<form:input path="var2"/>
										<form:errors path="var2" />										
										</td>										
								</tr>	
								<tr>                                        
										<td class="header">
										������ ����� ������ ������
										</td>
										<td width="150" class="header">
										<form:input path="var3"/>
										<form:errors path="var3" />										
										</td>										
								</tr>
								<tr>                                        
										<td class="header" class="header">
										������ ��������� ������ ������
										</td>
										<td width="150" class="header">
										<form:input path="var4"/>
										<form:errors path="var4" />										
										</td>										
								</tr>
								<tr>                                        
										<td class="header">
										������ �'���� ������ ������
										</td>
										<td width="150" class="header">
										<form:input path="var5"/>
										<form:errors path="var5" />										
										</td>										
								</tr>
								<tr>                                        
										<td class="header">
										������ �-�� ���� �� ��������� �������<br/>										 
										</td>
										<td width="150" class="header">
										<form:input path="level"/>
										<form:errors path="level" />										
										</td>										
								</tr>
								<tr>                                        
										<td class="header">
										���� � ��� ������� ����������?
										</td>
										<td width="150">
										 <form:radiobutton path="correct" value="1"/> ������<br/>
										<form:radiobutton path="correct" value="2"/> ������ <br/>
										<form:radiobutton path="correct" value="3"/> ����� <br/>
										<form:radiobutton path="correct" value="4"/> ���������<br/>
										<form:radiobutton path="correct" value="5"/> �'����<br/>										
										<form:errors path="correct" />										
										</td>										
								</tr>						
						</table>
						<tr>
								    <td>
								    <br/>
									<input type="submit" name="next" value="������ �������"/>	
									<input type="submit" name="finish" value="���������"/>	
									</td>
									<br/><br/>������� �� ������ ������� ���� <form:checkbox path="level2" value="1"/>
									
															
						</tr>		
						</form:form>
					</div>
					</center>
				</div>
			</div>
		</div>
	</body>
</html>