<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@	page import="model.Utente"%>

<%
	String pageTitle = "Check-In";
	request.setAttribute("pageTitle", pageTitle);
	int idPrenotazione = (int) request.getAttribute("idPrenotazione");
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
			<form class="custom-form" method="POST" action="ConfermaCheckIn">
				<h1>Inserire i dati per effettuare il check-in</h1>
				
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer03">Tipo documento</label>
					</div>
					<div class="col-sm-6 input-column">
						<fieldset>
						<select name="tipoDoc" >
						<option value="CI" selected="selected">Carta d'identità </option>
						<option value="PI">Patente</option>
						<option value="PP">Passaporto </option>

						</select>
						</fieldset>
					</div>
					<div class="col-sm-4 label-column">
						<label for="validationServer03">Numero documento</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="text" class="form-control" id="numDoc"
							placeholder="Numero documento" Name="numDoc"
							>
							</div>
							
							
						<div class="col-sm-4 label-column">
						<label for="validationServer03">Foto Carta</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="file" class="form-control" id="pathImmagine"
							placeholder="Foto documento" Name="pathImmagine"
							>
							</div>
					</div>
					<input type="hidden" name="idPrenotazione1"
									value="<%=idPrenotazione%>">
					<input type="hidden" name="emailIntestatario"
									value="<%=c.getEmail()%>">
					<button class="btn btn-secondary" id="submit" Name="submit"
					type="submit">Submit</button>	
					</div>

				</div>

			</div>
				
			</form>
			</div>
			</div>	
	</div>
				
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />