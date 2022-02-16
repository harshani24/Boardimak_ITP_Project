function validateAddUser() {
	var firstName, lastName, email, mobileNo;

	firstName = document.getElementById('creFirstName');
    lastName = document.getElementById('creLastName');
    email = document.getElementById('creEmail');  
    
    if ( firstName.value === '' && lastName.value === '' && email.value === '' ) {
        changeInputColor(firstName);
        changeInputColor(lastName);
        changeInputColor(email);
        return false;
    } else if ( firstName.value != '' && lastName.value === '' && email.value === '' ) {
    	changeInputColor(lastName);
        changeInputColor(email);
        return false;
    } else if ( firstName.value === '' && lastName.value === '' && email.value != '' ) {
    	changeInputColor(firstName);
        changeInputColor(lastName);
        return false;
    } else {
    	return true;
    }
}

function validateEditUser() {
	var firstName, lastName, accountType, email, mobileNo;

	firstName = document.getElementById('editFirstName');
    lastName = document.getElementById('editLastName');
    email = document.getElementById('editEmail');
    accountType = document.getElementById('editAccountType');
    mobileNo = document.getElementById('editMobileNo');
    
    if ( firstName.value === '' && lastName.value === '' && accountType.value == 'null' && email.value === '' && mobileNo.value === '' ) {
        changeInputColor(firstName);
        changeInputColor(lastName);
        changeInputColor(email);
        changeInputColor(accountType);
        changeInputColor(mobileNo);
        return false;
    } else if ( firstName.value === '' || lastName.value === '' || accountType.value == 'null' || email.value === '' || mobileNo.value === '' ) {
        changeInputColor(firstName);
        changeInputColor(lastName);
        changeInputColor(email);
        changeInputColor(accountType);
        changeInputColor(mobileNo);
        return false; 
    } else if ( firstName.value != '' && lastName.value === '' && accountType.value != 'null' && email.value === '' && mobileNo.value === '' ) {
    	changeInputColor(lastName);
        changeInputColor(email);
        changeInputColor(accountType);
        changeInputColor(mobileNo);
        return false;
    } else if ( firstName.value === '' && lastName.value != '' && accountType.value != 'null' && email.value === '' && mobileNo.value === '' ) {
    	changeInputColor(firstName);
        changeInputColor(email);
        changeInputColor(accountType);
        changeInputColor(mobileNo);
        return false;
    } else if ( firstName.value === '' && lastName.value === '' && accountType.value != 'null' && email.value === '' && mobileNo.value === '' ) {
        changeInputColor(firstName);
        changeInputColor(lastName);
        changeInputColor(email);
        changeInputColor(mobileNo);
        return false;
    } else if ( firstName.value === '' && lastName.value === '' && accountType.value != 'null' && email.value != '' && mobileNo.value === '' ) {
        changeInputColor(firstName);
        changeInputColor(lastName);
        changeInputColor(accountType);
        changeInputColor(mobileNo);
        return false; 
    } else if ( firstName.value === '' && lastName.value === '' && accountType.value == 'null' && email.value === '' && mobileNo.value != '' ) {
        changeInputColor(firstName);
        changeInputColor(lastName);
        changeInputColor(email);
        changeInputColor(accountType);
        return false;
    } else {
    	return true;
    }
}

function changeInputColor(inputField) {
    inputField.style.borderColor = "#ff7272";
    inputField.style.backgroundColor = "#ffe0e070";
}