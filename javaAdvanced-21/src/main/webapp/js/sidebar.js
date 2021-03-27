
$(document).ready(function () {
            $("#sidebar").mCustomScrollbar({
                theme: "minimal"
            });

            $('#sidebarCollapse').on('click', function () {
                $('#sidebar, #content').toggleClass('active');
                $('.collapse.in').toggleClass('in');
                $('a[aria-expanded=true]').attr('aria-expanded', 'false');
            });
        });
 
 function myFunction(form, user) {
	 document.getElementById('userId').value = user;
		var x = document.getElementById(form);
		if (x.style.display === 'block') {
			x.style.display = 'none';
		} else {
			x.style.display = 'block';
		}
	};
	

function changeStatus(id, status) {

	let url = "changeStatus";
	let param = "1";
	
	var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    
    xhr.setRequestHeader("Content-type","application/json");
    xhr.send(param);
	
}
	