<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@	page import="model.Utente"%>
<%@	page import="java.util.ArrayList"%>
<%@	page import="model.Prenotazione"%>

<%
	String pageTitle = "Storico prenotazioni";
	request.setAttribute("pageTitle", pageTitle);
	Utente c = (Utente) session.getAttribute("utente");
	ArrayList<model.Prenotazione> listaPrenotazioni = (ArrayList<model.Prenotazione>) request.getAttribute("listaPrenotazioni");
%>

<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 180px">
	<p>
		<span><%=pageTitle%></span>
	</p>
</div>
<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="row" id="container-tabelle">
		<div class="col">
			<table class="table table-hover">
				<thead>
					<tr>
						<th># Prenotazione</th>
						<th>Data Prenotazione</th>
						<th>Check in </th>
						<th>Check Out</th>
						<th>Camera</th>
						<th>Num Ospiti</th>
						<th>Prezzo</th>
					</tr>
				</thead>
				<tbody>

					<%
						int k = 1;
						for (Prenotazione p : listaPrenotazioni) {
					%>
					<tr>
						<th style="display: ruby block"># <%=k%> <%=""%>

							<form action="EliminaPrenotazione" method="POST">
								<input type="hidden" name="id"
									value="<%=p.getIdPrenotazione()%>">
								<button class="btn action-button" role="button" type="submit">
									<i class="material-icons">delete</i>
								</button>
							</form>
						</th>
						<td><%=p.getDataPrenotazione()%></td>
						<td><%=p.getCheckIn()%></td>
						<td><%=p.getCheckOut()%></td>
						<td><%=p.getCamera()%></td>
						<td><%=p.getNumOspiti()%></td>
						<td><%=p.getPrezzo()%></td>
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