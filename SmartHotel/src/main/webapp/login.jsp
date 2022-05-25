<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	
	
	<% 	String pageTitle= "Login";
   	request.setAttribute("pageTitle", pageTitle);%>


<div class="container" style="padding-top: 180px">
	<p>
		<span><%= pageTitle %></span>
	</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="login-clean">
		<form method="POST" action="login">
			<h2 class="sr-only">Login Form</h2>
			<div class="form-group">
				<input class="form-control" type="email" name="email" id="email"
					placeholder="Email" onchange="verifyL(this.value, this.id)" />
				<div class="invalid-feedback">Hai sbagliato il formato</div>
			</div>
			<div class="form-group">
				<input class="form-control" type="password" name="password"
					placeholder="Password" />
			</div>
			<div class="form-group">
				<button class="btn btn-secondary btn-block" type="submit"
					id="submit">Log In</button>
			</div>
		</form>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

	
	
</body>
</html>

