<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
	String pageTitle = "Prenota Camera";
	request.setAttribute("pageTitle", pageTitle);
%>

<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 180px">
	<p>
		<span><%=pageTitle%></span>
	</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
<div class="row register-form">
		<div class="col-md-8 offset-md-2">
			<form class="custom-form" method="POST" action="RicercaDisponibilita">
				<h1>Inserire i dati</h1>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer01">Check-in</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="date" class="form-control" id="check-in"
							placeholder="AAAA-MM-GG" Name="check-in" required
							onchange="verify(this.id, this.value)">
						<div class="invalid-feedback">FORMATO DATA AAAA-MM-GG</div>
					</div>
				</div>
			<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer01">Check-out</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="date" class="form-control" id="check-out"
							placeholder="AAAA-MM-GG" Name="check-out" required
							onchange="verify(this.id, this.value)">
						<div class="invalid-feedback">FORMATO DATA AAAA-MM-GG</div>
					</div>
				</div>
				
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer03">Numero di ospiti</label>
					</div>
					<div class="col-sm-6 input-column">
						<fieldset>
						<select name="numOspiti" >
						<option value="1" selected="selected">1 </option>
						<option value="2">2 </option>
						<option value="3">3 </option>
						<option value="4">4 </option>
						</select>
						</fieldset>
					</div>
					
					</div>
				<button class="btn btn-secondary" id="submit" Name="submit"
					type="submit">Submit</button>
			</form>
			</div>
			</div>	
	</div>
				
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />