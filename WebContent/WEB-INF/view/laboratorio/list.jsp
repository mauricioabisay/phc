<h2 class="page-header">Estudios Laboratorio/Gabinete</h2>
<a href="${pageContext.request.contextPath}/laboratorio/create"><button type="button" class="btn btn-default btn-sm">
	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Nuevo Estudio de Laboratorio/Gabinete
</button></a>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<table class="table table-hover" style="padding-left:25%; padding-right:25%">
	<thead>
		<tr>
			<th>Laboratorio/Gabinete</th>
			<th>Tipo</th>
			<th>Estado</th>
			<th>Obs.</th>
			<th>Opc.</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty estudios}">
		<c:forEach var="e" items="${estudios}">  
		<tr>
			<td>${e.laboratorio}</td>
			<td>${e.tipo}</td>
			<td>${e.estado}</td>
			<td>${e.observaciones}</td>
			<td>
				<div class="btn-group">
					<a href="${pageContext.request.contextPath}/laboratorio/retrieve/${e.id}">
						<button type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span>
						</button>
					</a>
					<a href="${pageContext.request.contextPath}/laboratorio/update/${e.id}">
						<button type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						</button>
					</a>
					<a href="${pageContext.request.contextPath}/laboratorio/delete/${e.id}">
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