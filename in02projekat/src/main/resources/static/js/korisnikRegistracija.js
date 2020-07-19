$(document).ready(function(){

  	//alert("Radi skripna na neki nacin");
	$("#addKorisnikForm").submit(function(event) {           // kada je submitovana forma za kreiranje novog zaposlenog
	
	    event.preventDefault();
	    var firstName = $("#firstName").val();
	    var lastName = $("#lastName").val();
	    var telefon = $("#telefon").val();
	    var userName = $("#userName").val();
	    var password = $("#password").val();
	    var email = $("#email").val();
    	var birthday = $("#birthday").val();
        var role = $("input:radio[name='radioUloga']:checked").val()
        //obratiti paznju na nazive
		var obj = JSON.stringify({
        "username" : userName,
        "password" : password,
        "name" : firstName,
        "surname" : lastName,
        "phonenumber" : telefon,
        "mail" : email,
        "birthday" : birthday,
        "role" : role
    	});

// alert(newKorisnik);
     $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/korisnik",                 	
        dataType: "json",                                                   
        contentType: "application/json",                            
        data: obj,                             		         																																				
        success: function () {
            alert(obj);
            window.location.href = "index.html";
        	},
        error: function (data) {
            alert("Da li se poruka prenela?");
            alert(data);
            alert("Izgleda da jeste");
        	}
    	});


	});
});

    