<h2 class="page-header">Antecedentes Patológicos</h2>
<a href="${pageContext.request.contextPath}/padecimiento/create"><button type="button" class="btn btn-default btn-sm">
	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Nuevo Antecedente Patológico
</button></a>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<table class="table table-hover" style="padding-left:25%; padding-right:25%">
	<thead>
		<tr>
			<th>Padecimiento</th>
			<th>Desc.</th>
			<th>Estado</th>
			<th>Tratamiento</th>
			<th>Opc.</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty antecedentesPatologicos}">
		<c:forEach var="a" items="${antecedentesPatologicos}">  
		<tr>
			<td>${a.padecimiento}</td>
			<td>${a.descripcion}</td>
			<td>${a.estado}</td>
			<td>${a.tratamiento == "si" ? "SI" : "NO"}</td>
			<td>
				<div class="btn-group">
					<a href="${pageContext.request.contextPath}/padecimiento/retrieve/${a.id}">
						<button type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span>
						</button>
					</a>
					<a href="${pageContext.request.contextPath}/padecimiento/delete/${a.id}">
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