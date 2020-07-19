$(document).ready(function(){   
    //$("#placeHolderUsername").text("REEEE");
    if(localStorage.getItem('Username') === null || localStorage.getItem('Username') == 'none'){
        $("#dugmeKorisnik").css('display', 'none');
        $("#dugmeLogin").css('display', 'block');
        $("#dugmeRegistracija").css('display', 'block');
        $("#dugmeLogout").css('display', 'none');

    }else{
        $("#dugmeKorisnik").css('display', 'block');
        $("#dugmeLogin").css('display', 'none');
        $("#dugmeRegistracija").css('display', 'none');
        $("#dugmeLogout").css('display', 'block');
        $("#placeHolderUsername").text(localStorage.getItem('Username'));
    }

    if(localStorage.getItem('Username') === null){
        localStorage.setItem('Username', 'none');
        localStorage.setItem('Role', 'none');
    }
   
    //localStorage.setItem('Username', 'nikola');
    $("#dugmeLogout").click(function() {
        localStorage.setItem('Username', 'none');
        localStorage.setItem('Role', 'none');
        window.location.href = "index.html";
    });
});