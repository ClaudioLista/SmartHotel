<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
	String pageTitle = "Area-Personale";
	request.setAttribute("pageTitle", pageTitle);
%>

<jsp:include page="Header.jsp" />

<%@ page import="model.Utente"%>

<%
	Utente c = (Utente) session.getAttribute("utente");
	String result = request.getParameter("result");
%>

<div class="container" style="padding-top: 180px">
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="row" id="container-tabelle">
		<div class="col">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">Nome</th>
						<th scope="col">Cognome</th>
						<th scope="col">E-mail</th>
						<th scope="col">Password</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=c.getNome()%></td>
						<td><%=c.getCognome()%></td>
						<td><%=c.getEmail()%></td>
						<td><c:forEach var="i" begin="1"
								end='<%=c.getPassword().length()%>'>
							*</c:forEach> <a class="btn action-button" role="button"
							href="NavModificaPassword"> <i class="material-icons">edit</i>
						</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
			<td>
						
						<form action="NavModificaProfilo" method="POST">
								<input type="hidden" name="idUtente"
									value="<%=c.getIdUtente()%>">
														
						
						<button class="btn btn-secondary" type="submit" Name="submit"
							id="submit">Modifica Profilo</button>
		</td>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />
