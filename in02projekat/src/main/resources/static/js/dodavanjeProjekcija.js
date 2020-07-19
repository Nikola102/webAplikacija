$(document).ready(function(){
  var obj = JSON.stringify({
    "username" : localStorage.getItem('Username'),
    "password" : "---"
  });
  $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/film/lista",                
        dataType: "json",                                      
        success: function (data) {
            console.log("SUCCESS : ", data); 
                for (i = 0; i < data.length; i++) {                    
                var opcija = "<option value = " + data[i]['id'] + ">" + data[i]['naziv'] + "</option>";
                $('#selekcijaFilma').append(opcija);
            }
        },
        error: function (data) {
            alert("Dogodila se greska, pogleaj konzolu");
            console.log("ERROR : ", data);
        }
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
                var opcija = "<option  value = " + data[i]['id'] + ">" + data[i]['oznaka'] + " - " + data[i]['kapacitet'] + "</option>";
                $('#selekcijaSala').append(opcija);
            }
        },
        error: function (data) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);
        }
    });

    $("#dodajProjekciju").submit(function(event) {           // kada je submitovana forma za kreiranje novog zaposlenog
  
        event.preventDefault();
        var idf = $("#selekcijaFilma").val();
        var ids = $("#selekcijaSala").val();                                                                                      
        var cena = $("#cena").val();
        var datum = $("#datum").val();
        //obratiti paznju na nazive
        var obj = JSON.stringify({
        "idf" : idf,
        "ids" : ids,
        "cena" : cena,
        "datum" : datum
        });

   $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/terminkaListaProjekcija",                             
        dataType: "json",                                     
        contentType: "application/json",   
        data: obj,                         
        success: function (data) {
            alert("Projekcija dodata");
            console.log("SUCCESS : ", data);
            //window.location.href = "index.html";
            },
        error: function (data) {
            alert("Greška!");
            console.log("ERROR : ", data);
            }
        });
    });


 
});

  