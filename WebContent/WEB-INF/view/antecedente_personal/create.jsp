<c:if test="${validationErrors != null}">
	<div class="has-error">
		<ul>
			<c:forEach items="${validationErrors}" var="error">
				<li><c:out value="${error.propertyPath}" /></li>
			</c:forEach>
		</ul>
	</div>
</c:if>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script src="<c:url value = '/resources/js/addForm.js' />"></script>
<!--FORMULARIO ANTECEDENTES NO PATOLOGICOS-->
<h2 class="page-header">Antecedentes Personales No Patológicos</h2>

<form method="post" class="form-horizontal">
<form:hidden path="antecedentePersonalForm.id"/>
<form:hidden path="antecedentePersonalForm.paciente"/>
<!-- Embarazo y Lactancia -->
<div class="col-md-12" <c:if test='${pacienteSummary.sexo=="Hombre"}'>style="display:none"</c:if>>
	<fieldset><legend>Embarazo y Lactancia</legend>
<!-- Lactancia -->
		<c:set var="auxError"><form:errors path="antecedentePersonalForm.lactancia" /></c:set>
		<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="antecedentePersonalForm.lactancia" class="control-label col-sm-3">Lactancia</form:label>
			<div class="col-sm-9">
				<div class="radio-inline"><form:radiobutton path="antecedentePersonalForm.lactancia" value="si" label="Sí"/></div>
				<div class="radio-inline"><form:radiobutton path="antecedentePersonalForm.lactancia" value="no" label="No" /></div>
			</div>
		</div>
<!-- Embarazo -->
		<c:set var="auxError"><form:errors path="antecedentePersonalForm.embarazo" /></c:set>
		<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="antecedentePersonalForm.embarazo" class="control-label col-sm-3">Embarazo</form:label>
			<div class="col-sm-9">
				<div class="radio-inline"><form:radiobutton path="antecedentePersonalForm.embarazo" value="si" label="Sí"/></div>
				<div class="radio-inline"><form:radiobutton path="antecedentePersonalForm.embarazo" value="no" label="No" /></div>
			</div>
		</div>
<!-- Detalles Embarazo -->
		<div id="embarazo">
<!-- Gesta -->
			<c:set var="auxError"><form:errors path="antecedentePersonalForm.gesta"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="antecedentePersonalForm.gesta" class="control-label col-sm-3">Gesta</form:label>
				<div class="col-sm-1">
					<form:input path="antecedentePersonalForm.gesta" class="form-control" />
				</div>
			</div>
<!-- Semanas Embarazo -->
			<c:set var="auxError"><form:errors path="antecedentePersonalForm.semanas_embarazo"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="antecedentePersonalForm.semanas_embarazo" class="control-label col-sm-3">Semanas de Embarazo</form:label>
				<div class="col-sm-1">
					<form:input path="antecedentePersonalForm.semanas_embarazo" class="form-control" />
				</div>
			</div>
<!-- Peso pregestacional -->
			<c:set var="auxError"><form:errors path="antecedentePersonalForm.peso_pregestacional"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="antecedentePersonalForm.peso_pregestacional" class="control-label col-sm-3">Peso pregestacional</form:label>
				<div class="col-sm-1">
					<form:input path="antecedentePersonalForm.peso_pregestacional" class="form-control" />
				</div>
			</div>
		</div>
	</fieldset>
</div>
<!-- Alcohol -->
		<div class="col-md-6">
		<fieldset>
			<legend>Consumo de Alcohol</legend>
<!-- Consumo -->
			<c:set var="auxError"><form:errors path="antecedentePersonalForm.alcohol"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="antecedentePersonalForm.alcohol" class="control-label col-sm-3">¿Consume bebidas
					alcohólicas?</form:label>
				<div class="col-sm-6">
					<div class="radio-inline">
					<form:radiobutton path="antecedentePersonalForm.alcohol" value="si" label ="Sí" onClick="$('#alcohol_detalle').css('display','block')"/>
					</div>
					<div class="radio-inline"><form:radiobutton path="antecedentePersonalForm.alcohol" value="no" label="No" onClick="$('#alcohol_detalle').css('display','none')"/></div>
				</div>
			</div>
<!-- Detalle Consumo Alcohol -->
			<div id="alcohol_detalle" <c:if test='${antecedentePersonalForm.alcohol == "no"}'>style="display:none"</c:if>>
