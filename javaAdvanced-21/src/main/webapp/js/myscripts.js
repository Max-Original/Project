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

$(function() {
	var $select = $('.select2');

	$select.select2({
		theme : 'paper'
	});
});