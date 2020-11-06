
<%@page import="com.cdac.dto.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ include file="simple_header.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
<div class="container-fluid " style="height: 100vh ;background-image: url('stadium2.jpg');
 background-size:cover;background-position:center; background-repeat:no-repeat; background-origin: content-box;
  background-attachment: fixed;
 ">
	<div class="bg-danger" style=" margin: 20px" align="center" ><h2>Booked Seats</h2></div>
	<% 
		int sum=0;
		List<Book> mli = (List<Book>)request.getAttribute("mlist");
		if(mli.isEmpty())
		{%>
			<div align="center">
				<h3 style="color: red;">You have not booked any seats!!</h3><br>
				<h3><a href="prep_book_seat_form.htm">Book Now</a></h3>
			</div>
		<%}else{%>
		
		<table align="center" style="background-color: gray; text-align: center; font-family: 'Merriweather', serif;" cellspacing="35px">
		<tr>
			<th>Section</th>
			<th>Seat Number</th>
			<th>Seat Price(INR)</th>
			<th>Cancel Seat</th>
			<th>Update Seat</th>
		</tr>
		
		
		<%for(Book my : mli){
		%>
		<tr>
			<td>
				<%=my.getSection()%>
			</td>
			<td>
				<%=my.getSeatNo()%>
			</td>
			<td>
				<%=my.getPrice()%>
			</td>
			<td>
				<a style="color:white" class="btn btn-outline-danger" href="seat_delete.htm?seatNumber=<%=my.getSeatNo()%>&sect=<%=my.getSection()%>">Delete</a>
			</td>
			<td>
				<a style="color:white" class="btn btn-outline-danger" href="seat_update_form.htm?seatNumber=<%=my.getSeatNo()%>&sect=<%=my.getSection()%>">Update</a>
			</td>
			<%sum=sum+my.getPrice(); %>
		</tr>
		<% } %>
		<tr >
			<td colspan="5" style="text-align: center; color:#641E16; background-color:#A3E4D7; font-family: 'Merriweather', serif;font-size:30px"><p>Total price:  <b>&#x20B9</b> <%= sum %></p></td>
		</tr>
		</table>
		<%}%>
		
		
	<div align="center"><a style="" class="btn btn-danger" href="home.jsp" >Back</a></div>
	</div>
</body>
</html>