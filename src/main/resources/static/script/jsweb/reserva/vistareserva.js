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

			$("#errornumero_tarjeta").text("El campo numero tarjeta es obligatorio y son 16 digitos");
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

			$("#error_cvv").text("El campo CV es obligatorio y son 4 digitos");
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
		console.log(sum1);
		console.log(sum2);
		resultado = parseFloat(sum1) + parseFloat(sum2);
		document.getElementById("spTotal").value = resultado;

		document.getElementById('contenido_reserva').style.display = 'none';
		document.getElementById('boton_reservar').style.display = 'block';
		document.getElementById('boton_calcular').style.display = 'none';
		document.getElementById('modificar_reserva').style.display = 'block';

		document.getElementById('contenido_pago').style.display = 'block';
		return true;
	}
	
	
	
}

function modificar_reserva(){


document.getElementById('contenido_reserva').style.display = 'block';
document.getElementById('boton_reservar').style.display = 'none';
document.getElementById('boton_calcular').style.display = 'block';
document.getElementById('contenido_pago').style.display = 'none';
document.getElementById('modificar_reserva').style.display = 'none';
$("#errorfechainicio").text("");
$("#errorcorreo").text("");
$("#errortelefono").text("");
$("#errorapellido").text("");
$("#errornombre").text("");
$("#errorfechafinal").text("");
			$("#errorfechainicio").text("");
}


window.onload = function() {
    
    var valor = document.getElementById("idinputhabi").value;
    document.getElementById("idinputhabioculto").value=valor;    
    
    
    var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1;
	var yyyy = today.getFullYear();
 	if(dd<10){
        dd='0'+dd
    } 
    if(mm<10){
        mm='0'+mm
    } 
	
	today = yyyy+'-'+mm+'-'+dd;
	document.getElementById("fechaini").setAttribute("min", today);
	document.getElementById("fechafi").setAttribute("min", today);
}; 	










restaFechas = function(f1,f2)
{

console.log(f1);
console.log(f2)
var diff = Date.parse(f2) - Date.parse(f1);
return diff/(1000*60*60*24);

}

items = document.getElementsByClassName("itemFecha");
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






