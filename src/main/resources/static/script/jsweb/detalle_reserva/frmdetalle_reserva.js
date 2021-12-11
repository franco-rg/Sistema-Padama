
function validar_confirmar_reserva() {
	
	 
	 
	
	
	var fecha_inicio = document.getElementById('fechainicio').value;
	
	var now = new Date();

    var day = ("0" + now.getDate()).slice(-2);
    var month = ("0" + (now.getMonth() + 1)).slice(-2);

    var today = now.getFullYear()+"-"+(month)+"-"+(day) ;
	

	
	if (fecha_inicio !== today){
		
		if (fecha_inicio !== today) {

			$("#errorconfirmar").text("La fecha de inicio no coincidio con la fecha actual");
		}
		
		return false;
	}
	
	
	
	
	
	
}

function validar_finalizar_reserva() {
	
	
	
	var fecha_salida = document.getElementById('fechasalida').value;
	
	var now = new Date();

    var day = ("0" + now.getDate()).slice(-2);
    var month = ("0" + (now.getMonth() + 1)).slice(-2);

    var today = now.getFullYear()+"-"+(month)+"-"+(day) ;
	
	
	
	if (fecha_salida !== today){
		
		if (fecha_salida !== today) {

			$("#errorconfirmar").text("La fecha de salida no coincidio con la fecha actual");
		}
		
		return false;
	}
	
	
	
	
	
	
}



function mostrar_informacioncliente(){
	document.getElementById('informacion_cliente').style.display = 'block';
}

function ocultar_informacioncliente(){
	document.getElementById('informacion_cliente').style.display = 'none';
}






function mostrar_informacion_reserva(){
	document.getElementById('informacion_reserva').style.display = 'block';
}

function ocultar_informacion_reserva(){
	document.getElementById('informacion_reserva').style.display = 'none';
}





function mostrar_informacion_habitacion(){
	document.getElementById('informacion_habitacion').style.display = 'block';
}

function ocultar_informacion_habitacion(){
	document.getElementById('informacion_habitacion').style.display = 'none';
}




function mostrar_informacion_servicios(){
	document.getElementById('informacion_servicios').style.display = 'block';
}

function ocultar_informacion_servicios(){
	document.getElementById('informacion_servicios').style.display = 'none';
}





function mostrar_informacion_pago(){
	document.getElementById('informacion_pago').style.display = 'block';
}
function ocultar_informacion_pago(){
	document.getElementById('informacion_pago').style.display = 'none';
}




function mostrar_cancelado(){
	
	document.getElementById('tabla_no_confirmado').style.display = 'none';
	document.getElementById('tabla_finalizado').style.display = 'none';
	
	
	
	
	document.getElementById('tabla_cancelado').style.display = 'block';
	
}


function mostrar_cancelados(){
	
	document.getElementById('tabla_no_confirmado').style.display = 'none';
	
	
	
	
	document.getElementById('tabla_cancelado').style.display = 'block';
	
}


function mostrar_no_confirmados(){
	
	document.getElementById('tabla_cancelado').style.display = 'none';
	
	
	
	
	
	document.getElementById('tabla_no_confirmado').style.display = 'block';
	
}


function mostrar_no_confirmado(){
	
	document.getElementById('tabla_cancelado').style.display = 'none';
	document.getElementById('tabla_finalizado').style.display = 'none';
	
	
	
	document.getElementById('tabla_no_confirmado').style.display = 'block';
	
}

function mostrar_finalizado(){

	document.getElementById('tabla_cancelado').style.display = 'none';
	document.getElementById('tabla_no_confirmado').style.display = 'none';
	
	
	document.getElementById('tabla_finalizado').style.display = 'block';
	
}



window.onload = function() {
var divs = document.getElementsByClassName("noconfirmado").length;


if(divs == 0){
	document.getElementById("no_se_confirma_datos").innerHTML = "No Hay Datos en la Tabla No Confirmado";
}




var cance = document.getElementsByClassName("cancelada").length;

if(cance == 0){
	document.getElementById("cancelada_datos").innerHTML = "No Hay Datos en la Tabla Canceladas";
}









};







