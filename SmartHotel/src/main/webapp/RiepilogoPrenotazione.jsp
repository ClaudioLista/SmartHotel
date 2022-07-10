<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@	page import="model.Utente"%>
<%@	page import="model.Camera"%>
<%@	page import="java.util.ArrayList"%>
<%@	page import="java.sql.Date"%>

<%
	String pageTitle = "Riepilogo Prenotazione";
	request.setAttribute("pageTitle", pageTitle);
	Utente c = (Utente) session.getAttribute("utente");
	Camera CameraPrenotazione = (Camera) request.getAttribute("Camera");
	Date checkIn = (Date) request.getAttribute("checkIn");
	Date checkOut = (Date) request.getAttribute("checkOut");
	int numOspiti = (int) request.getAttribute("numOspiti");
	double prezzoTotale = (double) request.getAttribute("PrezzoTotale");
%>

<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 180px">
</div>
<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="row" id="container-tabelle">
		<div class="col">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Check In</th>
						<th>Check Out</th>
						<th>Camera scelta </th>
						<th>Numero ospiti</th>
						<th>Prezzo Totale</th>

					</tr>
				</thead>
				<tbody>
					
					<tr>
						<td><%=checkIn%></td>
						<td><%=checkOut%></td>
						<td><%=CameraPrenotazione.getTipo()%></td>
						<td><%=numOspiti%></td>
						<td><%=prezzoTotale%> €</td>
					</tr>

				</tbody>
			</table>
			
		</div>
	</div>
	
	<div class="row register-form">
		<div class="col-md-8 offset-md-2">
			<form class="custom-form" method="POST" action="ConfermaPrenotazione">
			
				<%
			// l'utente è l'admin
				if (c.getTipoUtente() == 0) {
			%>
			
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer03">E-mail intestatario:</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="text" class="form-control" id="emailIntestatario" Name="emailIntestatario"
							placeholder="test@test.com" required
							onchange="verify(this.id, this.value)">
					</div>
				</div>

			<%
				
				} 
			%>
			
				<h1>Conferma la prenotazione</h1>
				
				<input type="hidden" name="checkIn"
						value="<%=checkIn%>">
				<input type="hidden" name="checkOut"
						value="<%=checkOut%>">
				<input type="hidden" name="numOspiti"
						value="<%=numOspiti%>">
				<input type="hidden" name="numCamera"
						value="<%=CameraPrenotazione.getNumCamera()%>">
				<input type="hidden" name="intestatario"
						value="<%=c.getEmail()%>">
				<input type="hidden" name="prezzo"
						value="<%=prezzoTotale%>">						
				<div>
				<button class="btn btn-secondary" id="submit" Name="submit"
					type="submit">Conferma Prenotazione</button>
				</div>
			</form>
		</div>
	</div>	
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />