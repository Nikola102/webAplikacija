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
                var opcija = "<option id = opcija"+data[i]['id'] + " value = " + data[i]['id'] + ">" + data[i]['oznaka'] + " - " + data[i]['kapacitet'] + "</option>";
                $('#selekcijaSala').append(opcija);
            }
        },
        error: function (data) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);
        }
    });

    $("#izmeniSalu").submit(function(event) {           // kada je submitovana forma za kreiranje novog zaposlenog
  
        event.preventDefault();
        alert($("#selekcijaSala").val());
        var oznaka = $("#oznaka").val();
        var kapacitet = $("#kapacitet").val();                                                                                      
        var idSale = $("#selekcijaSala").val();
        //obratiti paznju na nazive
        var obj = JSON.stringify({
        "id" : idSale,
        "kapacitet" : kapacitet,
        "oznaka" : oznaka
        });

   $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/sala/izmena",                             
        dataType: "json",                                     
        contentType: "application/json",   
        data: obj,                         
        success: function (data) {
            alert("Sala izmenjena");
            console.log("SUCCESS : ", data);
            $("#opcija" + idSale).text(oznaka + " - " + kapacitet);
            //window.location.href = "index.html";
            },
        error: function (data) {
            alert("Greška!");
            }
        });
    });

    
});