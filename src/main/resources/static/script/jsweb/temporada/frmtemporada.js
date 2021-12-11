
function validar_registrotemporada() {

	var temporada = document.getElementById('temporada').value;
	var descripcion = document.getElementById('descripcion').value;
	var fechaini = document.getElementById('fechaini').value;
	var fechafi = document.getElementById('fechafi').value;
	var estado = document.getElementById('estado').value;
	var imagen = document.getElementById('imagen').value;

	

	if (temporada === "" || descripcion === "" || fechaini === "" || fechafi === "" || estado === "" || imagen === "") {

		if (temporada === "") {

			$("#errortemporada").text("El campo nombre es requerido");
		}
		else {
			$("#errortemporada").text("");
		}

		if (descripcion === "") {

			$("#errordescripcion").text("El campo descripcion es requerido");
		}
		else {
			$("#errordescripcion").text("");
		}









		if (fechaini === "") {

			$("#errorfechaini").text("El valor de campo fecha de inicio es requerido");
		}

	
		else{

		
			$("#errorfechaini").text("");
		}
		
		

		if (fechafi === "") {

			$("#errorfechafi").text("El campo fecha final es requerido");
		}

		
		else{

			$("#errorfechafi").text("");
			
		}










		if (estado === "") {

			$("#errorestado").text("El campo fecha final es requerido");
		}

		else {

			$("#errorestado").text("");
		}

		if (imagen === "") {

			$("#errorimagen").text("El campo imagen es requerido");
		}

		else {

			$("#errorimagen").text("");
		}


		return false;


	}

	


}






function actu_tempo() {
	
	var temporada = document.getElementById('temporada').value;
	var descripcion = document.getElementById('descripcion').value;
	
	if (temporada === "" || descripcion === "") {

		if (temporada === "") {

			$("#errortemporada").text("El campo nombre es requerido");
		}
		else {
			$("#errortemporada").text("");
		}

		if (descripcion === "") {

			$("#errordescripcion").text("El campo descripcion es requerido");
		}
		else {
			$("#errordescripcion").text("");
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











