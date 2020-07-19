$(document).ready(function(){    
	var korisnik = "<tr>";
	korisnik += "<th>" + localStorage.getItem('Name') + "</th>";
	korisnik += "<th>" + localStorage.getItem('Surname') + "</th>";
	korisnik += "<th>" + localStorage.getItem('Role') + "</th>";
	korisnik += "<th>" + localStorage.getItem('Phonenumber') + "</th>";
	korisnik += "<th>" + localStorage.getItem('Mail') + "</th>";
	korisnik += "<th>" + localStorage.getItem('Username') + "</th>";
	korisnik += "</tr>";
	$('#nalog').append(korisnik);
});