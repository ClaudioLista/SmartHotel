<%
	String pageTitle = "Home";
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
	<div id="container-centrale-back">
		<div id="calendar-background">
			<header>
				<div> 
				Benvenuti a Smart Hotel!
				</div>
			</header>
		</div>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />