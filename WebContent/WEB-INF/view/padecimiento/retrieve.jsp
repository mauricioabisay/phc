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
<h2 class="page-header">Detalle Padecimiento</h2>

	
		<fieldset><legend>Padecimiento</legend>
			<div class="col-sm-12">
				<label class="text-right col-sm-3">Padecimiento</label>
				<span class="text-left text-left col-sm-9">${padecimiento.padecimiento}</span>
			</div>
			
			<div class="col-sm-12">
				<label class="text-right col-sm-3">Estado</label>
				<span class="text-left col-sm-9">${padecimiento.estado}</span>
			</div>
			
			<div class="col-sm-12">
				<label class="text-right col-sm-3">Desc.</label>
				<span class="text-left col-sm-9">${padecimiento.descripcion}</span>
			</div>
		</fieldset>

	<div class="col-md-12">
		<fieldset><legend>Tratamientos</legend></fieldset>
			<table class="table table-responsive text-center">
				<thead>
					<tr>
						<th class="text-center">Tratamiento</th>
						<th class="text-center">Tipo</th>
						<th class="text-center">Desc.</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="t" items="${tratamientos}">
					<tr>
						<td>${t.tratamiento}</td>
						<td>${t.tipo}</td>
						<td>${t.descripcion}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
	</div>
	<div class="form-group col-md-12">
		<div align="center">
			<a href="${pageContext.request.contextPath}/padecimiento/${pacienteSummary.id}">
				<button type="button" class="btn btn-default btn-sm">Regresar a Listado</button>
			</a>
		</div>
	</div>