$(document).ready(function(){
  var obj = JSON.stringify({
    "username" : localStorage.getItem('Username'),
    "password" : "---"
  });
  $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/bioskop/lista",                
        dataType: "json",                                      
        success: function (data) {
            console.log("SUCCESS : ", data); 
                for (i = 0; i < data.length; i++) {                    
                var opcija = "<option value = " + data[i]['id'] + ">" + data[i]['naziv'] + "</option>";
                $('#selekcijaBioskopa').append(opcija);
            }
        },
        error: function (data) {
            alert("Dogodila se greska, pogleaj konzolu");
            console.log("ERROR : ", data);
        }
    });


  $("#addSalaForm").submit(function(event) {           // kada je submitovana forma za kreiranje novog zaposlenog
  
      event.preventDefault();
      var kapacitet = $("#kapacitet").val();
      var oznaka = $("#oznaka").val();                                                                                    
      var idb = $("#selekcijaBioskopa").val();
      //obratiti paznju na nazive
      var obj = JSON.stringify({
      "kapacitet" : kapacitet,
      "oznaka" : oznaka,
      "idb" : idb
      });

   $.ajax({
      type: "POST",                                               
      url: "http://localhost:8080/api/sala",                 			
      dataType: "json",                                     
      contentType: "application/json",   
      data: obj,                         
      success: function (data) {
        alert("Sala dodata");
        console.log("SUCCESS : ", data);
        window.location.href = "index.html";
        },
      error: function (data) {
        alert("Greška!");
        }
      });


  });
});

  