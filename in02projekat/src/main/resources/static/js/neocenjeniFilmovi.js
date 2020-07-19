$(document).ready(function(){    
    var obj = JSON.stringify({
        "username" : localStorage.getItem('Username'),
        "password" : "---"
    });

    $.ajax({
        type: "POST",                                                
        url: "http://localhost:8080/api/film/listapoidbezocene",                
        dataType: "json",
        contentType: "application/json",   
        data: obj,                                         
        success: function (data) {
            console.log("SUCCESS : ", data); 
                for (i = 0; i < data.length; i++) {                    
                var row = "<tr id = red" + data[i]['id'] + ">";                                                
                row += "<td>" + data[i]['naziv'] + "</td>";
                row += "<td>" + data[i]['opis'] + "</td>";
                row += "<td>" + data[i]['zanr'] + "</td>";
                row += "<td>" + data[i]['trajanje'] + "</td>";
                row += "</tr>";
                $('#filmovi').append(row);

                var opcija = "<option " + "id = opcija" + data[i]['id'] + " value = " + data[i]['id'] + ">" + data[i]['naziv'] + "</option>";
                $('#selekcijaFilma').append(opcija);
            }
        },
        error: function (data) {
            alert("Dogodila se greska, pogleaj konzolu");
            console.log("ERROR : ", data);
        }
    });



    $("#oceniFilm").submit(function(event) {           // kada je submitovana forma za kreiranje novog zaposlenog
  
        event.preventDefault();  
        var imeKorisnika = localStorage.getItem('Username');                                                                                    
        var idFilma = $("#selekcijaFilma").val();
        var ocena = $("#selekcijaOcene").val();
        //obratiti paznju na nazive
        var obj = JSON.stringify({
        "ido" : 0,
        "idf" : idFilma,
        "idk" : 0,
        "username" : imeKorisnika,
        "film" : "---",
        "ocena" : ocena
        });

   $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/ocena",                             
        dataType: "json",                                     
        contentType: "application/json",   
        data: obj,                         
        success: function (data) {
            $("#red"+idFilma).remove();
            $("#opcija"+idFilma).remove();
            alert("Ocena dodata");
            console.log("SUCCESS : ", data);           
            },
        error: function (data) {
            console.log("ERROR : ", data);
            alert("Greška?");
            }
        });
    
    });

});
    