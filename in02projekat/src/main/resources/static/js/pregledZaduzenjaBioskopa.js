$(document).ready(function(){    
    var obj = JSON.stringify({
        "username" : localStorage.getItem('Username'),
        "password" : "---"
    });

    $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/korisnik/bioskopzaduzenja",                             
        dataType: "json",                                     
        contentType: "application/json",   
        data: obj,                         
        success: function (data) {
            console.log("SUCCESS : ", data); 
            for (i = 0; i < data.length; i++) {                    
                var row = "<tr>";                                                
                row += "<td>" + data[i]['naziv'] + "</td>";
                row += "<td>" + data[i]['adresa'] + "</td>";
                row += "<td>" + data[i]['brojtelefona'] + "</td>";
                row += "<td>" + data[i]['email'] + "</td>";
                row += "</tr>";
                $('#listaBioskopa').append(row);
            }
        },            
        error: function (data) {
            alert("Greška!");
            }
        });
});
