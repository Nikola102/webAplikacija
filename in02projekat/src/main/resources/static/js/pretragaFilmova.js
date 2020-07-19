$(document).ready(function(){
    if(localStorage.getItem('Role') != "Gledaoc")
        $("#zaGledaoce").css('display', 'none');
    else
        $("#zaGledaoce").css('display', 'block');

    $("#traziProjekciju").submit(function(event) {           // kada je submitovana forma za kreiranje novog zaposlenog
  
        event.preventDefault();
        var naziv = $("#naziv").val();
        var zanr = $("#zanr").val();                                                                                      
        var cena = $("#cena").val();
        var tipSortiranja = $("#sortiranje").val();
        var datum = $("#datum").val();
        //obratiti paznju na nazive
        var obj = JSON.stringify({
        "naziv" : naziv,
        "zanr" : zanr,
        "cena" : cena,
        "tipSortiranja" : tipSortiranja,
        "datum" : datum
        });

        $.ajax({
            type: "POST",                                               
            url: "http://localhost:8080/api/terminkaListaProjekcija/pretraga",                             
            dataType: "json",                                     
            contentType: "application/json",   
            data: obj,                                         
            success: function (data) {
                console.log("SUCCESS : ", data); 
                    for (i = 0; i < data.length; i++) {
                    var row = "<tr>";
                    row += "<td>" + data[i]['naziv'] + "</td>";
                    row += "<td>" + (data[i]['vreme'].split("T"))[0] + "</td>";
                    row += "<td>" + data[i]['cena'] + "</td>";
                    row += "<td>" + data[i]['srednjaOcena'] + "</td>";
                    row += "<td>" + data[i]['zanr'] + "</td>";
                    row += "<td>" + data[i]['trajanje'] + "</td>";
                    row += "<td>" + data[i]['bioskopNaziv']; + "</td>";
                    row += "<td>" + data[i]['salaOznaka']; + "</td>";
                    row += "</tr>";


                    $('#projekcije').append(row);

                    var opcija = "<option  value = " + data[i]['idtlp'] + ">";
                    opcija += data[i]['naziv'] + " - "; 
                    opcija += (data[i]['vreme'].split("T"))[0] + " - ";
                    opcija += data[i]['bioskopNaziv'] + " - ";
                    opcija += data[i]['salaOznaka'] + " - ";
                    opcija += data[i]['cena'];
                    opcija += "</option>";
                    $('#selekcijaProjekcije').append(opcija);
                }
            },
            error: function (data) {
                alert("Dogodila se greska, pogledaj konzolu");
                console.log("ERROR : ", data);
            }
        });
    });


    $("#rezervisiProjekciju").submit(function(event) {           // kada je submitovana forma za kreiranje novog zaposlenog
        event.preventDefault();                                                                                      
        var number = $("#selekcijaProjekcije").val();
        var username = localStorage.getItem('Username');

        var obj = JSON.stringify({
        "string" : username,
        "number" : number
        });

   $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/terminkaListaProjekcija/rezervacija",                             
        dataType: "json",                                     
        contentType: "application/json",   
        data: obj,                         
        success: function (data) {
            console.log("SUCCESS : ", data);
            alert("rezervisano");
            //window.location.href = "index.html";
            },
        error: function (data) {
            console.log("ERROR : ", data);
            alert("Greška?");
            }
        });
    
    });





});

  