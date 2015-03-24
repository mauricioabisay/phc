<c:if test="${validationErrors != null}">
	<div class="has-error">
		<ul>
			<c:forEach items="${validationErrors}" var="error">
				<li><c:out value="${error.propertyPath}" /></li>
			</c:forEach>
		</ul>
	</div>
</c:if>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script src="<c:url value = '/resources/js/addForm.js' />"></script>
<!--FORMULARIO PACIENTE-->
<h2 class="page-header">Revisión por Sistemas <c:if test='${interrogatorioForm.id > 0}'>${interrogatorioForm.fechaString}</c:if></h2>

<form method="post" class="form-horizontal">
	<c:if test='${interrogatorioForm.id > 0}'>
	<form:hidden path="interrogatorioForm.id" />
	<form:hidden path="interrogatorioForm.paciente" />
	</c:if>
	<div class="form-group">
		<fieldset class="col-sm-6">
			<legend>Gastro-Instestinal</legend>
			<form:textarea path="interrogatorioForm.gastro_intestinal" class="form-control" rows="3" placeholder="Observaciones"/>
		</fieldset>
		
		<fieldset class="col-sm-6">
			<legend>Respiratorio</legend>
			<form:textarea path="interrogatorioForm.respiratorio" class="form-control" rows="3" placeholder="Observaciones"/>
		</fieldset>
	</div>
	<div class="form-group">
		<fieldset class="col-sm-6">
			<legend>Cardiovascular</legend>
			<form:textarea  path="interrogatorioForm.cardiovascular" class="form-control" rows="3" placeholder="Observaciones"/>
		</fieldset>
		
		<fieldset class="col-sm-6">
			<legend>Genito-Urinario</legend>
			<form:textarea  path="interrogatorioForm.genito_urinario" class="form-control" rows="3" placeholder="Observaciones"/>
		</fieldset>
	</div>
	
	<div class="form-group">
		<fieldset class="col-sm-6">
			<legend>Esfera Mental</legend>
			<form:textarea  path="interrogatorioForm.esfera_mental" class="form-control" rows="3" placeholder="Observaciones"/>
		</fieldset>
		
		<fieldset class="col-sm-6">
			<legend>Psicosomático</legend>
			<form:textarea  path="interrogatorioForm.psicosomatico" class="form-control" rows="3" placeholder="Observaciones"/>
		</fieldset>
	</div>
	
	<div class="form-group">
		<fieldset class="col-sm-6">
			<legend>Otorrino-Laringológico</legend>
			<form:textarea  path="interrogatorioForm.otorrino_laringologico" class="form-control" rows="3" placeholder="Observaciones"/>
		</fieldset>
		
		<fieldset class="col-sm-6">
			<legend>Músculo-Esquelético</legend>
			<form:textarea  path="interrogatorioForm.musculo_esqueletico" class="form-control" rows="3" placeholder="Observaciones"/>
		</fieldset>
	</div>
	
	<div class="form-group">
		<fieldset class="col-sm-6">
			<legend>Endócrino</legend>
			<form:textarea  path="interrogatorioForm.endocrino" class="form-control" rows="3" placeholder="Observaciones"/>
		</fieldset>
		<fieldset class="col-sm-6">
			<legend>Observaciones</legend>
			<form:textarea  path="interrogatorioForm.observaciones" class="form-control" rows="3" placeholder="Observaciones"/>
		</fieldset>
	</div>

	<div class="form-group col-md-12">
		<div align="center">
			<input type="submit" class="btn btn-default" value="Guardar" />
			<input type="reset" class="btn btn-default" value="Limpiar" />
		</div>
	</div>
</form>