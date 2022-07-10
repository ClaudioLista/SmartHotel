<%@page import="ch.qos.logback.core.net.SyslogOutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@	page import="model.Utente"%>
<%@	page import="java.util.ArrayList"%>
<%@	page import="java.sql.Date"%>
<%@	page import="java.sql.Time"%>
<%@	page import="java.text.SimpleDateFormat"%>
<%@	page import="java.util.concurrent.TimeUnit"%>

<%@	page import="model.Prenotazione"%>
<%@	page import="model.Comanda"%>
<%@ page import="dao.CameraDAOImpl" %>
<%@ page import="dao.GetTodayDate" %>

<%
	String pageTitle = "Ordini da servire";
	request.setAttribute("pageTitle", pageTitle);
	Utente c = (Utente) session.getAttribute("utente");
	ArrayList<Comanda> listaOrdini = (ArrayList<Comanda>) request.getAttribute("listaOrdini");
	CameraDAOImpl camDAO = new CameraDAOImpl();
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
						<th># Ordine</th>
						<th>Data Ordine</th>
						<th>Camera</th>
						<th>Riepilogo</th>
						<th>Totale</th>
						<th></th>
					</tr>
				</thead>
				<tbody>

					<%
						int k = 1;
						for (Comanda com : listaOrdini) {
					%>
					<tr>
						<th style="display: ruby block"># <%=k%> <%=""%>

						</th>
						<td><%=com.getDataOrdine()%></td>
						<td><%=com.getNumCamera()%></td>
						<td><%=com.getOrdine()%></td>
						<td><%=com.getTotale()%> €</td>
						<td>
						
						<form action="ComandaServita" method="POST">
						
							<input type="hidden" name="idPrenotazione"
								value="<%=com.getIdOrdine()%>">
							<input type="hidden" name="addettoBar"
								value="<%=c.getEmail()%>">								
						
							<button class="btn btn-secondary" type="submit" Name="submit"
							id="submit">Accetta ordine</button>
							
							</form>
						</td>
										
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