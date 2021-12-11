
function validar_registro_servicio() {
	
	
	var nombre = document.getElementById('nombreservicio').value;
	var descripcion = document.getElementById('descripcion').value;
	var preciobase = document.getElementById('precio').value;
	var estado = document.getElementById('estado').value;
	var imagen = document.getElementById('imagen').value;
	
	
	
	if (nombre === "" || descripcion === "" || preciobase === "0.0"||  preciobase === ""  || estado === "" || imagen === "" ){
		
		if (nombre === "") {

			$("#errornombreservicio").text("El campo nombre es requerido");
		}
		else{
			$("#errornombreservicio").text("");
		}

		if (descripcion === "") {

			$("#errordescripcion").text("El campo descripcion es requerido");
		}
		else{
			$("#errordescripcion").text("");
		}
		

		if (preciobase === "0.0"||  preciobase === "" ) {

			$("#errorprecio").text("El valor de campo precio base es requerido y debe ser mayor a 0.0");
		}
		else{
			$("#errorprecio").text("");
		}

		if (estado === "") {

			$("#errorestado").text("Debe seleccionar una de las dos opciones");
		}
		
		else {

			$("#errorestado").text("");
		}
		
		if ( imagen === "") {

			$("#errorimagen").text("El campo imagen es requerido");
		}
		
		else {

			$("#errorimagen").text("");
		}
		
		
		return false;
	}
	
	
	
}


function validar_actualizar_servicio() {
	
	var nombre = document.getElementById('nombreservicio').value;
	var descripcion = document.getElementById('descripcion').value;
	var preciobase = document.getElementById('precio').value;
	var estado = document.getElementById('estado').value;
	var imagen = document.getElementById('imagen').value;
	
	
	
	
	if (nombre === "" || descripcion === "" || preciobase === "0.0" || preciobase === "" || estado === "" ){
		
		if (nombre === "") {

			$("#errornombreservicio").text("El campo nombre es requerido");
		}
		else{
			$("#errornombreservicio").text("");
		}

		if (descripcion === "") {

			$("#errordescripcion").text("El campo descripcion es requerido");
		}
		else{
			$("#errordescripcion").text("");
		}
		

		if (preciobase === "0.0" ) {

			$("#errorprecio").text("El valor de campo precio debe ser mayor a 0.0");
		}
		else{
			$("#errorprecio").text("");
		}

		if (estado === "") {

			$("#errorestado").text("Debe seleccionar una de las dos opciones");
		}
		
		else {

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










