
<%
	String pageTitle = "Modifica profilo";
	request.setAttribute("pageTitle", pageTitle);
%>

<jsp:include page="Header.jsp" />

<%@ page import="model.Utente"%>

<%
	Utente c = (Utente) session.getAttribute("utente");
	/* out.write("Utente: "+c.getEmail()); */
%>

<div class="container" style="padding-top: 180px">
	<p>
		<span><%=pageTitle%></span>
	</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="row register-form">
		<div class="col-md-8 offset-md-2">

			<form method="POST" action="ModificaProfilo" class="custom-form">
				<h1>Modifica profilo</h1>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer02">Nuovo numero telefonico</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="text" class="form-control" id="newtel"
							Name="newtel" placeholder="+39" required
							onchange="verifyP(this.id, this.value)">
						<div class="invalid-feedback">Inserire nuocìvo numero di telefono
							</div>
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer02">Nuovo Indirizzo</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="text" class="form-control" id="newindirizzo"
							Name="newindirizzo" placeholder="Via Borrelli 13, Napoli (80040)" required
							onchange="verifyP(this.id, this.value)">
						<div class="invalid-feedback">Inserire via e città
							</div>
					</div>
				</div>
				<div class="form-group">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" id="check"
							Name="check" required onchange=submittingP(this.form)> <label
							class="form-check-label" for="check"> Confermi di esser
							sicuro <br> di questo cambiamento.
						</label>
					</div>
				</div>
				<input type="hidden" name="email" value='<%=c.getEmail()%>'/>
				<button class="btn btn-secondary" type="submit" Name="submit"
					id="submit">Modifica profilo</button>
			</form>

		</div>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />
