$(document).ready(function(){
  //pokupiti iz baze sve AKTIVNE menadzere
  $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/korisnik/menadzeri",                
        dataType: "json",                                         
        success: function (data) {
            console.log("SUCCESS : ", data);
            for (i = 0; i < data.length; i++){
              var row = "<option value = "+ data[i]['username'] + ">" + data[i]['name'] + "</option>";
              $('#slekcijaMenadzera').append(row);
            }
        },
        error: function (data) {
            alert("Dogodila se greska, pogleaj konzolu");
            console.log("ERROR : ", data);
        }
    });
  //iznizati ih i omoguciti chechbox-ovanje
  //slati u ajax postu sve menadzere koje zelimo da budu zaduzeni za bioskop



  $("#addBioskopForm").submit(function(event) {           // kada je submitovana forma za kreiranje novog zaposlenog
  
      event.preventDefault();
      var name = $("#name").val();
      var adress = $("#adress").val();
      var telefon = $("#telefon").val();
      var email = $("#email").val();                                                                                      
      var menadzerusername = $("#slekcijaMenadzera").val();
      //obratiti paznju na nazive
      var obj = JSON.stringify({
      "naziv" : name,
      "adresa" : adress,
      "brojtelefona" : telefon,
      "email" : email,
      "menadzerusername" : menadzerusername
      });

   $.ajax({
      type: "POST",                                               
      url: "http://localhost:8080/api/bioskop",                 			
      dataType: "json",                                     
      contentType: "application/json",   
      data: obj,                         
      success: function (data) {
        console.log("SUCCESS : ", data);
        alert("Uspesno kreiran");
        window.location.href = "index.html";
        },
      error: function (data) {
        alert("Greška!");
        }
      });


  });
});

  