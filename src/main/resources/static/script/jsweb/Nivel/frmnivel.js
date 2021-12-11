
function validar_registro_piso() {
	
	var numpiso = document.getElementById('numpiso').value;
	var capacidad = document.getElementById('capacidad').value;
	var estado = document.getElementById('estado').value;
	
	
	
	
	if (numpiso === "" ||  capacidad === "0" || capacidad === "" || estado === ""  ){
		
		if (numpiso === "") {

			$("#errornumpiso").text("El campo Piso es requerido");
		}
		else{
			$("#errornumpiso").text("");
		}

		if (capacidad === "0" || capacidad === "") {

			$("#errorcapacidad").text("El campo no puede ser cero ni estar vacio");
		}
		else{
			$("#errorcapacidad").text("");
		}
	
		

		if (estado === "" ) {

			$("#errorestado").text("Debe seleccionar una de las dos opciones");
		}
		else{
			$("#errorestado").text("");
		}

		
		
		
		return false;
	}
	
	
	
}


function actualizar_nivel() {
	
	var numpiso = document.getElementById('numpiso').value;
	var capacidad = document.getElementById('capacidad').value;
	var estado = document.getElementById('estado').value;
	
	
	
	
	if (numpiso === "" ||  capacidad === "0" || capacidad === "" || estado === ""  ){
		
		if (numpiso === "") {

			$("#errornumpiso").text("El campo Piso es requerido");
		}
		else{
			$("#errornumpiso").text("");
		}

		if (capacidad === "0" || capacidad === "") {

			$("#errorcapacidad").text("El campo no puede ser cero ni estar vacio");
		}
		else{
			$("#errorcapacidad").text("");
		}
	
		

		if (estado === "" ) {

			$("#errorestado").text("Debe seleccionar una de las dos opciones");
		}
		else{
			$("#errorestado").text("");
		}

		
		
		
		return false;
	}
	
	
}




function mostrar_habilitados(){
	
	document.getElementById('div_d').style.display = 'none';
	
	
	
	
	
	document.getElementById('div_h').style.display = 'block';
	
}


function mostrar_deshabilitados(){
	
	document.getElementById('div_h').style.display = 'none';
	
	
	
	
	document.getElementById('div_d').style.display = 'block';
	
}



window.onload = function() {



var cancelado = document.getElementsByClassName("habili").length;

if(cancelado == 0){
	document.getElementById("habilitado_h1").innerHTML = "No Hay Datos";
}



var confi = document.getElementsByClassName("desbili").length;

if(confi == 0){
	document.getElementById("deshabilitado_h1").innerHTML = "No Hay Datos";
}



};



