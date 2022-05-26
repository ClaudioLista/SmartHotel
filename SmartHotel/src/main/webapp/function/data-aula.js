function getData(data, aula) {
	if (data == null)
		return;
	tabella = document.getElementById("orario");
	tabella.innerHTML = '';
	formatData = data.split("/")
	riga = document.createElement('tr');
	tabella.appendChild(riga);
	for (var k = 8; k < 19; k++) {
		col = document.createElement('td');
		col.setAttribute("id", k);
		riga.appendChild(col);
	}
	var xhttp = new XMLHttpRequest();
	xhttp.responseType = 'json';
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			for (var i = 0; i < this.response.length; i++) {

				materia = this.response[i]
				oraI = this.response[i + 1]
				oraF = this.response[i + 2]
				desc = this.response[i + 3]
				colspan = oraF - oraI;
				
				for (var k = oraI; k < oraF; k++) {
					col = document.getElementById(k)
					if (k != oraI) {
						col.remove()
					}else {
						col.style.background = "#fa6661"
						col.style.textAlign = "center";
						col.setAttribute("colspan", colspan)
						col.innerHTML = materia + "<br><br>" + desc;
					}
				}
				i += 3;
			}
		}
	}
	xhttp.open("GET", "CalGetter?data=" + formatData[2] + "-" + formatData[0]
			+ "-" + formatData[1] + "&aula=" + aula, true);
	xhttp.send();
}