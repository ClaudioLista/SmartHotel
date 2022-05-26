function submitting(form){
    nome = form.nome
    cognome = form.cognome
    email = form.email
    password = form.password
    rpassword = form.rpassword
    check = form.check
    button = form.submit
    if (check.checked) {
        if ((nome.getAttribute("class") == "form-control is-valid") && (cognome.getAttribute("class") == "form-control is-valid") 
            && email.getAttribute("class") == "form-control is-valid" && password.getAttribute("class") == "form-control is-valid" 
            && rpassword.getAttribute("class") == "form-control is-valid"){
                button.disabled = false
        }
        else {
            button.disabled = true;
            check.checked = false;
        }
    }
}

function verify(id, str) {
    var check = document.getElementById("check");

    if (id == "nome") {
        var regex = /^[a-zA-Z]+$/;
        input = document.getElementById(id);
        if ((str.length < 2 || str.length > 25) || !regex.test(str)) {
            input.setAttribute("class", "form-control is-invalid");
            check.checked = false;
        }
        else {
            input.setAttribute("class", "form-control is-valid");
        }
    }

    else if (id == "cognome") {
        //var regex = /^[A-Z][a-z]*(\s[A-Z][a-z])+$/;
        var regex = /^[a-zA-Z]+$/;
        input = document.getElementById(id);
        if (str.length < 2 || str.length > 25 || !regex.test(str)) {
            input.setAttribute("class", "form-control is-invalid");
            check.checked = false;
        }
        else {
            input.setAttribute("class", "form-control is-valid")
        }
    }

    else if (id == "email") {
        var regex1 = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        input = document.getElementById(id);
        if (str.length < 0 || str.length > 254 || !(regex1.test(str) || regex2.test(str))) {
            input.setAttribute("class", "form-control is-invalid");
            check.checked = false;
        }
        else {
            input.setAttribute("class", "form-control is-valid")
        }
    }

    else if (id == "password") {
        var regex = /^\w+([\.-])?\w+$/;
        input = document.getElementById(id);
        if (regex.test(str)) {
                input.setAttribute("class", "form-control is-valid");
        }
        else {
            input.setAttribute("class", "form-control is-invalid");
            check.checked = false;
        }
    }

    else if (id == "rpassword") {
        input = document.getElementById(id);
        inp = document.getElementById("password");
        if (str == inp.value) {
            input.setAttribute("class", "form-control is-valid")
        }
        else {
            input.setAttribute("class", "form-control is-invalid")
            check.checked = false;
        }
    }

}