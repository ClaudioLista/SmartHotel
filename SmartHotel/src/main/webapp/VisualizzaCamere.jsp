<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@	page import="model.Utente"%>
<%@	page import="java.util.ArrayList"%>
<%@	page import="model.Camera"%>

<%
	String pageTitle = "Gestione camera";
	request.setAttribute("pageTitle", pageTitle);
	Utente c = (Utente) session.getAttribute("utente");
	ArrayList<model.Camera> listaCamere = (ArrayList<model.Camera>) request.getAttribute("listaCamere");
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
						<th># Camera</th>
						<th>Numero Camera</th>
						<th>Visibilità</th>
						<th>Tipo Camera</th>
						<th>Numero Posti </th>
						<th>Dimensione</th>
						<th>Prezzo</th>
					</tr>
				</thead>
				<tbody>

					<%
						int k = 1;
						for (Camera cam : listaCamere) {
					%>
					<tr>
						<th style="display: ruby block"># <%=k%> <%=""%>

							<form action="EliminaCamera" method="POST">
								<input type="hidden" name="id"
									value="<%=cam.getIdCamera()%>">
									
								<button class="btn action-button" role="button" type="submit">
									<i class="material-icons">remove_red_eye</i>
								</button>
						
							</form>
						</th>
						<td><%=cam.getNumCamera()%></td>
						<td><%=cam.isPrenotabile()%> </td>
						<td><%=cam.getTipo()%></td>
						<td><%=cam.getNumPosti()%></td>
						<td><%=cam.getDimensione()%></td>
						<td><%=cam.getPrezzo()%> €</td>
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