<!-- Frecuencia Consumo Alcohol -->
				<c:set var="auxValor"><form:errors path="antecedentePersonalForm.alcohol_frec_valor"/></c:set>
				<c:set var="auxTipo"><form:errors path="antecedentePersonalForm.alcohol_frec_tipo"/></c:set>
				
				<div class="form-group <c:if test='${not empty auxValor || not empty auxTipo}'>has-error</c:if>">
					<label class="control-label col-sm-3">Frecuencia de Consumo</label>
					<div class="col-sm-2">
						<form:input path="antecedentePersonalForm.alcohol_frec_valor" class="form-control" />
					</div>
					<label class="control-label col-sm-1">veces</label>
					<div class="col-sm-3">
						<form:select path="antecedentePersonalForm.alcohol_frec_tipo" class="form-control">
							<form:option value="diario" label="Al día"/>
							<form:option value="semanal" label="Por semana"/>
							<form:option value="mensual" label="Por mes"/>
							<form:option value="anual" label="Al año"/>
						</form:select>
					</div>
				</div>
<!-- Cantidad Consumo Alcohol -->
				<c:set var="auxError"><form:errors path="antecedentePersonalForm.alcohol_frec_cantidad"/></c:set>
				<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
					<form:label path="antecedentePersonalForm.alcohol_frec_cantidad" class="control-label col-sm-3">¿Cuántas copas
						consume por salida?</form:label>
					<div class="col-sm-6">
						<form:input path="antecedentePersonalForm.alcohol_frec_cantidad" class="form-control" />
					</div>
				</div>
				
			</div>
		</fieldset>
		</div>
<!-- Tabaco -->
		<div class="col-md-6">
		<fieldset>
			<legend>Consumo de Tabaco</legend>
<!-- Consumo -->
			<c:set var="auxError"><form:errors path="antecedentePersonalForm.tabaco"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="antecedentePersonalForm.tabaco" class="control-label col-sm-3">¿Fuma?</form:label>
				<div class="col-sm-6">
					<div class="radio-inline">
					<form:radiobutton path="antecedentePersonalForm.tabaco" value="si" label="Sí" onClick="$('#tabaco_detalle').css('display','block')"/>
					</div>
					<div class="radio-inline">
					<form:radiobutton path="antecedentePersonalForm.tabaco" value="no" label="No" onClick="$('#tabaco_detalle').css('display','none')"/>
					</div>
				</div>
			</div>
<!-- Detalle Consumo Tabaco -->
			<div id="tabaco_detalle" <c:if test='${antecedentePersonalForm.tabaco == "no"}'>style="display:none"</c:if>>
			
<!-- Frecuencia Consumo Tabaco -->
				<c:set var="auxCantidad"><form:errors path="antecedentePersonalForm.tabaco_frec_cantidad"/></c:set>
				<c:set var="auxTipo"><form:errors path="antecedentePersonalForm.tabaco_frec_tipo"/></c:set>
				<div class="form-group <c:if test='${not empty auxCantidad || not empty auxTipo}'>has-error</c:if>">
					<label class="control-label col-sm-3">Frecuencia de Consumo</label>
					<div class="col-sm-2">
						<form:input path="antecedentePersonalForm.tabaco_frec_cantidad" class="form-control" />
					</div>
					<label class="control-label col-sm-1">cigarros</label>
					<div class="col-sm-3">
						<form:select path="antecedentePersonalForm.tabaco_frec_tipo" class="form-control">
							<form:option value="diario" label="Al día"/>
							<form:option value="semanal" label="Por semana"/>
							<form:option value="mensual" label="Por mes"/>
							<form:option value="anual" label="Al año"/>
						</form:select>
					</div>
				</div>
<!-- Inicio de Consumo Tabaco
				<c:set var="auxValor"><form:errors path="antecedentePersonalForm.tabaco_inicio_valor"/></c:set>
				<c:set var="auxTipo"><form:errors path="antecedentePersonalForm.tabaco_inicio_tipo"/></c:set>
				<div class="form-group <c:if test='${not empty auxValor || not empty auxTipo}'>has-error</c:if>">
					<label class="control-label col-sm-3">¿Desde cuándo fuma?</label>
					<div class="col-sm-3">
						<form:input path="antecedentePersonalForm.tabaco_inicio_valor" class="form-control" />
					</div>
					<div class="col-sm-3">
						<form:select path="antecedentePersonalForm.tabaco_inicio_tipo" class="form-control">
							<form:option value="diario" label="Al día"/>
							<form:option value="semanal" label="Por semana"/>
							<form:option value="mensual" label="Por mes"/>
							<form:option value="anual" label="Al año"/>
						</form:select>
					</div>
				</div>
