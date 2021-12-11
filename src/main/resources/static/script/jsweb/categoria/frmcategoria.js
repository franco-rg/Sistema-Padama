
function validar() {
	
	var categoria = document.getElementById('categoria').value;
	var descripcion = document.getElementById('descriph').value;
	var preciobase = document.getElementById('preciobase').value;
	var estado = document.getElementById('estado').value;
	var imagen = document.getElementById('imagen').value;
	
	
	
	if (categoria === "" || descripcion === "" || preciobase === "0.0" || preciobase === ""  || estado === "" || imagen === "" ){
		
		if (categoria === "") {

			$("#errorcategoria").text("El campo nombre es requerido");
		}
		else{
			$("#errorcategoria").text("");
		}

		if (descripcion === "") {

			$("#errordescripcion").text("El campo descripcion es requerido");
		}
		else{
			$("#errordescripcion").text("");
		}
		

		if (preciobase === "0.0" || preciobase === ""   ) {

			$("#errorpreciobase").text("El valor de campo precio es requerido y debe ser mayor a 0.0");
		}
		else{
			$("#errorpreciobase").text("");
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


function validar_actualizacion() {
	
	var categoria = document.getElementById('categoria').value;
	var descripcion = document.getElementById('descriph').value;
	var preciobase = document.getElementById('preciobase').value;
	var estado = document.getElementById('estado').value;
	
	
	
	
	if (categoria === "" || descripcion === "" || preciobase === "0.0" || preciobase === "" || estado === "" ){
		
		if (categoria === "") {

			$("#errorcategoria").text("El campo nombre es requerido");
		}
		else{
			$("#errorcategoria").text("");
		}

		if (descripcion === "") {

			$("#errordescripcion").text("El campo descripcion es requerido");
		}
		else{
			$("#errordescripcion").text("");
		}
		

		if (preciobase === "0.0" || preciobase === "") {

			$("#errorprecio").text("El valor de campo precio es requerido");
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











