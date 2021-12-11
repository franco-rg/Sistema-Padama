function validar_registrohdesc() {
	
	var descuento = document.getElementById('descuento').value;
	



	
	if (descuento == "" || descuento > 99 ){
		
		if (descuento == ""  || descuento > 99) {

			$("#errordescuento").text("El campo descuento es obligatorio y no puede ser mas de 99%");
		}
		else{
			$("#errordescuento").text("");
		}

	
		
	
		return false;
	}
	
	
	
}




