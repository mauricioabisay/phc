<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form method="post" class="form-horizontal">
	<fieldset>
		<legend class="page-header">Buscar Paciente</legend>
<!-- Nombre -->
		<div class="form-group">
			<label class="control-label col-sm-3">Buscar Paciente</label>
			<div class="col-sm-3">
				<form:input path="searchForm.nombre" class="form-control" />
			</div>
			<div class="col-sm-3">
				<input type="submit" class="btn btn-default" value="Buscar" />
			</div>
		</div>
	</fieldset>
</form>

<a href="paciente/create"><button type="button" class="btn btn-default btn-sm">
	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Nuevo Paciente
</button></a>


<table class="table table-hover" style="padding-left:25%; padding-right:25%">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Ap. Paterno</th>
			<th>Ap. Materno</th>
			<th>Opc.</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty pacientes}">
		<c:forEach var="p" items="${pacientes}">  
		<tr>
			<td>${p.nombre}</td>
			<td>${p.apellidoPaterno}</td>
			<td>${p.apellidoMaterno}</td>
			<td>
				<div class="btn-group">
					<a href="${pageContext.request.contextPath}/paciente/retrieve/${p.id}">
						<button type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span>
						</button>
					</a>
					<a href="${pageContext.request.contextPath}/paciente/update/${p.id}">
						<button type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						</button>
					</a>
					<a href="${pageContext.request.contextPath}/paciente/delete/${p.id}">
						<button type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
						</button>
					</a>
				</div>
			</td>
		</tr>
		</c:forEach>
		</c:if>
	</tbody>
</table>