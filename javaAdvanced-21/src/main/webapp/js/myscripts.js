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






/*function checkEmail(){
	
	let user_e = document.getElementById('email').value;
	
	$.ajax({
		type:"POST",
		url: "/login",
		data: {user_e},
		success : function(user_e){
			console.log("SUCCESS:", user_e);
			display(user_e);
			alert(responce);
		},
		error : function(e) { 
			console.log("ERROR: ", e); 
			display(e); 
			}, 
			done : function(e) { 
				console.log("DONE"); 
				} 
	});
	
}*/

function validateForm(){
	
	let password = document.getElementById('password').value;
	
	let password_c = document.getElementById('password_confirm').value;
	
	let user_f = document.getElementById('first_name').value;
	
	let user_l = document.getElementById('last_name').value;
	
	let user_e = document.getElementById('email').value;

	let nameErr = true;
	
	let lnameErr = true;
	   
	let emailErr = true;
	
	let emailExist = true;
	
	let passErr = true;
	
	let confirmErr = true;
	
	let letters = /^[A-Za-z]+$/;
	
	let mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	
	let passwordformat = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,30}$/;
	
	
	if (letters.test(user_f) === false) {	
		
		nameErr = false;
		document.getElementById('fname_err').innerHTML = 'Please enter valid name, without numbers';
	} 
	
	if(nameErr == true){
		document.getElementById('fname_err').innerHTML = '';
	}
	
	if (letters.test(user_l) === false) {	
		
		lnameErr = false;
		document.getElementById('lname_err').innerHTML = 'Please enter valid last name, without numbers';
	} 
	
	if(lnameErr == true){
		document.getElementById('lname_err').innerHTML = '';
	}
	
	
	
	if(emailExist == false){
		
		document.getElementById('email_ex_err').innerHTML = 'this email is alredy registred';
	}
	
	if (mailformat.test(user_e) === false) {
	
		emailErr =  false;
		document.getElementById('email_err').innerHTML = 'Invalid email address';
	}
	
	if(emailErr == true){
		document.getElementById('email_err').innerHTML = '';
	}
	
	if(passwordformat.test(password) === false){
		
		passErr = false;
		document.getElementById('password_err').innerHTML = 'Password must contain at least one number, one uppercase, and one lowercase letter';
	}
	
	if(passErr == true){
		document.getElementById('password_err').innerHTML = '';
	}
	
	if(password != password_c){
	
		confirmErr = false;
		document.getElementById('password_c_err').innerHTML = "passwords don't match";
	}
	
	if(confirmErr == true){
		document.getElementById('password_c_err').innerHTML = "";
	}
	
	if((nameErr && emailErr && passErr && confirmErr && lnameErr) != true) {
	       return false;
	       }
	
}




