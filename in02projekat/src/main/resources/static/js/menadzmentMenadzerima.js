$(document).ready(function(){    
    var menadzeri = [];
    var bioskopi = [];
    var odnosi = [];
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/korisnik/menadzericeo",                
        dataType: "json",                                         
        success: function (data) {
            console.log("SUCCESS : ", data);

            for(i = 0; i < data.length; i++){
                menadzeri.push(data[i]);
                var row = "<option value = "+ data[i]['id'] + ">" + data[i]['name'] + " " + data[i]['surname'] + "</option>";
                $('#slekcijaMenadzera').append(row);
            }
        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/bioskop/lista",                
        dataType: "json",                                         
        success: function (data) {
            console.log("SUCCESS : ", data);                       
            for(i = 0; i < data.length; i++){
                bioskopi.push(data[i]);
                var row = "<option value = "+ data[i]['id'] + ">" + data[i]['naziv'] + "</option>";
                $('#slekcijaBioskopa').append(row);
            }
        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/bioskop/odnosi",                
        dataType: "json",                                         
        success: function (data) {
            console.log("SUCCESS : ", data);
            for(i = 0; i < data.length; i++)
                odnosi.push(data[i]);

        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
    alert("Regulacija odnosa");
    for(i = 0; i < odnosi.length; i++){
        j = 0;
        while(menadzeri[j]['id'] != odnosi[i]['idm'])
            j++;
        k = 0;
        while(bioskopi[k]['id'] != odnosi[i]['idb'])
            k++;
        var row = "<option value=" + menadzeri[j]['id'] + "/" + bioskopi[k]['id'] + ">" + menadzeri[j]['name'] + " " + menadzeri[j]['surname'] 
        + "<->" + bioskopi[k]['naziv'] + "</option>";
        $('#selekcijaOdnosa').append(row);
    }

    $("#dodajVezu").submit(function(event){
        event.preventDefault();
        var idm = $("#slekcijaMenadzera").val();
        var idb = $("#slekcijaBioskopa").val();
        var obj = JSON.stringify({
            "idm" : idm,
            "idb" : idb
        });
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/bioskop/dodajodnos",                             
            dataType: "json",                                     
            contentType: "application/json",   
            data: obj,
            success: function(data){
                console.log("SUCCESS : ", data);
                alert("Dodat odnos");
                window.location.href = "index.html";
                },
            error: function(data){
                console.log("ERROR : ", data);
                }
        });
    });
    $('#ukloniVezu').submit(function(event) {
        event.preventDefault();
        var res = ($('#selekcijaOdnosa').val()).split("/");
        var obj = JSON.stringify({
            "idm" : res[0],
            "idb" : res[1]
        });
        console.log(obj);
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/bioskop/ukloniodnos",                             
            dataType: "json",                                     
            contentType: "application/json",   
            data: obj,
            success: function(data){
                console.log("SUCCESS : ", data);
                alert("Uklonjen odnos");
                window.location.href = "index.html";
                },
            error: function(data){
                console.log("ERROR : ", data);
                }
        });


    });
});