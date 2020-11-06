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
<meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Booking Form</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</head>
<body>

<div class="container-fluid" style="height: 100vh ;background-image: url('stadium2.jpg');
 background-size:cover;background-position:center; background-repeat:no-repeat; background-origin: content-box;
  background-attachment: fixed;
 ">

	<div align="center"><img src="stadium1.png" alt="stadium view" style="width:900px;height:400px;"></div></br></br></br>
	
	<spr:form action="available_seats.htm" method="post" commandName="book" >
	<table align="center" >
	<thead class="text-light">
		<tr>
			<td class="text-warning font-weight-bold " style="font-family: 'Merriweather', serif;">
				<h1>Select section:</h1>
			</td>
		</tr>
	</thead>
	<tbody class="text-light">
		<tr>
			<td><div >
				<spr:select path="section" style="width:230px;height:40px;">
					<spr:option value="A" >Section A</spr:option>
					<spr:option value="B" > Section B</spr:option>
					<spr:option value="C" > Section C</spr:option>
					<spr:option value="D" > Section D</spr:option>
				</spr:select>
				</div>
			</td>
		</tr>
		
		
	</tbody>
	</table>
	<div class="d-flex justify-content-center align-items-center">
	<a href="home.jsp" class="btn btn-danger  mt-3">Back</a>
	<button class="btn btn-danger ml-3 mt-3" type="submit"  value="See available seats" >See available seats</button>
	</div>
	
	</spr:form>
	</div>
</body>
</html>

<% }else{
	response.sendRedirect("index.html");	
	}
%>