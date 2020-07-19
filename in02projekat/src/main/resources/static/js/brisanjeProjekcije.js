$(document).ready(function(){    
    var obj = JSON.stringify({
    "username" : localStorage.getItem('Username'),
    "password" : "---"
  });
    $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/terminkaListaProjekcija/listapomenadzeru",                             
        dataType: "json",                                     
        contentType: "application/json",   
        data: obj,                                      
        success: function (data) {
            console.log("SUCCESS : ", data); 
                for (i = 0; i < data.length; i++) {                    
                var opcija = "<option value = "+ data[i]['id'] + ">" + data[i]['imefilma'] + " -> " + data[i]['sala'] + " -> " + data[i]['bioskop'] + "</option>";
                $('#selekcijaProjekcije').append(opcija);
            }
        },
        error: function (data) {
            alert("Dogodila se greska, pogleaj konzolu");
            console.log("ERROR : ", data);
        }
    });

    

    $("#uklanjanjeProjekcije").submit(function(event) {           // kada je submitovana forma za kreiranje novog zaposlenog
  
        event.preventDefault();                                                                                      
        var idProjekcija = $("#selekcijaProjekcije").val();
        //obratiti paznju na nazive
        var obj = JSON.stringify({
        "id" : idProjekcija
        });

   $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/terminkaListaProjekcija/obrisi",                             
        dataType: "json",                                     
        contentType: "application/json",   
        data: obj,                         
        success: function (data) {
            alert("Projekcija obrisana");
            console.log("SUCCESS : ", data);
            window.location.href = "index.html";
            },
        error: function (data) {
            console.log("ERROR : ", data);
            alert("Greška?");
            }
        });
    
    });
});