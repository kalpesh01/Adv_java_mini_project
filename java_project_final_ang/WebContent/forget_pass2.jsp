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
		
		<spr:form action="forget_pass_pass.htm" class="w-50 mt-5" method="post" commandName="user" ><br><br>
		<table class="table table-striped" >
			<thead class="text-light">
				
				<tr class="text-center "  style="font-weight:bold">
					<th colspan="2"  ><h3 class="btn btn danger" style="font-size: 25px ; font-weight: bold;">Reset Password</h3></th>
				</tr>
			</thead>
			<tbody class="text-light">
				<tr>
					<td><h4 class="btn btn danger">Password : </h4></td>
					<td style="width:50%"><spr:input class="form-control" path="userPass" placeholder="Enter the password"/>
					<spr:errors path="userPass" ></spr:errors></td>
				</tr>
				
			</tbody>
		</table>
		<div class="row justify-content-center">
		<div class="col-4 d-flex justify-content-end align-items-center">
				<a class="btn btn-danger" href="prep_forget_pass1.htm" >Back</a>
			</div>
			<div class="col-4 d-flex justify-content-end align-items-center">
				<input type="submit" class="btn btn-primary w-50 " value="Submit"   />
			</div>
		</div>
	</spr:form>
	</div>
</body>
</html>