<h2 class="page-header">Antecedentes Heredo-Familiares</h2>
<a href="${pageContext.request.contextPath}/antecedentefamiliar/create"><button type="button" class="btn btn-default btn-sm">
	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Nuevo Antecedente Heredo-Familiar
</button></a>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<table class="table table-hover" style="padding-left:25%; padding-right:25%">
	<thead>
		<tr>
			<th>Enfermedad</th>
			<th>Parentesco</th>
			<th>Estado</th>
			<th>Opc.</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty antecedentesFamiliares}">
		<c:forEach var="a" items="${antecedentesFamiliares}">  
		<tr>
			<td>${a.enfermedad}</td>
			<td>${a.parentesco}</td>
			<td>${a.estado}</td>
			<td>
				<div class="btn-group">
					<a href="${pageContext.request.contextPath}/antecedentefamiliar/delete/${a.id}">
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