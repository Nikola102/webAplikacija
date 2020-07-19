$(document).ready(function(){    
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/korisnik/lista",                
        dataType: "json",                                         
        success: function (data) {
            console.log("SUCCESS : ", data);                       
            for (i = 0; i < data.length; i++) {                    
                var row = "<tr>";                                                
                row += "<td>" + data[i]['id'] + "</td>";
                row += "<td>" + data[i]['name'] + "</td>";
                row += "<td>" + data[i]['surname'] + "</td>";
                row += "<td>" + data[i]['role'] + "</td>";
                row += "</tr>";
                $('#korisnici').append(row); 
            }
        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});