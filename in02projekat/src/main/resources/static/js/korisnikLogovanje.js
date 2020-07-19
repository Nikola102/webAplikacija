$(document).ready(function(){

  $("#loginKorisnikForm").submit(function(event) {           
  
      event.preventDefault();
      var userName = $("#userName").val();
      var password = $("#password").val();

      var obj = JSON.stringify({
      "username" : userName,
      "password" : password
      });
  
   $.ajax({
      type: "POST",                                               
      url: "http://localhost:8080/api/korisnik/login",
      dataType: "json",                                           
      contentType: "application/json",                            
      data: obj,                             		         
      success: function (data) {

          console.log("SUCCESS : ", data);

          localStorage.setItem('Id', data.id);
          localStorage.setItem('Name', data.name);
          localStorage.setItem('Surname', data.surname);
          localStorage.setItem('Username', data.username);
          localStorage.setItem('Phonenumber', data.phonenumber);
          localStorage.setItem('Role', data.role);
          localStorage.setItem('Mail', data.mail);
          localStorage.setItem('Birthday', data.birthday);
          localStorage.setItem('Username', data.username);

          window.location.href = "index.html";
          },
      error: function (data) {
          console.log("ERROR " + JSON.stringify(data));
          alert("Nalog nije aktivan, proverite unos ili se obratite adminu");
          }
      });
  });
});

  