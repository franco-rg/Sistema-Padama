let buys = document.getElementById('tbl-buys');
let cboxAll = buys.querySelector('thead input[type="checkbox"]');
let cboxes = buys.querySelectorAll('tbody input[type="checkbox"]');
let totalOutput = document.getElementById('total');
let total = 0;



[].forEach.call(cboxes, function (cbox) {
  cbox.addEventListener('change', handleRowSelect);
});

cboxAll.addEventListener('change', function () {
  [].forEach.call(cboxes, function (cbox) {
    //cbox.checked = cboxAll.checked;
    cbox.click();
  });
});

function handleRowSelect (e) {
  let row = e.target.parentNode.parentNode;
  let qty = row.querySelector('td:nth-child(2)').textContent;
  let price = row.querySelector('td:nth-child(3)').textContent;
  let cost = Number(qty) * Number(price);
  
  
  
  
  
  if (e.target.checked) {
    total += cost;
  } else {
    total -= cost;
  }
  
  total = Number(total.toFixed(2));
  totalOutput.value = total;
  
 
	

	  

}


$(document).ready(function() {
  $(document).on('change', '.checkbox', function() {
	suma_servicios = document.getElementById('total_seleccionados').value;
	
	console.log(suma_servicios);
    var total = 0.0
    if (this.checked) {
      total = parseFloat(suma_servicios) + parseFloat($(this).parents('tr').find('td.cantidad').html());
      console.log(total);
    }
    else{
		total = parseFloat(suma_servicios) - parseFloat($(this).parents('tr').find('td.cantidad').html());
		console.log(total);
	}
	document.getElementById('total_seleccionados').value = total;
	suma_servicios
    	
  });
});



function validar_registro_pago(){
	
	var propietarios = document.getElementById('propietarios').value;
	var num_tarjeta = document.getElementById('numero_tarjeta').value;
	var mes = document.getElementById('mes').value;
	var anio = document.getElementById('ano').value;
	var cvvv = document.getElementById('cvv').value;
	
	
	
	
	if (propietarios === "" || num_tarjeta == "" ||  num_tarjeta.length != 16 || mes === "" || anio === "" || cvvv === "" || cvvv.length != 4 ){
		
		if (propietarios === "" ) {

			$("#errorpropietarios").text("El campo propietario es obligatorio");
		}
		else{
			$("#errorpropietarios").text("");
		}

		if (num_tarjeta === "" || num_tarjeta.length != 16) {

			$("#errornumero_tarjeta").text("El campo numero tarjeta es obligatorio y no puede ser menor a seis");
		}
		else{
			$("#errornumero_tarjeta").text("");
			
		}
		

		if (mes === "" || anio === "") {

			$("#error_año_mes").text("Debe seleccionar un mes y un año");
		}
		else{
			$("#error_año_mes").text("");
		}

		if (cvvv === "" || cvvv.length != 4 ) {

			$("#error_cvv").text("El campo CV es obligatorio y no puede ser menor a seis");
		}
		
		else {

			$("#error_cvv").text("");
		}
		
		
		
		return false;
		
		
	}
	
	
}




