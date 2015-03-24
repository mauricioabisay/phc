<h2 class="page-header">Revisión por Sistemas ${interrogatorio.fecha}</h2>

<form method="post" class="form-horizontal">
	<div class="form-group">
		<fieldset class="col-sm-6">
			<legend>Gastro-Instestinal</legend>
			<p>${interrogatorio.gastroIntestinal}</p>
		</fieldset>
		
		<fieldset class="col-sm-6">
			<legend>Respiratorio</legend>
			<p>${interrogatorio.respiratorio}</p>
		</fieldset>
	</div>
	<div class="form-group">
		<fieldset class="col-sm-6">
			<legend>Cardiovascular</legend>
			<p>${interrogatorio.cardiovascular}</p>
		</fieldset>
		
		<fieldset class="col-sm-6">
			<legend>Genito-Urinario</legend>
			<p>${interrogatorio.genitoUrinario}</p>
		</fieldset>
	</div>
	
	<div class="form-group">
		<fieldset class="col-sm-6">
			<legend>Esfera Mental</legend>
			<p>${interrogatorio.esferaMental}</p>
		</fieldset>
		
		<fieldset class="col-sm-6">
			<legend>Psicosomático</legend>
			<p>${interrogatorio.psicosomatico}</p>
		</fieldset>
	</div>
	
	<div class="form-group">
		<fieldset class="col-sm-6">
			<legend>Otorrino-Laringológico</legend>
			<p>${interrogatorio.otorrinoLaringologico}</p>
		</fieldset>
		
		<fieldset class="col-sm-6">
			<legend>Músculo-Esquelético</legend>
			<p>${interrogatorio.musculoEsqueletico}</p>
		</fieldset>
	</div>
	
	<div class="form-group">
		<fieldset class="col-sm-6">
			<legend>Endócrino</legend>
			<p>${interrogatorio.endocrino}</p>
		</fieldset>
		<fieldset class="col-sm-6">
			<legend>Observaciones</legend>
			<p>${interrogatorio.observaciones}</p>
		</fieldset>
	</div>

	<div class="form-group col-md-12">
		<div align="center">
			<a href="${pageContext.request.contextPath}/interrogatorio/update/${interrogatorio.id}">
				<button type="button" class="btn btn-default">Editar</button>
			</a>
		</div>
	</div>
</form>