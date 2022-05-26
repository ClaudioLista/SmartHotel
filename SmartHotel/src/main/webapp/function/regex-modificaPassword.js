function submittingP(form){
    password = form.password
    rpassword = form.rpassword
    check = form.check
    button = form.submit
    if (check.checked) {
        if ((password.getAttribute("class") == "form-control is-valid")
            && (rpassword.getAttribute("class") == "form-control is-valid")){
                button.disabled = false
        }
        else {
            button.disabled = true;
            check.checked = false;
        }
    }
}

function verifyP(id, str, oldP) {
    var check = document.getElementById("check");
    if (id == "password") {
        var regex = /^\w+([\.-])?\w+$/;
        input = document.getElementById(id);
        if (regex.test(str) && str == oldP) {
            input.setAttribute("class", "form-control is-valid");
        }
        else {
            input.setAttribute("class", "form-control is-invalid");
            check.checked = false;
        }        
    }

    if (id == "rpassword") {
        var regex = /^\w+([\.-])?\w+$/;
        input = document.getElementById(id);
        pass = document.getElementById("password");
        if (regex.test(str) && input.value != pass.value) {
            input.setAttribute("class", "form-control is-valid");
        }
        else {
            input.setAttribute("class", "form-control is-invalid");
            check.checked = false;
        }
    }
}