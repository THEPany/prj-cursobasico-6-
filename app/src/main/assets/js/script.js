/* Notas
   Metodos:
       .append : añadir contenido dentro del elemento especificado
       windows.android.NombreDelMetodoEnJava(los metodos deben estar dentro de la clase que se pasa por el interfaceJavascript en java) : usa metodos del java que son pasados a JavaScript
       .val(): optiene el valor del elemento
       .empty(): borra todo el contenido dentro del elemento especificado
*/
/*==================================================
Al iniciar la pagina... se ejecuta  "document.ready"
==================================================*/ 
$(document).ready(function() {
        $('#genero').append(window.android.getGenero());
        $('#complexion').append(window.android.getComplexion());
        $('#selectAltura').append(window.android.getAltura());
});
/*==================================================
Al hacer click en el boton IMC, se hara lo siguiente...
==================================================*/ 
$(".btnIMC").click(function(){
    // Llamar a la funcion validar, para validar los campos del formulario
    if(validar()){
            genero = $('input:radio[name=genero]:checked').val(); //optiene el valor del radio button "genero"
            complexion = $('input:radio[name=complexion]:checked').val(); //optiene el valor del radio button "complexion"
            altura = parseFloat($('#selectAltura option:selected').val()); //optiene el valor del select "altura" y lo convierte a float
            peso = parseFloat($('#Peso').val()); // //optiene el valor del input peso y lo convierte a float
            min = parseFloat(myJson['datos'][genero][0][complexion][altura][0]['peso']); // Buscar el IMC(min) segun el Genero,complexion y altura del json
            max = parseFloat(myJson['datos'][genero][0][complexion][altura][1]['peso']); // Buscar el IMC(max) segun el Genero,complexion y altura del json
            $('.contenidoIMC').empty(); // Borra todo el contenido del div "contenidoIMC" (resultados del calculo del imc)
            $('.contenidoIMC').append("<p style='color:#4CAF50;'>" + "Peso ideal segun tu complexion " + min + " - " + max + " kg</p>"); // Muestra el peso ideal (IMC) "Min-Max" en el HTML, dentro del div "contenidoIMC"
            $('.contenidoIMC').append('<br>'); // Salto de linea en HTMl
            $('.contenidoIMC').append(window.android.CalcularIMC(peso,altura)); // obtienes los resultados segun la formula para calcular el IMC desde JAVA
            $('.panel').fadeOut(); // Oculta el formulario del IMC
            setTimeout(function(){ $('.panel').fadeIn(); }, 6000); // Muestra el formulario luego de pasado 6 sec
    }
});
/*=============================================================================================
Funcion validar, para verificar que todos los campos hayan sidos selecionados o no esten vacio
=============================================================================================*/ 
    function validar(){
        /*
        Cuando entral al if es porque estan vacio o no selecionados y se manda a llamar
        un metodo en JAVA llamado getAlert que muestra un Toast con la informacion del 
        campo que debe llenar...
        retorna True cuando todos los campos del form estan llenos
        */
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

        if(peso.length >= 4){
            window.android.getAlerta("Peso, y este debe ser menos a 999");
            return false;
        }
        
        return true;
        
    }
