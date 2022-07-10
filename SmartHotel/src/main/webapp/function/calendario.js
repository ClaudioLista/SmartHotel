var date = new Date();
        // Returns the current day of the month
        var day = date.getDate();
        // Returns the month
        var months = new Array();
        months[0] = "Gennaio";
        months[1] = "Febbraio";
        months[2] = "Marzo";
        months[3] = "Aprile";
        months[4] = "Maggio";
        months[5] = "Giugno";
        months[6] = "Luglio";
        months[7] = "Agosto";
        months[8] = "Settembre";
        months[9] = "Ottobre";
        months[10] = "Novembre";
        months[11] = "Dicembre";
        var month = months[date.getMonth()];
        // Returns the year
        var year = date.getFullYear();
        document.getElementById("date").innerHTML = month + " " + year;
        document.getElementById("day").innerHTML = day;


        