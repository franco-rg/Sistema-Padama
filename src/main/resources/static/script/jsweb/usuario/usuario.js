
function validar_registro_usuario() {
	
	
	var nombre = document.getElementById('nombre').value;
	var apellidos = document.getElementById('apellidos').value;
	var username = document.getElementById('username').value;
	var contraseña = document.getElementById('contraseña').value;
	var dni = document.getElementById('DNI').value;
	var telefono = document.getElementById('telefono').value;

	
	

	if (nombre === "" || apellidos === "" || username.includes('@') === false  || username=== "" || contraseña.length < 8  || contraseña === "" || dni === "" ||  dni.length != 8 || telefono.length <= 5  || telefono === "") {

		if (nombre === "" ) {

			$("#errornombre").text("El campo nombre es requerido");
		}
		else {
			$("#errornombre").text("");
		}

		if (apellidos === "") {

			$("#errorapellidos").text("El campo apellidos es requerido");
		}
		else {
			$("#errorapellidos").text("");
		}
		
		if ( username.includes('@') === false  || username=== "") {

			$("#errorusername").text("El campo correo electronico es requerido y debe parecerce a: example@gmail.com");
		}
		else {
			$("#errorusername").text("");
		}


		if (contraseña.length < 8  || contraseña === "") {

			$("#errorcontraseña").text("El campo contraseña es requerido y debe tener  ocho caracteres");
		}

	
		else{

		
			$("#errorcontraseña").text("");
		}
		
		

		if (dni === "" ||  dni.length != 8) {

			$("#errorDNI").text("El campo DNI es requerido y debe tener ocho caracteres");
		}

		
		else{

			$("#errorDNI").text("");
			
		}




		if (telefono.length <= 5  || telefono === "") {

			$("#errortelefono").text("El campo telefono es requerido y debe tener mas de cinco caracteres");
		}

		else {

			$("#errortelefono").text("");
		}

	


		return false;


	}

	


}

