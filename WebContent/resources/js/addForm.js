$(document).ready(
	function() {
		$(".bt-mas").each(
			function (el){
				$(this).on("click",add);
			}
		);
		$(".bt-menos").each(
			function(el){
				$(this).on("click",remove);
			}
		);
	}
);

function add(){
	var id = parseInt($('#counter').val());
	var newId = id + 1;
	var wrapper = $(this).parent().parent().parent();
	var clone = $(this).parent().parent().clone(true);

	var inputs = $(clone).find(" :input");

	for (var i = 0,len = inputs.length;i<len;i++) {

		var tipo = inputs[i].getAttribute("type");
		var nombre = inputs[i].getAttribute("name");
		if ( (typeof nombre != "undefined") && (nombre != null) ) {
			
			var cadena = String(nombre).split("_");
			inputs[i].setAttribute('name',cadena[0] + '_' + newId);

			if ( (tipo == "radio") || (tipo == "checkbox") ) {
				inputs[i].checked = false;
			} else {
				if (cadena[0] == "ignorar") {
					inputs[i].value = 'no';
				}else if(cadena[0] == "id") {
					inputs[i].value = '0';
				}else {
					inputs[i].value = '';
				}
				
			}
		}
	}

	var cloneDivName = $(clone).attr("id").split("_");
	$(clone).attr("id", cloneDivName[0] + "_" + newId);
	$(clone).children().children("#" + id).attr("id", newId);

	$(clone).appendTo(wrapper);
	
	$(this).val("-");
	$(this).off();
	$(this).on("click", remove);

	$('#counter').val(newId);
}

function remove(){
	var id = $(this).attr("id");
	$('[name="ignorar_' + id + '"]').val("si");
	$(this).parent().parent().css("display", "none");
}