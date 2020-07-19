$(document).ready(function(){    
    var obj = JSON.stringify({
        "username" : localStorage.getItem('Username'),
        "password" : "---"
    });

    $.ajax({
        type: "POST",                                                
        url: "http://localhost:8080/api/korisnik/karte",                
        dataType: "json",
        contentType: "application/json",   
        data: obj,                                         
        success: function (data) {
            console.log("SUCCESS : ", data); 
                for (i = 0; i < data.length; i++) {                    
                var row = "<tr>";                                                
                row += "<td>" + data[i]['imefilma'] + "</td>";
                row += "<td>" + data[i]['vreme'].split("T")[0] + "</td>";
                row += "<td>" + data[i]['bioskop'] + "</td>";
                row += "<td>" + data[i]['sala'] + "</td>";
                row += "</tr>";
                $('#filmovi').append(row);

                var opcija = "<option value = "+ data[i]['id'] + ">" + data[i]['imefilma'] + "->" + data[i]['bioskop'] + "->" + data[i]['sala'] + "</option>";
                $('#selekcijaKarata').append(opcija);
            }
        },
        error: function (data) {
            alert("Dogodila se greska, pogleaj konzolu");
            console.log("ERROR : ", data);
        }
    });

    $("#uklanjanjeKarata").submit(function(event) {           // kada je submitovana forma za kreiranje novog zaposlenog
  
        event.preventDefault();                                                                                      
        var idRezervacije = $("#selekcijaKarata").val();
        //obratiti paznju na nazive
        var obj = JSON.stringify({
        "string" : localStorage.getItem('Username'),
        "number" : idRezervacije
        });

   $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/korisnik/otkazivanje",                             
        dataType: "json",                                     
        contentType: "application/json",   
        data: obj,                         
        success: function (data) {
            console.log("SUCCESS : ", data);
            window.location.href = "index.html";
            },
        error: function (data) {
            alert("Greška!");
            }
        });
    });
});
    