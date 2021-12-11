



window.onload = function() {



var cancelado = document.getElementsByClassName("cancelado").length;

if(cancelado == 0){
	document.getElementById("cancelado_fi_datos").innerHTML = "No Hay Datos en la Tabla Cancelados";
}



var confi = document.getElementsByClassName("confirmado").length;

if(confi == 0){
	document.getElementById("confirma_fi_datos").innerHTML = "No Hay Datos en la Tabla Confirmados";
}


var fini = document.getElementsByClassName("finalizado").length;

if(fini == 0){
	document.getElementById("finalizado_datos").innerHTML = "No Hay Datos en la Tabla Finalizado";
}



};







