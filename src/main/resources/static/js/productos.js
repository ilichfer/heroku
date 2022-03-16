// Call the dataTables jQuery plugin
$(document).ready(function() {

	alert(productos);
	cargarProductos();

  $('#productosTable').DataTable();
});

async function cargarProductos(){

  const rawResponse = await fetch('productos', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const content = await rawResponse.json();

  console.log(content);

}
