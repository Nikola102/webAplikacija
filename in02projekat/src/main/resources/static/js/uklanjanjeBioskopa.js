$(document).ready(function(){    
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/bioskop/lista",                
        dataType: "json",                                         
        success: function (data) {
            console.log("SUCCESS : ", data); 
                for (i = 0; i < data.length; i++) {                    
                var opcija = "<option value = "+ data[i]['id'] + ">" + data[i]['naziv'] + "</option>";
                $('#selekcijaBioskopa').append(opcija);
            }
        },
        error: function (data) {
            alert("Dogodila se greska, pogleaj konzolu");
            console.log("ERROR : ", data);
        }
    });

    

    $("#ukloniBioskop").submit(function(event) {           // kada je submitovana forma za kreiranje novog zaposlenog
  
        event.preventDefault();                                                                                      
        var idBioskopa = $("#selekcijaBioskopa").val();
        //obratiti paznju na nazive
        alert(idBioskopa);
        var obj = JSON.stringify({
        "id" : idBioskopa
        });

   $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/bioskop/ukloni",                             
        dataType: "json",                                     
        contentType: "application/json",   
        data: obj,                         
        success: function (data) {
            console.log("SUCCESS : ", data);
            alert("Obrisan bioskop");
            window.location.href = "index.html";
            },
        error: function (data) {
            console.log("ERROR : ", data);
            alert("Greška?");
            }
        });
    
    });
});