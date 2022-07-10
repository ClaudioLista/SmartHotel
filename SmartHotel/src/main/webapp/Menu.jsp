<%@page import="ch.qos.logback.core.net.SyslogOutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@	page import="model.Utente"%>
<%@	page import="javax.servlet.http.HttpServletRequest"%>
<%@	page import="java.util.ArrayList"%>
<%@	page import="model.Prodotto"%>

<%
	String pageTitle = "Menu";
	request.setAttribute("pageTitle", pageTitle);
	Utente c = (Utente) session.getAttribute("utente");
	ArrayList<Prodotto> listaProdotti = (ArrayList<Prodotto>) request.getAttribute("listaProdotti");
%>

<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 180px">
</div>
<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="row" id="container-tabelle">
		<div class="col">
		
			<form method="POST" action="InvioComanda" class="custom-form">
				<h2>Effettua il tuo ordine:</h2>
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Prezzo</th>
						<th>Quantità</th>
					</tr>
				</thead>
				<tbody>

					<%
						int k = 1;
						for (Prodotto p : listaProdotti) {
					%>
					<tr>
						<td><%=p.getNome()%></td>
						<td><%=p.getPrezzo()%> €</td>
						<td>
							<div class="form-row form-group">
								<div class="col-sm-6 input-column">
									<input type="text" class="form-control" id=<%=p.getIdProdotto()%>
										Name=<%=p.getIdProdotto()%> value=0 placeholder="">
								</div>
							</div>
						</td>
					</tr>
					<%
						k++;
						}
					%>

				</tbody>
			</table>
			
			<input type="hidden" name="intestatario"
						value="<%=c.getEmail()%>">
			
			<button class="btn btn-secondary" type="submit" Name="submit"
			id="submit">Invia ordine!</button>
			
			</form>
			
		</div>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />