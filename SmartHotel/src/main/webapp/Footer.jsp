<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!--INIZIO FOOTER-->
<div class="footer-basic">
	<footer>
		<div class="social">
			<a href="#"> <span class="iconify"
				data-icon="brandico:instagram-filled" data-inline="false"></span>
			</a> <a href="#"> <span class="iconify" data-icon="fa:snapchat"
				data-inline="false"></span>
			</a> <a href="#"> <span class="iconify"
				data-icon="ant-design:twitter-circle-fill" data-inline="false"></span>
			</a> <a href="#"> <span class="iconify"
				data-icon="entypo-social:facebook-with-circle" data-inline="false"></span>
			</a>
		</div>
		<ul class="list-inline">
			<li class="list-inline-item"><a> <i class="material-icons">arrow_upward</i>
			</a></li>
		</ul>
		<p class="copyright">Smart Hotel © 2022</p>
	</footer>
</div>
<%
	if (request.getAttribute("messaggio") != null) {
%>
<div id="snackbar"><%=request.getAttribute("messaggio")%></div>
<%
request.setAttribute("messaggio", "");
}
%>
<!--FINE FOOTER-->
<script>
	$('#datepicker').datepicker({
		uiLibrary : 'bootstrap'
	});
</script>

<script src="function/data-aula.js"></script>
<script src="function/regex-prenotaAula.js"></script>
<script src="function/showing-menu.js"></script>
<script src="function/calendario.js"></script>
<script src="function/banner.js"></script>
<script src="function/regex-login.js"></script>
<script src="function/regex-registrazione.js"></script>
<script src="function/regex-modificaPassword.js"></script>
<script src="function/rimozione.js"></script>
</body>

</html>
