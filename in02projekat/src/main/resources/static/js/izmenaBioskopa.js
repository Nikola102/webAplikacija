$(document).ready(function(){    
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/bioskop/lista",                
        dataType: "json",                                         
        success: function (data) {
            console.log("SUCCESS : ", data); 
                for (i = 0; i < data.length; i++) {                    
                var row = "<tr>";                                                
                row += "<td>" + data[i]['naziv'] + "</td>";
                row += "<td>" + data[i]['adresa'] + "</td>";
                row += "<td>" + data[i]['brojtelefona'] + "</td>";
                row += "<td>" + data[i]['email'] + "</td>";
                row += "</tr>";
                $('#bioskopi').append(row);

                var opcija = "<option value = "+ data[i]['id'] + ">" + data[i]['naziv'] + "</option>";
                $('#selekcijaBioskopa').append(opcija);

            }
        },
        error: function (data) {
            alert("Dogodila se greska, pogleaj konzolu");
            console.log("ERROR : ", data);
        }
    });

    $("#addBioskopForm").submit(function(event) {           // kada je submitovana forma za kreiranje novog zaposlenog
  
        event.preventDefault();
        var name = $("#name").val();
        var adress = $("#adress").val();
        var telefon = $("#telefon").val();
        var email = $("#email").val();                                                                                      
        var idBioskopa = $("#selekcijaBioskopa").val();
        //obratiti paznju na nazive
        var obj = JSON.stringify({
        "id" : idBioskopa,
        "naziv" : name,
        "adresa" : adress,
        "brojtelefona" : telefon,
        "email" : email
        });

   $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/bioskop/izmeni",                             
        dataType: "json",                                     
        contentType: "application/json",   
        data: obj,                         
        success: function (data) {
            console.log("SUCCESS : ", data);
            alert("Izmena uspesna");
            window.location.href = "index.html";
            },
        error: function (data) {
            alert("Greška!");
            }
        });
    });

    
});