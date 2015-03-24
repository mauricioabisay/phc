<h2 class="page-header">Exploración Física</h2>
<a href="${pageContext.request.contextPath}/exploracionfisica/create"><button type="button" class="btn btn-default btn-sm">
	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Nueva Exploración Física
</button></a>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<table class="table table-hover" style="padding-left:25%; padding-right:25%">
	<thead>
		<tr>
			<th>Fecha</th>
			<th>Observaciones Generales</th>
			<th>Opc.</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty exploraciones}">
		<c:forEach var="e" items="${exploraciones}">  
		<tr>
			<td>${e.fecha}</td>
			<td>${e.observaciones}</td>
			<td>
				<div class="btn-group">
					<a href="${pageContext.request.contextPath}/exploracionfisica/update/${e.id}">
						<button type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span>
						</button>
					</a>
					<a href="${pageContext.request.contextPath}/exploracionfisica/delete/${e.id}">
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