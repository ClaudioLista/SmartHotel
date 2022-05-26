var date = new Date();
        // Returns the current day of the month
        var day = date.getDate();
        // Returns the month
        var months = new Array();
        months[0] = "January";
        months[1] = "February";
        months[2] = "March";
        months[3] = "April";
        months[4] = "May";
        months[5] = "June";
        months[6] = "July";
        months[7] = "August";
        months[8] = "September";
        months[9] = "October";
        months[10] = "November";
        months[11] = "December";
        var month = months[date.getMonth()];
        // Returns the year
        var year = date.getFullYear();
        document.getElementById("date").innerHTML = month + " " + year;
        document.getElementById("day").innerHTML = day;


        