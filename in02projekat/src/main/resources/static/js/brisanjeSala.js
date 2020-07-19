$(document).ready(function(){    
    var obj = JSON.stringify({
    "username" : localStorage.getItem('Username'),
    "password" : "---"
    });
    $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/sala/lista",                             
        dataType: "json",                                     
        contentType: "application/json",   
        data: obj,                                     
        success: function (data) {
            console.log("SUCCESS : ", data); 
                for (i = 0; i < data.length; i++) {                    
                var opcija = "<option value = " + data[i]['id'] + ">" + data[i]['oznaka'] +" - " + data[i]['kapacitet'] + "</option>";
                $("#selekcijaSale").append(opcija);
            }
        },
        error: function (data) {
            alert("Dogodila se greska, pogleaj konzolu");
            console.log("ERROR : ", data);
        }
    });

    

    $("#uklanjanjeSale").submit(function(event) {           // kada je submitovana forma za kreiranje novog zaposlenog
  
        event.preventDefault();                                                                                      
        var idSale = $("#selekcijaSale").val();
        //obratiti paznju na nazive
        var obj = JSON.stringify({
        "id" : idSale
        });

   $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/sala/obrisi",                             
        dataType: "json",                                     
        contentType: "application/json",   
        data: obj,                         
        success: function (data) {
            console.log("SUCCESS : ", data);
            alert("Sala obrisana");
            window.location.href = "index.html";
            },
        error: function (data) {
            console.log("ERROR : ", data);
            alert("Greška?");
            }
        });
    
    });
});