function sumar(){

	

	
	var fechaini = document.getElementById('fechaini').value;
	var fechafi = document.getElementById('fechafi').value;
	var nombre = document.getElementById('nombre').value;
	var apellido = document.getElementById('apellido').value;
	var username = document.getElementById('correo').value;
	var telefono = document.getElementById('telefono').value;
	
	
	
	if (fechaini === "" ||fechaini > fechafi || fechaini == fechafi ||fechafi === "" || nombre === "" || apellido === "" || username.includes('@') === false  || username=== "" || telefono.length != 9  || telefono === "" ){
		
		if (fechaini === "" ||  fechaini > fechafi || fechaini == fechafi ) {

			$("#errorfechainicio").text("El campo fecha de inicio es requerido y no debe ser mayor a fecha final o iguales");
		}
		else{
			$("#errorfechainicio").text("");
		}

		if (fechafi === "" ||  fechaini > fechafi || fechaini == fechafi) {

			$("#errorfechafinal").text("El campo fecha final es requerido y no debe ser menor a fecha de inicio o iguales");
		}
		else{
			$("#errorfechafinal").text("");
			
		}
		

		if (nombre === ""   ) {

			$("#errornombre").text("El valor de campo nombre es requerido");
		}
		else{
			$("#errornombre").text("");
		}

		if (apellido === "") {

			$("#errorapellido").text("El campo apellido es requerido");
		}
		
		else {

			$("#errorapellido").text("");
		}
		
		
		
		if ( telefono.length != 9  || telefono === "") {

			$("#errortelefono").text("El campo telefono es requerido y debe contar con 9 caracteres");
		}
		
		else {

			$("#errortelefono").text("");
		}
		
		
		
		
		if ( username.includes('@') === false  || username=== "") {

			$("#errorcorreo").text("El campo correo es requerido y debe contener un @");
		}
		
		else {

			$("#errorcorreo").text("");
		}
		return false;
		
	}
	
	else{
		
		var sum1 = document.getElementById("total").value;
		var sum2 = document.getElementById("total_hxt").value;
		var sum_t = document.getElementById("total_seleccionados").value;
		var preciobase = document.getElementById("precio_base").value;	
		var resultado =  (parseFloat(sum1) + parseFloat(sum_t)) + parseFloat(sum2);
		
		console.log(sum1);
		console.log(sum2);
		console.log(sum_t);
		console.log(preciobase);
		console.log(resultado);
		
		if(parseFloat(preciobase) == parseFloat(resultado)){
			document.getElementById('contenido_reserva').style.display = 'none';
			document.getElementById('no_paga').style.display = 'block';
			document.getElementById('boton_calcular').style.display = 'none';
			document.getElementById('modificar_reserva').style.display = 'block';
			document.getElementById('boton_reservar').style.display = 'block';
			document.getElementById('precio_anterior_np').value = preciobase; 
			document.getElementById('precio_actual_np').value = resultado; 
			document.getElementById('precio_anterior_npd').value = preciobase; 
			document.getElementById('precio_actual_npd').value = resultado; 
			document.getElementById('propietarios').value = 'nombre_propietario'; 
			document.getElementById('numero_tarjeta').value = 6666666666666666; 
			document.getElementById('mes').value = "Abril"; 
			document.getElementById('ano').value = "2021"; 
			document.getElementById('cvv').value = 3333;
			document.getElementById('devolucion_npd').value = 0;
			console.log(document.getElementById('numero_tarjeta').value)
			
		}
		if(parseFloat(preciobase) > parseFloat(resultado)){
			document.getElementById('contenido_reserva').style.display = 'none';
			document.getElementById('no_paga_devolucion').style.display = 'block';
			document.getElementById('boton_calcular').style.display = 'none';
			document.getElementById('modificar_reserva').style.display = 'block';
			document.getElementById('boton_reservar').style.display = 'block';
			document.getElementById('precio_anterior_npd').value = preciobase; 
			document.getElementById('precio_actual_npd').value = resultado;
			document.getElementById('propietarios').value = 'nombre_propietario'; 
			document.getElementById('numero_tarjeta').value = 6666666666666666; 
			document.getElementById('mes').value = "Abril"; 
			document.getElementById('ano').value = "2021"; 
			document.getElementById('cvv').value = 3333;  
			var total_todo =  parseFloat(preciobase) - parseFloat(resultado) ;
			document.getElementById('devolucion_npd').value = total_todo;
			
			
		}
		if(parseFloat(preciobase)<parseFloat(resultado)){
			
			var total_todo = parseFloat(resultado) - parseFloat(preciobase);
			console.log(total_todo)
			document.getElementById('contenido_reserva').style.display = 'none';
			document.getElementById('contenido_pago').style.display = 'block';
			document.getElementById('boton_calcular').style.display = 'none';
			document.getElementById('modificar_reserva').style.display = 'block';
			document.getElementById('boton_reservar').style.display = 'block';
			
			document.getElementById('precio_anterior_p').value = preciobase; 
			document.getElementById('precio_actual_p').value = resultado; 
			
			
			document.getElementById('propietarios').value = ''; 
			document.getElementById('numero_tarjeta').value = ''; 
			document.getElementById('mes').value = "Abril"; 
			document.getElementById('ano').value = "2021"; 
			document.getElementById('cvv').value = ''; 
			document.getElementById('devolucion_npd').value = 0;
			
			document.getElementById('spTotal').value = parseFloat(total_todo);
			 
			
		}
		
		

		return true;
	}
}





window.onload = function() {
	
	
	
	
	items = document.getElementsByClassName("itemFecha")
	
	var fechainicial = document.getElementById('fechaini').value;
 	var fechafinal = document.getElementById('fechafi').value;
	
  	var cantidad = parseInt(restaFechas(fechainicial,fechafinal));
  
  	console.log(cantidad);
  	var precio = parseFloat(document.getElementById('precio_habi').value);
  	var total_pago = parseFloat((cantidad * precio));
	var suma_servicios = document.getElementById("suma_servicios").value;
	
	
	
	document.getElementById("total_hxt").value = total_pago;
	
    var  preciobase = parseFloat(document.getElementById("total_hxt").value) + parseFloat(document.getElementById("suma_servicios").value) ;
	
	document.getElementById("precio_base").value = preciobase;
	document.getElementById("total").value = 0.0;
	document.getElementById("total_seleccionados").value = suma_servicios;
	
	

};


function modificar_reserva(){


	document.getElementById('contenido_reserva').style.display = 'block';
	document.getElementById('boton_reservar').style.display = 'none';
	document.getElementById('boton_calcular').style.display = 'block';
	document.getElementById('contenido_pago').style.display = 'none';
	document.getElementById('modificar_reserva').style.display = 'none';
	document.getElementById('no_paga_devolucion').style.display = 'none';	
	document.getElementById('no_paga').style.display = 'none';
	$("#errorfechainicio").text("");
	$("#errorcorreo").text("");
	$("#errortelefono").text("");
	$("#errorapellido").text("");
	$("#errornombre").text("");
	$("#errorfechafinal").text("");
	$("#errorfechainicio").text("");
}


restaFechas = function(f1,f2)
{

console.log(f1);
console.log(f2)
var diff = Date.parse(f2) - Date.parse(f1);
return diff/(1000*60*60*24);

}

items = document.getElementsByClassName("itemFecha")
for (var i = 0; i < items.length; i++) {
 items[i].addEventListener('change', function() {
  n = document.getElementById("total");
  
  var fechainicial = document.getElementById('fechaini').value;
  var fechafinal = document.getElementById('fechafi').value;
	
  var cantidad = parseInt(restaFechas(fechainicial,fechafinal));
  
  
  var precio = parseFloat(document.getElementById('precio_habi').value);
  var total_pago = parseFloat((cantidad * precio));
  
  

  console.log(Math.sign(total_pago));
  if(Math.sign(total_pago) == -1 ){
	document.getElementById("noches").value = 0;
	document.getElementById("total_hxt").value = 0.0;
  }
  if(Math.sign(total_pago) == 1 ){
	document.getElementById("noches").value = cantidad;
	document.getElementById("total_hxt").value = total_pago;
  }
  
  
 });
};









	

		
	