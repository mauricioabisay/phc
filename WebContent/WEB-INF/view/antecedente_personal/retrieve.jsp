<!--antecedentePersonalFormULARIO ANTECEDENTES NO PATOLOGICOS-->
<h2 class="page-header">Antecedentes Personales No Patológicos - Última Act. ${antecedentePersonalForm.fechaActualizacion}</h2>
<div class="col-md-12">
	<div class="panel panel-primary" <c:if test='${pacienteSummary.sexo=="Hombre"}'>style="display:none"</c:if>>
		<div class="panel-heading">
			<h3 class="panel-title">Embarazo y Lactancia</h3>
		</div>
		<div class="panel-body">
			<table class="table table-responsive">
				<tr>
					<td class="col-sm-6 text-right">Embarazo</td>
					<td class="col-sm-6 text-left">${(antecedentePersonalForm.embarazo == "si") ? "Sí" : "No"}</td>
				</tr>
				<tr>
					<td class="col-sm-6 text-right">Gesta</td>
					<td class="col-sm-6 text-left">${antecedentePersonalForm.gesta}</td>
				</tr>
				<tr>
					<td class="col-sm-6 text-right">Semana de Embarazo</td>
					<td class="col-sm-6 text-left">${antecedentePersonalForm.semanas_embarazo}</td>
				</tr>
				<tr>
					<td class="col-sm-6 text-right">Peso Pre-Gestacional</td>
					<td class="col-sm-6 text-left">${antecedentePersonalForm.peso_pregestacional}</td>
				</tr>
				<tr>
					<td class="col-sm-6 text-right">Lactancia</td>
					<td class="col-sm-6 text-left">${(antecedentePersonalForm.lactancia == "si") ? "Sí" : "No"}</td>
				</tr>
			</table>
		</div>
	</div>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Consumo de Alcohol</h3>
		</div>
		<div class="panel-body">
			<table class="table table-responsive">
				<tr>
					<td class="col-sm-3 text-right">¿Consume bebidas alcohólicas?</td>
					<td class="col-sm-3 text-left">${(antecedentePersonalForm.alcohol == "si") ? "Sí" : "No"}</td>
				</tr>
				<c:if test='${antecedentePersonalForm.alcohol == "si"}'>
				<tr>
					<td class="col-sm-3 text-right">Frecuencia de Consumo</td>
					<td class="col-sm-3 text-left">
					${antecedentePersonalForm.alcohol_frec_valor}
					&nbsp;veces&nbsp;
					${antecedentePersonalForm.alcohol_frec_tipo}
					</td>
				</tr>
				<tr>
					<td class="col-sm-3 text-right">¿Cuántas copas consume por salida?</td>
					<td class="col-sm-3 text-left">${antecedentePersonalForm.alcohol_frec_cantidad}</td>
				</tr>
				</c:if>
			</table>
		</div>
	</div>

	
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Consumo de Tabaco</h3>
		</div>
		<div class="panel-body">
			<table class="table table-responsive">
				<tr>
					<td class="col-sm-3 text-right">¿Fuma?</td>
					<td class="col-sm-3 text-left">${(antecedentePersonalForm.tabaco == "si") ? "Sí" : "No"}</td>
				</tr>
				<c:if test='${antecedentePersonalForm.tabaco == "si"}'>
				<tr>
					<td class="col-sm-3 text-right">Frecuencia de Consumo</td>
					<td class="col-sm-3 text-left">
					${antecedentePersonalForm.tabaco_frec_cantidad}
					&nbsp;cigarros&nbsp;
					${antecedentePersonalForm.tabaco_frec_tipo}
					</td>
				</tr>
				<tr>
					<td class="col-sm-3">&nbsp;</td>
					<td class="col-sm-3">&nbsp;</td>
				</tr>
				</c:if>
			</table>
		</div>
	</div>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Actividad Física</h3>
		</div>
		<div class="panel-body">
			<table class="table table-responsive">
				<tr>
					<td class="col-sm-6 text-right">¿Realiza alguna clase de ejercicio?</td>
					<td class="col-sm-6 text-left">${(antecedentePersonalForm.ejercicio == "si") ? "Sí" : "No"}</td>
				</tr>
			</table>
			<c:if test="${antecedentePersonalForm.counter > 0}">
				<table class="table table-responsive text-center">
					<thead>
						<tr>
							<th class="text-center">Ejercicio</th>
							<th class="text-center">Tipo</th>
							<th class="text-center">Frecuencia</th>
							<th class="text-center">Opc.</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="e" items="${ejercicios}">
						<tr>
							<td>${e.ejercicio}</td>
							<td>${e.tipo}</td>
							<td>${e.frecuenciaValor}&nbsp;${e.frecuenciaTipo}</td>
							<td>
								<div class="btn-group">
									<a href="${pageContext.request.contextPath}/antecedentepersonal/deleteejercicio/${e.id}">
										<button type="button" class="btn btn-default btn-sm">
											<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
										</button>
									</a>
								</div>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>

		
	

</div>

<div class="antecedentePersonalForm-group col-md-12" style="padding:2em">
	<div align="center">
		<a href="${pageContext.request.contextPath}/antecedentepersonal/update/${antecedentePersonalForm.id}">
			<input type="button" class="btn btn-default" value="Actualizar" />
		</a>
	</div>
</div>