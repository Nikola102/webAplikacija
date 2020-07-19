$(document).ready(function(){    
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/korisnik/menadzerisvi",                
        dataType: "json",                                         
        success: function (data) {
            console.log("SUCCESS : ", data); 
                for (i = 0; i < data.length; i++) {                    
                var opcija = "<option value = "+ data[i]['id'] + ">" + data[i]['name'] + "</option>";
                alert(data[i]['id']);
                $('#selekcijaMenadzera').append(opcija);
            }
        },
        error: function (data) {
            alert("Dogodila se greska, pogleaj konzolu");
            console.log("ERROR : ", data);
        }
    });

    

    $("#uklanjanjeMenadzera").submit(function(event) {           // kada je submitovana forma za kreiranje novog zaposlenog
  
        event.preventDefault();                                                                                      
        var idMenadzera = $("#selekcijaMenadzera").val();
        //obratiti paznju na nazive
        alert(idMenadzera);
        var obj = JSON.stringify({
        "id" : idMenadzera
        });

   $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/korisnik/ukloni",                             
        dataType: "json",                                     
        contentType: "application/json",   
        data: obj,                         
        success: function (data) {
            console.log("SUCCESS : ", data);
            alert("Uklonjen");
            window.location.href = "index.html";
            },
        error: function (data) {
            console.log("ERROR : ", data);
            alert("Greška?");
            }
        });
    
    });
});