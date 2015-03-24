<c:if test="${validationErrors != null}">
<div class="has-error">
<ul>
	<c:forEach items="${validationErrors}" var="error">
	<li>
		<c:out value="${error.propertyPath}" />
	</li>
	</c:forEach>
</ul>
</div></c:if>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="<c:url value = '/resources/js/addForm.js' />"></script>
<!--FORMULARIO PACIENTE-->
<h2 class="page-header">Nuevo Estudio de Laboratorio/Gabinete</h2>

<form method="post" class="form-horizontal">
	<c:if test='${laboratorioForm.id > 0}'>
		<form:hidden path="laboratorioForm.id"/>
		<form:hidden path="laboratorioForm.paciente" />
	</c:if>
	
	<div class="col-md-12">
		<fieldset>
			<legend>Laboratorio/Gabinete</legend>
			<c:set var="auxError"><form:errors path="laboratorioForm.laboratorio"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="laboratorioForm.laboratorio" class="control-label col-sm-3">Estudio</form:label>
				<div class="col-sm-6">
					<form:input path="laboratorioForm.laboratorio" class="form-control"/>
				</div>
			</div>
			<c:set var="auxError"><form:errors path="laboratorioForm.tipo"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="laboratorioForm.tipo" class="control-label col-sm-3">Tipo</form:label>
				<div class="col-sm-6">
					<form:select path="laboratorioForm.tipo" class="form-control">
						<form:option value="Laboratorio" label="Laboratorio" />
						<form:option value="Gabinete" label="Gabinete" />
					</form:select>
				</div>
			</div>
			<c:set var="auxError"><form:errors path="laboratorioForm.estado"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="laboratorioForm.estado" class="control-label col-sm-3">Estado</form:label>
				<div class="col-sm-6">
					<form:select path="laboratorioForm.estado" class="form-control">
						<form:option value="Solicitud" label="Solicitado" />
						<optgroup label="Resultado">
							<form:option value="Normal" label="Normal"/>
							<form:option value="Alterado" label="Alterado"/>
						</optgroup>
					</form:select>
				</div>
			</div>
			<c:set var="auxError"><form:errors path="laboratorioForm.observaciones"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="laboratorioForm.observaciones" class="control-label col-sm-3">Observaciones</form:label>
				<div class="col-sm-6">
					<form:textarea path="laboratorioForm.observaciones" class="form-control" rows="3"></form:textarea>
				</div>
			</div>
		</fieldset>
	</div>
	<div class="form-group col-md-12">
		<div align="center">
			<input type="submit" class="btn btn-default" value="Guardar" />
			<input type="reset" class="btn btn-default" value="Limpiar" />
		</div>
	</div>
</form>