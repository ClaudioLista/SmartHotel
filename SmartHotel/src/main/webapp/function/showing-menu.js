function getAule(str){
	if (str.length == 0)
		return;
	var building = document.getElementById(str);
	building.innerHTML = '';
	var xhttp = new XMLHttpRequest();
	xhttp.responseType = 'json';
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			for (var i = 0; i < this.response.length; i++) {
				var room = document.createElement('tr');
		        room.setAttribute("id", this.response[i])
		        room.setAttribute("onclick", "sendingTrough('"+room.getAttribute("id")+"','"+str+"')")
		        building.appendChild(room);
		        col1 = document.createElement('th');
		        col2 = document.createElement('td');
		        col3 = document.createElement('td');
		        if (this.response[i] == 'first'){
		        	i+=2;
		        	continue;
		        }
		        col1.innerHTML = "Aula: "+this.response[i];
		        col2.innerHTML = this.response[i+1];
		        col3.innerHTML = "Dipartimento: "+this.response[i+2];
		        room.appendChild(col1);
		        room.appendChild(col2);
		        room.appendChild(col3);
		        i+=2;
			}
		}
	}
    xhttp.open("GET", "AulaGetter?str="+str, true);
    xhttp.send();
}

function sendingTrough(aula, edificio){
	window.location.href = "NavAula?aula="+aula+"&edificio="+edificio
}

function getDipartimenti(str){
	if (str.length == 0)
		return;
	var building = document.getElementById(str);
	building.innerHTML = '';
	var xhttp = new XMLHttpRequest();
	xhttp.responseType = 'json';
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			for (var i = 0; i < this.response.length; i++) {
			    var room = document.createElement('tr');
			    room.setAttribute("id", this.response[i])
		        room.setAttribute("onclick", "sendingTrough('"+room.getAttribute("id")+"','"+this.response[i+2]+"')")
		        building.appendChild(room);
		        col1 = document.createElement('th');
		        col2 = document.createElement('td');
		        col3 = document.createElement('td');
		        if (this.response[i] == 'first'){
		        	i+=2;
		        	continue;
		        }
		        col1.innerHTML = "Aula: "+this.response[i];
		        col2.innerHTML = this.response[i+1];
		        col3.innerHTML = "Edificio: "+this.response[i+2];
		        room.appendChild(col1);
		        room.appendChild(col2);
		        room.appendChild(col3);
		        i+=2;
			}
		}
	}
    xhttp.open("GET", "DipGetter?str="+str, true);
    xhttp.send();
}