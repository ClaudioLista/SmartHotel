<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@	page import="model.Utente"%>
<%@	page import="java.util.ArrayList"%>
<%@	page import="java.sql.Date"%>
<%@	page import="model.CameraDisponibile"%>

<%
	String pageTitle = "Gestione camera";
	request.setAttribute("pageTitle", pageTitle);
	Utente c = (Utente) session.getAttribute("utente");
	ArrayList<CameraDisponibile> listaCamere = (ArrayList<CameraDisponibile>) request.getAttribute("listaCamere");
	Date checkIn = (Date) request.getAttribute("checkIn");
	Date checkOut = (Date) request.getAttribute("checkOut");
	int numOspiti = (int) request.getAttribute("numOspiti");
%>

<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 180px">
</div>
<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">

	<%
							// l'utente è loggato
							if (c == null) {
						%>
	<h3>Effettua il login prima di prenotare</h3>
	
	<%
							}
	%>
	<div class="row" id="container-tabelle">
		<div class="col">
			<table class="table table-hover">
				<thead>
					<tr>
						<th># Camera</th>
						<th>Tipo Camera</th>
						<th>Numero Posti </th>
						<th>Dimensione</th>
						<th>Descrizione</th>
						<th>Prezzo per notte</th>
						<th>Camere Disponibili:</th>
						<%
							// l'utente è loggato
							if (c != null) {
						%>
						<th>Prenota</th>
						<%
							}
	%>
					</tr>
				</thead>
				<tbody>

					<%
						int k = 1;
						for (CameraDisponibile cam : listaCamere) {
					%>
					<tr>
						<th style="display: ruby block"># <%=k%> <%=""%>

						</th>
						<td><%=cam.getListaCamere().getTipo()%></td>
						<td><%=cam.getListaCamere().getNumPosti()%></td>
						<td><%=cam.getListaCamere().getDimensione()%></td>
						<td><%=cam.getListaCamere().getDescrizione()%></td>
						<td><%=cam.getListaCamere().getPrezzo()%> €</td>
						<td><%=cam.getDisponibilita()%></td>
						<td>
							<form action="PrenotaCamera" method="POST">
							
								<input type="hidden" name="idCamera"
									value="<%=cam.getListaCamere().getIdCamera()%>">
								<input type="hidden" name="checkIn"
									value="<%=checkIn%>">
								<input type="hidden" name="checkOut"
									value="<%=checkOut%>">
								<input type="hidden" name="numOspiti"
									value="<%=numOspiti%>">
						<%
							// l'utente è loggato
							if (c != null) {
						%>									
							<button class="btn btn-secondary" type="submit" Name="submit"
							id="submit">Prenota</button>
							
							</form>
							
							</td>
						<%
							// l'utente è loggato
							}
						
						%>
														
						
					</tr>
					<%
						k++;
						}
					%>

				</tbody>
			</table>
		</div>
	</div>
	
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />