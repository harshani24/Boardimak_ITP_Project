document.getElementById("errorReg").style.visibility = "hidden";
document.getElementById("errorReg").style.marginBottom = "0";

document.getElementById("errorLogin").style.visibility = "hidden";
document.getElementById("errorLogin").style.marginBottom = "0";

function validateLogin() {
    var email, password;

    email = document.getElementById('loginEmail');
    password = document.getElementById('loginPassword');
    
    if ( email.value === '' && password.value === '') {
        changeInputColor(email);
        changeInputColor(password);
        document.getElementById("errorLogin").style.visibility = "visible";
		document.getElementById("errorLogin").style.marginBottom = "10px";
		document.getElementById("errorLogin").innerHTML = "Enter email and password";
        return false;
    } else if ( email.value != '' && password.value === '') {
        changeInputColor(password);
        document.getElementById("errorLogin").style.visibility = "visible";
		document.getElementById("errorLogin").style.marginBottom = "10px";
		document.getElementById("errorLogin").innerHTML = "Enter password!";
        return false;
    } else if ( email.value === '' && password.value != '') {
        changeInputColor(email);
        document.getElementById("errorLogin").style.visibility = "visible";
		document.getElementById("errorLogin").style.marginBottom = "10px";
		document.getElementById("errorLogin").innerHTML = "Enter email!";
        return false;
    } else {
    	return true;
    }
}

function validateRegister() {
    var firstName, lastName, accountType, email, regPassword, confirmPassword;

    firstName = document.getElementById('regFirstName');
    lastName = document.getElementById('regLastName');
    accountType = document.getElementById('regAccountType');
    email = document.getElementById('regEmail');
    regPassword = document.getElementById('regPassword');
    confirmPassword = document.getElementById('confirmPassword');    
    
    if ( firstName.value === '' && lastName.value === '' && accountType.value === 'null' && email.value === '' && regPassword.value === '' && confirmPassword.value === '' ) {
    	changeInputColor(firstName);
    	changeInputColor(lastName);
    	changeInputColor(accountType);
    	changeInputColor(email);
    	changeInputColor(regPassword);
    	changeInputColor(confirmPassword);
    	document.getElementById("errorReg").style.visibility = "visible";
    	document.getElementById("errorReg").style.marginBottom = "10px";
    	document.getElementById("errorReg").innerHTML = "Requred fields cannot be empty"
        return false;
    } else if ( firstName.value === '' || lastName.value === '' || accountType.value === 'null' || email.value === '' || regPassword.value === '' || confirmPassword.value === '' ) {
    	changeInputColor(firstName);
    	changeInputColor(lastName);
    	changeInputColor(accountType);
    	changeInputColor(email);
    	changeInputColor(regPassword);
    	changeInputColor(confirmPassword);
    	document.getElementById("errorReg").style.visibility = "visible";
    	document.getElementById("errorReg").style.marginBottom = "10px";
    	document.getElementById("errorReg").innerHTML = "Requred fields cannot be empty"
        return false; 
    } else if ( firstName.value != '' && lastName.value === '' && accountType.value === 'null' && email.value === '' && regPassword.value === '' && confirmPassword.value === '' ) {
    	changeInputColor(lastName);
    	changeInputColor(email);
    	changeInputColor(regPassword);
    	changeInputColor(confirmPassword);
    	document.getElementById("errorReg").style.visibility = "visible";
    	document.getElementById("errorReg").style.marginBottom = "10px";
    	document.getElementById("errorReg").innerHTML = "Requred fields cannot be empty"
        return false;
    } else if ( firstName.value === '' && lastName.value === '' && accountType.value === 'null' && email.value != '' && regPassword.value === '' && confirmPassword.value === '' ) {
    	changeInputColor(firstName);
    	changeInputColor(lastName);
    	changeInputColor(regPassword);
    	changeInputColor(confirmPassword);
    	document.getElementById("errorReg").style.visibility = "visible";
    	document.getElementById("errorReg").style.marginBottom = "10px";
    	document.getElementById("errorReg").innerHTML = "Requred fields cannot be empty"
        return false;
    } else if ( firstName.value === '' && lastName.value === '' && accountType.value === 'null' && email.value === '' && regPassword.value != '' && confirmPassword.value === '' ) {
    	changeInputColor(firstName);
    	changeInputColor(lastName);
    	changeInputColor(email);
    	changeInputColor(confirmPassword);
    	document.getElementById("errorReg").style.visibility = "visible";
    	document.getElementById("errorReg").style.marginBottom = "10px";
    	document.getElementById("errorReg").innerHTML = "Requred fields cannot be empty"
    	return false;
    } else if ( firstName.value === '' && lastName.value === '' && accountType.value === 'null' && email.value === '' && regPassword.value === '' && confirmPassword.value != '' ) {
    	changeInputColor(firstName);
    	changeInputColor(lastName);
    	changeInputColor(email);
    	document.getElementById("errorReg").style.visibility = "visible";
    	document.getElementById("errorReg").style.marginBottom = "10px";
    	document.getElementById("errorReg").innerHTML = "Requred fields cannot be empty"
    	return false;
    } else {
    	if ( regPassword.value.length < 4 && regPassword.value.length > 0 ) {
    		document.getElementById("errorReg").style.visibility = "visible";
    		document.getElementById("errorReg").style.marginBottom = "10px";
    		document.getElementById("errorReg").innerHTML = "Password is too short!";
    		changeInputColor(regPassword);
        	changeInputColor(confirmPassword);
    		return false;
    	} else if ( regPassword.value != confirmPassword.value ) {
    		document.getElementById("errorReg").style.visibility = "visible";
    		document.getElementById("errorReg").innerHTML = "Passwords do not match!";
    		document.getElementById("errorReg").style.marginBottom = "10px";
    		changeInputColor(regPassword);
        	changeInputColor(confirmPassword);
    		return false;
    	}
    }
}

function changeInputColor(inputField) {
    inputField.style.borderColor = "#ff7272";
    inputField.style.backgroundColor = "#ffe0e070";
}
