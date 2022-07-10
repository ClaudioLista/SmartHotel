<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
	String pageTitle = "Il tuo PIN";
	request.setAttribute("pageTitle", pageTitle);
%>

<jsp:include page="Header.jsp" />

<%@ page import="model.Utente"%>

<%
	Utente c = (Utente) session.getAttribute("utente");
	String result = request.getParameter("result");
	int PIN = Integer.parseInt(request.getParameter("pinCamera"));
	String numCamera = request.getParameter("numCamera");
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
						<th scope="col">Il tuo PIN:</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=PIN%></td>
						<td>Il seguente PIN potrà essere usato per accedere alla propria camera.</td>
					</tr>
				</tbody>
			</table>
			
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">Il numero della tua camera:</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=numCamera%></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />
