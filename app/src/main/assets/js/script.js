 $( document ).ready(function() {
        $('#genero').append(window.android.getGenero());
        $('#complexion').append(window.android.getComplexion());
        $('#selectAltura').append(window.android.getAltura());
    });
    $(".btnIMC").click(function(){
        if(validar()){
                genero = $('input:radio[name=genero]:checked').val();
                complexion = $('input:radio[name=complexion]:checked').val();
                altura = parseFloat($('#selectAltura option:selected').val());
                peso = parseFloat($('#Peso').val());
                min = parseFloat(myJson['datos'][genero][0][complexion][altura][0]['peso']);
                max = parseFloat(myJson['datos'][genero][0][complexion][altura][1]['peso']);
                $('.contenidoIMC').empty();
                $('.contenidoIMC').append("<p style='color:#4CAF50;'>" + "Peso ideal segun tu complexion " + min + " - " + max + " kg</p>");
                $('.contenidoIMC').append('<br>');
                $('.contenidoIMC').append(window.android.CalcularIMC(peso,altura));
                $('.panel').fadeOut();
                setTimeout(function(){ $('.panel').fadeIn(); }, 6000);
        }
    });

    function validar(){
        altura = $('#selectAltura option:selected').val();
        peso =  $('#Peso').val();
        if(!$('input:radio[name=genero]:checked').is(':checked')){
            window.android.getAlerta("Genero");
            return false;
        }
        if(!$('input:radio[name=complexion]:checked').is(':checked')){
            window.android.getAlerta("Complexion");
            return false;
        }
        if(altura == '0'){
            window.android.getAlerta("Altura");
            return false;
        }
        
        if(peso.length == 0){
            window.android.getAlerta("Peso");
            return false;
        }
        
        return true;
        
    }
