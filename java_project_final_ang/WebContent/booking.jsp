
<%@page import="com.cdac.dto.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %> 
<%@ include file="simple_header.jsp" %> 
<% 
	if(session.getAttribute("user")!=null ){
		
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking form</title>
</head>
<body>
<div class="container-fluid" style="height: 100vh ;background-image: url('stadium2.jpg');
 background-size:cover;background-position:center; background-repeat:no-repeat; background-origin: content-box;
  background-attachment: fixed;
 ">
	<div align="center"><img src="stadium1.png" alt="stadium view" style="width:700px;height:300px;"></div></br>
	<div align="center" style="background-color: grey" >
		
		<% 
		List<Book> elist = (List<Book>)request.getAttribute("blist");
		if(elist.isEmpty()){%>
			<h3 style="color: red;">No Seats Available in this section!</h3></div>
		<%}else{ Book b1=(Book)elist.get(0);%>
			<h3 style="color:red; font-family: cursive;">Seats Available in Section <%=b1.getSection()%> : </h3>
			<h3 style="color:green;  font-family:sans-serif; font-size: 30px">|
		<%for(Book b : elist){
		%>
				<%=b.getSeatNo()%>|
		<% }%> 
			
		</h3>	
	</div>
	
	<div  style="background-color: grey; margin: 20px" align="center" >
	<spr:form action="add_seat.htm" method="get" commandName="book"  >
	<table align="center" >
		<tr>
			<td class="form-group ">
				<h4 class="mt-5">Seat No:</h4>
			</td>
			<td>
				<spr:input path="seatNo" class="form-control mt-5"/>
			</td>
		</tr>
		<tr>
			<td>
				
			</td>
			<td>
				<input class="btn btn-danger mt-3" type="submit"  value="Add" >
			</td>
		</tr>
		
	</table>
	</spr:form>
	
	<% }%>
	
	
			
			<div align="center" class="mt-3" >
				<a class="btn btn-danger" href="home.jsp" style="margin-bottom: 10px;">Back to home</a>
			</div>
		</div>
	</div>
		
</body>
</html>

<% }else{
	response.sendRedirect("index.html");	
	}
%>