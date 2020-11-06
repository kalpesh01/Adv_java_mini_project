<%@page import="com.cdac.dto.User"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <%@ include file="header.jsp" %>
   
<% 
	if(session.getAttribute("user")!=null ){
		
%>     
  
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<div class="container-fluid " style="height: 100vh ;background-image: url('stadium2.jpg');
 background-size:cover;background-position:center; background-repeat:no-repeat; background-origin: content-box;
  background-attachment: fixed;
 ">
	<div class="row ">
            <div class="col d-flex justify-content-center align-items-center mt-5">
                <a href="prep_book_seat_form.htm" class=" btn btn-danger  text-dark" style="font-family: 'Merriweather', serif;"> Book
                    Seat >> </a>

            </div>
        </div>
        <div class="row  mt-5">
            <div class="col d-flex justify-content-center">
                <a href="prep_see_list.htm" class="btn btn-danger text-dark " style="font-family: 'Merriweather', serif;"> My
                    Bookings >> </a>
            </div>
        </div>
      </div>
</body>
</html>

<% }else{
	response.sendRedirect("index.html");	
	}
%>