-->
			</div>
		</fieldset>
		</div>
<!-- Ejercicios -->
		<div class="col-md-12">
		<fieldset>
			<legend>Ejercicio</legend>
			<c:set var="auxError"><form:errors path="antecedentePersonalForm.ejercicio"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="antecedentePersonalForm.ejercicio" class="control-label col-sm-3">¿Realiza alguna clase de ejercicio?</form:label>
				<div class="col-sm-6">
					<div class="radio-inline"><form:radiobutton path="antecedentePersonalForm.ejercicio" value="si" label="Sí"/></div>
					<div class="radio-inline"><form:radiobutton path="antecedentePersonalForm.ejercicio" value="no" label="No"/></div>
				</div>
			</div>
			<form:hidden path="antecedentePersonalForm.counter" />
			<div id="ejercicios">
				<c:forEach var="i" begin="1" end="${antecedentePersonalForm.counter}">
				<c:set var="auxIgnorar" value="ignorar_${i}"/>

				<c:set var="auxEjercicioId" value="id_ejercicio_${i}"/>
				
				<c:set var="auxEjercicio" value="ejercicio_${i}"/>
				<c:set var="auxEjercicioTipo" value="tipo_${i}"/>
				<c:set var="auxEjercicioFrecValor" value="frec_valor_${i}"/>
				<c:set var="auxEjercicioFrecTipo" value="frec_tipo_${i}"/>
				
				<div id="ejercicio_${i}" class="form-group inline" <c:if test='${requestScope[auxIgnorar]}'>style="display:none"</c:if>>
					<div class="inline <c:if test='${requestScope[auxEjercicio].error}'>has-error</c:if>">
						<input name="ignorar_${i}" type="hidden" value="${requestScope[auxIgnorar]?'si':'no'}" />
						<c:if test="${not empty requestScope[auxEjercicioId]}">
							<input name="id_${i}" type="hidden" value="${requestScope[auxEjercicioId].value}"/>
						</c:if>
						<label class="control-label col-sm-1">Ejercicio</label>
						<div class="col-sm-2">
							<input name="ejercicio_${i}" type="text" class="form-control" value="${requestScope[auxEjercicio].value}" />
						</div>
					</div>

					<div class="inline <c:if test='${requestScope[auxEjercicioTipo].error}'>has-error</c:if>">
						<label class="control-label col-sm-1">Tipo</label>
						<div class="col-sm-2">
							<select name="ejerciciotipo_${i}" class="form-control">
								<option value="aerobico" <c:if test='${requestScope[auxEjercicioTipo]=="aerobico"}'>selected="selected"</c:if>>Aeróbico</option>
								<option value="anaerobico" <c:if test='${requestScope[auxEjercicioTipo]=="anaerobico"}'>selected="selected"</c:if>>Anaeróbico</option>
							</select>
						</div>
					</div>
					<div <c:if test='${requestScope[auxEjercicioFrecValor].error}'>class="has-error"</c:if>>
						<label class="control-label col-sm-1">Veces</label>
						<div class="col-sm-1">
							<input name="ejerciciofrecvalor_${i}" class="form-control" value="${requestScope[auxEjercicioFrecValor].value}" />
						</div>
					</div>
					<div class="col-sm-1 <c:if test='${requestScope[auxEjercicioFrecTipo].error}'>has-error</c:if>">
						<select name="ejerciciofrectipo_${i}" class="form-control">
							<option value="diario" <c:if test='${requestScope[auxEjercicioFrecTipo]=="diario"}'>selected="selected"</c:if>>Por día</option>
							<option value="semanal" <c:if test='${requestScope[auxEjercicioFrecTipo]=="semanal"}'>selected="selected"</c:if>>Por semana</option>
							<option value="mensual" <c:if test='${requestScope[auxEjercicioFrecTipo]=="mensual"}'>selected="selected"</c:if>>Por mes</option>
						</select>
					</div>
					<div class="col-sm-2">
						<input id="${i}" type="button" class="btn btn-default bt-mas"
							value="+" />
					</div>
				</div>
				</c:forEach>
			</div>
		</fieldset>
		</div>
	
	<div class="form-group col-md-12">
		<div align="center">
			<input type="submit" class="btn btn-default" value="Guardar" /> <input
				type="reset" class="btn btn-default" value="Limpiar" />
		</div>
	</div>
</form>