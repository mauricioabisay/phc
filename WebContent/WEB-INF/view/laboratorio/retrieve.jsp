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
<h2 class="page-header">Estudio de Laboratorio/Gabinete ${laboratorioForm.fechaString}</h2>
	<div class="col-md-12">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">${laboratorioForm.tipo}</h3>
			</div>
			<div class="panel-body">
				<div class="col-sm-12">
					<span class="col-sm-3 text-right">Estudio</span>
					<span class="col-sm-9 text-left">${laboratorioForm.laboratorio}</span>
				</div>
				<div class="col-sm-12">
					<span class="col-sm-3 text-right">Última Actualización</span>
					<span class="col-sm-9">${laboratorioForm.fechaString}</span>
				</div>
				<div class="col-sm-12">
					<span class="col-sm-3 text-right">Tipo</span>
					<span class="col-sm-9">${laboratorioForm.tipo}</span>
				</div>
				<div class="col-sm-12">
					<span class="col-sm-3 text-right">Estado</span>
					<span class="col-sm-9">${laboratorioForm.estado}</span>
				</div>
				<div class="col-sm-12">
					<span class="col-sm-3 text-right">Observaciones</span>
					<span class="col-sm-9">${laboratorioForm.observaciones}</span>
				</div>	
			</div>
		</div>
	
	</div>
	<div class="form-group col-md-12">
		<div align="center">
			<a href="${pageContext.request.contextPath}/laboratorio/update/${laboratorioForm.id}">
				<input type="button" class="btn btn-default" value="Editar" />
			</a>
		</div>
	</div>