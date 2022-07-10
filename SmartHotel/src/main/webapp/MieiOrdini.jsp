<%@page import="dao.UtenteDAOImpl"%>
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
<%@ page import="dao.UtenteDAOImpl" %>
<%@ page import="dao.GetTodayDate" %>

<%
	String pageTitle = "Storico Ordini";
	request.setAttribute("pageTitle", pageTitle);
	Utente c = (Utente) session.getAttribute("utente");
	ArrayList<Comanda> listaOrdini = (ArrayList<Comanda>) request.getAttribute("listaOrdini");
	CameraDAOImpl camDAO = new CameraDAOImpl();
	UtenteDAOImpl uDaoImpl = new UtenteDAOImpl();
	Utente addetto = new Utente();
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
						<th>Riepilogo</th>
						<th>Totale</th>
						<th>Servito da</th>
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
						<td><%=com.getOrdine()%></td>
						<td><%=com.getTotale()%> €</td>
						
						<%
							if (com.isServito()) { 
							addetto = uDaoImpl.getbyEmail(com.getDipendenteBar());
						%>
						
						<td><%=addetto.getNome() + " " + addetto.getCognome()%></td>
						
						<% } else { %>
						
						<td>In attesa...</td>
						
						<% } %>
										
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