<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@	page import="java.util.ArrayList"%>
<%@	page import="model.Prodotto"%>

<%
	String pageTitle = "Menu";
	request.setAttribute("pageTitle", pageTitle);
	ArrayList<Prodotto> listaProdotti = (ArrayList<Prodotto>) request.getAttribute("listaProdotti");
%>

<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 180px">
	<p>
		<span><%=pageTitle%></span>
	</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
<form class="custom-form" method="POST" action="RicercaDisponibilita">

				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer03">Bevanda:</label>
					</div>
					
					<div class="col-sm-6 input-column">
						<fieldset>
							<select name="bevandaOrdine" >
							<option value="0">-</option>
					<%
						int k = 1;
						for (Prodotto p : listaProdotti) {
							if (p.getTipologia().equals("bevanda")) {
					%>
				
								<option value=<%=p.getNome()%>><%=p.getNome()%></option>
							
					<%
							}
						k++;
						}
					%>
							</select>
						</fieldset>
					</div>
				</div>
				
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer03">Cibo:</label>
					</div>
					
					<div class="col-sm-6 input-column">
						<fieldset>
							<select name="bevandaOrdine" >
							<option value="0">-</option>
					<%
						k = 1;
						for (Prodotto p : listaProdotti) {
							if (p.getTipologia().equals("cibo")) {
					%>
								<option value=<%=p.getNome()%>><%=p.getNome()%></option>
							
					<%
							}
						k++;
						}
					%>
							</select>
						</fieldset>
					</div>
				</div>
				
				<button class="btn btn-secondary" id="submit" Name="submit"
					type="submit">Ordina!</button>
	</form>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />