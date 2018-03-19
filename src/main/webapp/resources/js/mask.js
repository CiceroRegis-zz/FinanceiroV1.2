jQuery(function($){
$("#data").mask("99/99/9999");
$("#celular").mask("(99)99999-9999");
$("#cfp").mask("999.999.999-99");

});

$(document).ready(function () { 
    var $seuCampoCpf = $("#cpf");
    $seuCampoCpf.mask('000.000.000-00', {reverse: true});
});