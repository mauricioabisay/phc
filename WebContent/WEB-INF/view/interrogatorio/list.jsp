<h2 class="page-header">Interrogatorio por Sistemas</h2>
<a href="${pageContext.request.contextPath}/interrogatorio/create"><button type="button" class="btn btn-default btn-sm">
	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Nuevo Interrogatorio por Sistemas
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
		<c:if test="${not empty interrogatorios}">
		<c:forEach var="i" items="${interrogatorios}">  
		<tr>
			<td>${i.fecha}</td>
			<td>${i.observaciones}</td>
			<td>
				<div class="btn-group">
					<a href="${pageContext.request.contextPath}/interrogatorio/retrieve/${i.id}">
						<button type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span>
						</button>
					</a>
					<a href="${pageContext.request.contextPath}/interrogatorio/update/${i.id}">
						<button type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						</button>
					</a>
					<a href="${pageContext.request.contextPath}/interrogatorio/delete/${i.id}">
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