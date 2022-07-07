<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@	page import="model.Utente"%>

<%
	String pageTitle = "Aggiungi Camera";
	request.setAttribute("pageTitle", pageTitle);
	Utente c = (Utente) session.getAttribute("utente");
%>

<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 180px">
	<p>
		<span><%=pageTitle%></span>
	</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="row register-form">
		<div class="col-md-8 offset-md-2">

			<form method="POST" action="AggiungiCamera" class="custom-form">
				<h1>Inserisci i dati della nuova camera:</h1>
				
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer01">Numero Camera</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="text" class="form-control" id="numCamera"
							Name="numCamera" placeholder="XXX"/>
					</div>
				</div>

				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer01">Tipo Camera</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="text" class="form-control" id="tipoCamera"
							Name="tipoCamera" placeholder="Doppia Standard"/>
					</div>
				</div>
				
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer03">Numero posti</label>
					</div>
					<div class="col-sm-6 input-column">
						<fieldset>
						<select name="numPosti" >
						<option value="1" selected="selected">1 </option>
						<option value="2">2 </option>
						<option value="3">3 </option>
						<option value="4">4 </option>
						</select>
						</fieldset>
					</div>
				</div>
				
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer01">Dimensione</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="text" class="form-control" id="dimCamera"
							Name="dimCamera" placeholder="xx mq"/>
					</div>
				</div>
				
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer01">Descrizione</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="text" class="form-control" id="desCamera"
							Name="desCamera" placeholder=""/>
					</div>
				</div>
				
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer01">Prezzo</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="text" class="form-control" id="prezzoCamera"
							Name="prezzoCamera" placeholder=""/>
					</div>
				</div>
				
				<input type="hidden" name="email" value='<%=c.getEmail()%>'/>
				
				<button class="btn btn-secondary" type="submit" Name="submit"
					id="submit">Aggiungi Camera</button>
					
			</form>

		</div>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />