function rimAula(edificio) {
	if (edificio.length == 0)
		return;
	var select = document.getElementById("select-aula");
	select.innerHTML = '';
	var xhttp = new XMLHttpRequest();
	xhttp.responseType = 'json';
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			for (var i = 0; i < this.response.length; i++) {
				opt = document.createElement("option")
				opt.value = this.response[i]
				opt.innerHTML = this.response[i]
				select.appendChild(opt)
			}
		}
	}
	xhttp.open("GET", "RimAulaGetter?str=" + edificio, true);
	xhttp.send();
}