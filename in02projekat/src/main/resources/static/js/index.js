$(document).ready(function(){   
    //$("#placeHolderUsername").text("REEEE");
    if(localStorage.getItem('Username') === null || localStorage.getItem('Username') == 'none'){
        $("#gledaociFunkcije").css('display', 'none');
        $("#menadzeriFunkcije").css('display', 'none');
        $("#adminFunkcije").css('display', 'none');

    }else if(localStorage.getItem('Role') == 'Gledaoc') {
        $("#gledaociFunkcije").css('display', 'block');
        $("#menadzeriFunkcije").css('display', 'none');
        $("#adminFunkcije").css('display', 'none');
    }else if(localStorage.getItem('Role') == 'Menadzer'){
        $("#gledaociFunkcije").css('display', 'none');
        $("#menadzeriFunkcije").css('display', 'block');
        $("#adminFunkcije").css('display', 'none');
    }else{
        $("#gledaociFunkcije").css('display', 'none');
        $("#menadzeriFunkcije").css('display', 'none');
        $("#adminFunkcije").css('display', 'block');
    }

});