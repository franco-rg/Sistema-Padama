window.onload = function() {
var divs = document.getElementsByClassName("noconfirmado").length;
if(divs == 0){
	document.getElementById("no_se_confirma_datos").innerHTML = "No Hay Datos";
}

var con = document.getElementsByClassName("confirmado").length;
if(con == 0){
	document.getElementById("confirma_datos").innerHTML = "No Hay Datos";
}

var can = document.getElementsByClassName("cancelado").length;

if(can == 0){
	document.getElementById("cancelado_dato").innerHTML = "No Hay Datos";
}

var cance = document.getElementsByClassName("cancelada").length;
if(cance == 0){
	document.getElementById("cancelada_dato").innerHTML = "No Hay Datos";
}

var fina = document.getElementsByClassName("finalizado").length;
if(fina == 0){
	document.getElementById("finalizado_dato").innerHTML = "No Hay Datos";
}


};


function mostrar_no_confirmados(){
	
			document.getElementById('div_no_confirmado').style.display = 'block';	
			document.getElementById('div_canceladas').style.display = 'none';
			document.getElementById('div_confirmado').style.display = 'none';
			document.getElementById('div_cancelado').style.display = 'none';
			document.getElementById('div_finalizado').style.display = 'none';

};

function mostrar_reserva_cancelada(){
	
			document.getElementById('div_no_confirmado').style.display = 'none';	
			document.getElementById('div_canceladas').style.display = 'block';
			document.getElementById('div_confirmado').style.display = 'none';
			document.getElementById('div_cancelado').style.display = 'none';
			document.getElementById('div_finalizado').style.display = 'none';

};

function mostrar_confirmada(){
	
			document.getElementById('div_no_confirmado').style.display = 'none';	
			document.getElementById('div_canceladas').style.display = 'none';
			document.getElementById('div_confirmado').style.display = 'block';
			document.getElementById('div_cancelado').style.display = 'none';
			document.getElementById('div_finalizado').style.display = 'none';

};

function mostrar_hospedaje_cancelado(){
	
			document.getElementById('div_no_confirmado').style.display = 'none';	
			document.getElementById('div_canceladas').style.display = 'none';
			document.getElementById('div_confirmado').style.display = 'none';
			document.getElementById('div_cancelado').style.display = 'block';
			document.getElementById('div_finalizado').style.display = 'none';

};

function mostrar_finalizado(){
	
			document.getElementById('div_no_confirmado').style.display = 'none';	
			document.getElementById('div_canceladas').style.display = 'none';
			document.getElementById('div_confirmado').style.display = 'none';
			document.getElementById('div_cancelado').style.display = 'none';
			document.getElementById('div_finalizado').style.display = 'block';

};

