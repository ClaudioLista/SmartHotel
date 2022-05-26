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
	<div class="row register-form">
		<div class="col-md-8 offset-md-2">
			<form class="custom-form" method="POST" action="Registrazione">
				<h1>Inserire i dati</h1>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer01">Nome</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="text" class="form-control" id="nome"
							placeholder="Ciro" Name="nome" required
							onchange="verify(this.id, this.value)">
						<div class="invalid-feedback">Da 2 a 25 caratteri, solo
							lettere</div>
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer02">Cognome</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="text" class="form-control" id="cognome"
							placeholder="Marrazzo" Name="cognome" required
							onchange="verify(this.name, this.value)">
						<div class="invalid-feedback">Da 2 a 25 caratteri, solo
							lettere</div>
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer03">E-mail</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="text" class="form-control" id="email" Name="email"
							placeholder="test@test.com" required
							onchange="verify(this.id, this.value)">
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer04">Password</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="password" class="form-control" id="password"
							placeholder="pass1234" Name="password" required
							onchange="verify(this.id, this.value)">
						<div class="invalid-feedback">Può contenere solo '.' o '-'
							all'interno</div>
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer05">Ripeti password</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="password" class="form-control" id="rpassword"
							placeholder="pass1234" Name="rpassword" required
							onchange="verify(this.id, this.value)">
						<div class="invalid-feedback">Deve essere uguale a password</div>
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer01">Data di Nascita</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="text" class="form-control" id="data"
							placeholder="AAAA-MM-GG" Name="data" required
							onchange="verify(this.id, this.value)">
						<div class="invalid-feedback">FORMATO DATA AAAA-MM-GG</div>
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer01">Indirizzo</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="text" class="form-control" id="indirizzo"
							placeholder="Via Borrelli 13, Napoli (80040)" Name="indirizzo" required
							onchange="verify(this.id, this.value)">
						<div class="invalid-feedback">Inserire Via e Città</div>
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer01">Telefono</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="text" class="form-control" id="tel"
							placeholder="+39" Name="tel" required
							onchange="verify(this.id, this.value)">
						<div class="invalid-feedback">Inserire numero di telefono</div>
					</div>
				</div>
				<div class="form-group">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" id="check"
							Name="check" required onchange=submitting(this.form)> <label
							class="form-check-label" for="check"> Accetta termini e
							condizioni, <br>per l'utilizzo dei dati per profilazione.
						</label>
					</div>
				</div>
				<button class="btn btn-secondary" id="submit" Name="submit"
					type="submit">Submit</button>
			</form>
		</div>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->
	
<jsp:include page="Footer.jsp" />

