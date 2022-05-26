function checkLogin(value, id) {
    var regex1 = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    input = document.getElementById(id);
    button = document.getElementById("submit");
    if (value.length < 0 || value.length > 254 || !regex1.test(value) ) {
        input.setAttribute("class", "form-control is-invalid");
        button.disabled = true;
    }
    else {
        input.setAttribute("class", "form-control is-valid")
        button.disabled = false;
    }

}