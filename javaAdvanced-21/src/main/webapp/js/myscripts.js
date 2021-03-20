$(document).ready(function() {
	var selItem = localStorage.getItem("locales");
	$('#locales').val(selItem ? selItem : 'en');
	$("#locales").change(function() {
		var selectedOption = $('#locales').val();
		if (selectedOption) {
			window.location.replace('?lang=' + selectedOption);
			localStorage.setItem("locales", selectedOption);
		}
	});
});

function myFunction(id) {
	var x = document.getElementById(id);
	if (x.style.display === 'block') {
		x.style.display = 'none';
	} else {
		x.style.display = 'block';
	}
};



function validateForm(){
	
	let password = document.getElementById('password').value;
	
	let password_c = document.getElementById('password_confirm').value;
	
	let user_f = document.getElementById('first_name').value;
	
	let user_l = document.getElementById('last_name').value;
	
	let user_e = document.getElementById('email').value;

	let nameErr = true;
	
	let lnameErr = true;
	   
	let emailErr = true;
	
	let passErr = true;
	
	let confirmErr = true;
	
	let letters = /^[A-Za-z]+$/;
	
	let mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	
	let passwordformat = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,30}$/;
	
	
	
	
	
	if (letters.test(user_f) === false) {	
		
		nameErr = false;
		document.getElementById('fname_err').innerHTML = 'Please enter valid name, without numbers';
	} 
	
	if (letters.test(user_l) === false) {	
		
		lnameErr = false;
		document.getElementById('lname_err').innerHTML = 'Please enter valid last name, without numbers';
	} 
	
	
	if (mailformat.test(user_e) === false) {
	
		emailErr =  false;
		document.getElementById('email_err').innerHTML = 'Invalid email address';
	}
	
	
	if(passwordformat.test(password) === false){
		
		passErr = false;
		document.getElementById('password_err').innerHTML = 'Password must contain at least one number, one uppercase, and one lowercase letter';
	}
	
	if(password != password_c){
	
		confirmErr = false;
		document.getElementById('password_c_err').innerHTML = "passwords don't match";
	}
	
	if((nameErr && emailErr && passErr && confirmErr && lnameErr) != true) {
	       return false;
	       }
	
}

