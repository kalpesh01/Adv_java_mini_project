<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<!-- jQuery and JS bundle w/ Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

<title>Login</title>
</head>
<body>
		<div class="container-fluid d-flex justify-content-center" style="height: 100vh ;background-image: url('stadium2.jpg');
 background-size:cover;background-position:center; background-repeat:no-repeat; background-origin: content-box;
  background-attachment: fixed;
 ">
		
		<spr:form  action="login.htm" class="w-50 mt-5" method="post" commandName="user" ><br><br>
		<table class="table table-striped " >
			<thead class="text-light">
				
				<tr class="text-center "  style="font-weight:bold">
					<th colspan="2"  ><h3 class="btn btn danger" style="font-size: 25px ; font-weight: bold;">Login Here</h3></th>
				</tr>
			</thead>
			<tbody class="text-light">
				<tr>
					<td><h4 style="color:black;font-size: medium;font-weight: bold;" class="btn btn danger">Email Id : </h4></td>
					<td><spr:input class="form-control" path="emailId"/>
					<spr:errors style="color:red" path="emailId" ></spr:errors></td>
				</tr>
				<tr>
					<td><h4 style="color:black;font-size: medium;font-weight: bold;" class="btn btn danger">Password : </h4></td>
					<td><spr:input type="password" class="form-control" path="userPass"/>
					<spr:errors style="color:red" path="userPass" ></spr:errors></td>
				</tr>
				
			</tbody>
		</table>
		<div class="row justify-content-center">
		<div class="col-4 d-flex justify-content-end align-items-center" >
				<a class="primary" href="prep_forget_pass1.htm" style="color:red;font-size: medium;font-weight: bold;" >forget password</a>
			</div>
			<div class="col-4 d-flex justify-content-end align-items-center">
				<input type="submit" class="btn btn-primary w-50 " value="login"   />
			</div>
			<div class="col-4 d-flex justify-content-start align-items-center">
				<a href="prep_reg_form.htm"<button class="btn btn-primary w-100  " onclick="prep_reg_form.htm" > Sign Up </button>></a>
			</div>	
		</div>
	</spr:form>
	</div>
</body>
</html>