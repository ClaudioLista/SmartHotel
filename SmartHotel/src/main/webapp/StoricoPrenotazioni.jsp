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
<%@ page import="dao.CameraDAOImpl" %>
<%@ page import="dao.GetTodayDate" %>

<%
	String pageTitle = "Storico prenotazioni";
	request.setAttribute("pageTitle", pageTitle);
	Utente c = (Utente) session.getAttribute("utente");
	ArrayList<model.Prenotazione> listaPrenotazioni = (ArrayList<model.Prenotazione>) request.getAttribute("listaPrenotazioni");
	CameraDAOImpl camDAO = new CameraDAOImpl();
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
						<th>Tipo Camera</th>
						<th>Num Ospiti</th>
						<th>Prezzo</th>
						<th> </th>
					</tr>
				</thead>
				<tbody>

					<%
						int k = 1;
						for (Prenotazione p : listaPrenotazioni) {
					%>
					<tr>
						<th style="display: ruby block"># <%=k%> <%=""%>

						</th>
						<td><%=p.getDataPrenotazione()%></td>
						<td><%=p.getCheckIn()%></td>
						<td><%=p.getCheckOut()%></td>
						<td><%=camDAO.getbyNumCamera(Integer.parseInt(p.getCamera())).getTipo()%></td>
						<td><%=p.getNumOspiti()%></td>
						<td><%=p.getPrezzo()%> €</td>
						
					<%
					
						GetTodayDate gtd = new GetTodayDate();
						String dataString = gtd.main();
						Date data = Date.valueOf(dataString);
						long diff = p.getCheckIn().getTime()-data.getTime();
						TimeUnit time = TimeUnit.DAYS; 
				        long numeroGiorni = time.convert(diff, TimeUnit.MILLISECONDS);
				        
				        boolean checkInEffettuato = p.isCheckInEffettuato();
				        
						if(numeroGiorni <= 1 && !checkInEffettuato) {
					%>
					
						<td>
						
						<form action="EffettuaCheckIn" method="POST">
							<input type="hidden" name="idPrenotazione"
								value="<%=p.getIdPrenotazione()%>">
														
						
						<button class="btn btn-secondary" type="submit" Name="submit"
							id="submit">Effettua Check-In</button>
						</td>
						
					<%
					} else if (checkInEffettuato) {
						
					%>	
					
						<td>
						
						<form action="NavPinCamera" method="POST">
							<input type="hidden" name="pinCamera"
								value="<%=p.getPINCamera()%>">
						
						<button class="btn btn-secondary" type="submit" Name="submit"
							id="submit">Visualizza il tuo PIN!</button>
						</td>
					
					<%
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