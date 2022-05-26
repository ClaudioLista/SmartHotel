
<% 	String pageTitle= "Login";
   	request.setAttribute("pageTitle", pageTitle);%>

<jsp:include page="Header.jsp" />

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
			<div class="illustration">
				<img src="img/profilo.png" width="50%">
			</div>
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

<jsp:include page="Footer.jsp" />