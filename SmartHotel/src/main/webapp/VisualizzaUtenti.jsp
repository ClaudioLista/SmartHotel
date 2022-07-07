<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@	page import="model.Utente"%>
<%@	page import="java.util.ArrayList"%>
<%@	page import="model.Prenotazione"%>

<%
	String pageTitle = "Visualizza Utenti";
	request.setAttribute("pageTitle", pageTitle);
	Utente c = (Utente) session.getAttribute("utente");
	ArrayList<Utente> listaUtenti = (ArrayList<Utente>) request.getAttribute("listaUtenti");
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
						<th># Utente</th>
						<th>Nome</th>
						<th>Cognome</th>
						<th>E-mail</th>
						<th>Data di nascita</th>
						<th>Telefono</th>
						<th>Indirizzo</th>
					</tr>
				</thead>
				<tbody>

					<%
						int k = 1;
						for (Utente u : listaUtenti) {
					%>
					<tr>
						<th style="display: ruby block"># <%=k%> <%=""%>
						
						</th>
							<td><%=u.getNome()%></td>
							<td><%=u.getCognome()%></td>
							<td><%=u.getEmail()%></td>
							<td><%=u.getDataNascita()%></td>
							<td><%=u.getTelefono()%></td>
							<td><%=u.getIndirizzo()%></td>
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