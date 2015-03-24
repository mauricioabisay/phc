<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="<c:url value = '/resources/js/addForm.js' />"></script>

<h2 class="page-header">Nueva Exploración Física</h2>

<form method="post" class="form-horizontal">
	<c:if test='${exploracionFisicaForm.id > 0}'>
		<form:hidden path="exploracionFisicaForm.id"/>
		<form:hidden path="exploracionFisicaForm.paciente"/>
	</c:if>
	<div class="col-sm-6">
		<fieldset><legend>Peso y Estatura</legend>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.peso"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.peso" class="control-label col-sm-2">Peso</form:label>
				<div class="col-sm-4">
					<form:input path="exploracionFisicaForm.peso" class="form-control" />
				</div>
			</div>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.estatura"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.estatura" class="control-label col-sm-2">Estatura</form:label>
				<div class="col-sm-4">
					<form:input path="exploracionFisicaForm.estatura" class="form-control" />
				</div>
			</div>
		</fieldset>
	</div>
	<div class="col-sm-6">
		<fieldset><legend>Signos Vitales</legend>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.temperatura"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.temperatura" class="control-label col-sm-2">Temperatura</form:label>
				<div class="col-sm-4">
					<form:input path="exploracionFisicaForm.temperatura" class="form-control"/>
				</div>
			</div>
			<c:set var="auxSistolica"><form:errors path="exploracionFisicaForm.presion_arterial_sistolica"/></c:set>
			<c:set var="auxDiastolica"><form:errors path="exploracionFisicaForm.presion_arterial_diastolica"/></c:set>
			<div class="form-group <c:if test='${not empty auxSistolica && not empty auxDiastolica}'>has-error</c:if>">
				<label class="control-label col-sm-2">Presión Arterial</label>
				<div class="col-sm-4">
					<div class="input-group">
						<div <c:if test='${not empty auxSistolica}'>class="has-error"</c:if>>
							<form:input path="exploracionFisicaForm.presion_arterial_sistolica" class="form-control"/>
						</div>
						<div class="input-group-addon">/</div>
						<div <c:if test='${not empty auxDiastolica}'>class="has-error"</c:if>>
							<form:input path="exploracionFisicaForm.presion_arterial_diastolica" class="form-control"/>
						</div>
					</div>
				</div>
			</div>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.frec_cardiaca"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.frec_cardiaca" class="control-label col-sm-2">Frec. Cardiaca</form:label>
				<div class="col-sm-4">
					<form:input path="exploracionFisicaForm.frec_cardiaca" class="form-control"/>
				</div>
			</div>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.frec_respiratoria"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.frec_respiratoria" class="control-label col-sm-2">Frec. Respiratoria</form:label>
				<div class="col-sm-4">
					<form:input path="exploracionFisicaForm.frec_respiratoria" class="form-control"/>
				</div>
			</div>
		</fieldset>
	</div>
	
	<div class="col-sm-12">
		<fieldset><legend>Exploración del Cuerpo</legend>		
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.cabeza"/></c:set>
			<div class="col-sm-5 form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.cabeza" class="control-label">Cabeza</form:label>
				<form:textarea path="exploracionFisicaForm.cabeza" class="form-control"/>
			</div>
			<div class="col-sm-1">&nbsp;</div>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.ojos"/></c:set>
			<div class="col-sm-5 form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.ojos" class="control-label">Ojos</form:label>
				<form:textarea path="exploracionFisicaForm.ojos" class="form-control"/>
			</div>
			<div class="col-sm-1">&nbsp;</div>
				<c:set var="auxError"><form:errors path="exploracionFisicaForm.garganta"/></c:set>
			<div class="col-sm-5 form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.garganta" class="control-label">Garganta</form:label>
				<form:textarea path="exploracionFisicaForm.garganta" class="form-control"/>
			</div>
			<div class="col-sm-1">&nbsp;</div>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.nariz"/></c:set>
			<div class="col-sm-5 form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.nariz" class="control-label">Nariz</form:label>
				<form:textarea path="exploracionFisicaForm.nariz" class="form-control"/>
			</div>
			<div class="col-sm-1">&nbsp;</div>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.oido"/></c:set>
			<div class="col-sm-5 form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.oido" class="control-label">Oido</form:label>
				<form:textarea path="exploracionFisicaForm.oido" class="form-control"/>
			</div>
			<div class="col-sm-1">&nbsp;</div>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.torax"/></c:set>
			<div class="col-sm-5 form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.torax" class="control-label">Torax</form:label>
				<form:textarea path="exploracionFisicaForm.torax" class="form-control"/>
			</div>
			<div class="col-sm-1">&nbsp;</div>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.abdomen"/></c:set>
			<div class="col-sm-5 form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.abdomen" class="control-label">Abdomen</form:label>
				<form:textarea path="exploracionFisicaForm.abdomen" class="form-control"/>
			</div>
			<div class="col-sm-1">&nbsp;</div>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.genitales"/></c:set>
			<div class="col-sm-5 form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.genitales" class="control-label">Genitales</form:label>
				<form:textarea path="exploracionFisicaForm.genitales" class="form-control"/>
			</div>
			<div class="col-sm-1">&nbsp;</div>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.miembros"/></c:set>
			<div class="col-sm-5 form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.miembros" class="control-label">Miembros</form:label>
				<form:textarea path="exploracionFisicaForm.miembros" class="form-control"/>
			</div>
			<div class="col-sm-1">&nbsp;</div>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.habitus"/></c:set>
			<div class="col-sm-5 form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.habitus" class="control-label">Habitus</form:label>
				<form:textarea path="exploracionFisicaForm.habitus" class="form-control"/>
			</div>
			<div class="col-sm-1">&nbsp;</div>
		</fieldset>
	</div>
	<div class="col-sm-12">
		<fieldset><legend>Observaciones</legend>
		<c:set var="auxError"><form:errors path="exploracionFisicaForm.observaciones"/></c:set>
		<div <c:if test='${not empty auxError}'>class="has-error"</c:if>>
			<form:textarea path="exploracionFisicaForm.observaciones" class="form-control" rows="3"/>
		</div>
		</fieldset>
	</div>
	<div class="col-sm-12">
		<fieldset><legend>Alergias</legend>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.alergia"/></c:set>
			<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.alergia" class="control-label col-sm-6">¿Presenta alguna reacción alérgica?</form:label>
				<div class="col-sm-6">
					<div class="radio-inline">
						<form:radiobutton path="exploracionFisicaForm.alergia" value="si" label="Sí"/>
					</div>
					<div class="radio-inline">
						<form:radiobutton path="exploracionFisicaForm.alergia" value="no" label="No"/>
					</div>
				</div>
			</div>
			<div id="alergias">
				<form:hidden path="exploracionFisicaForm.counter"/>
				
				<c:forEach var="i" begin="1" end="${exploracionFisicaForm.counter}">
				<c:set var="auxId" value="id_${i}"/>
				<c:set var="auxIgnorar" value="ignorar_${i}"/>
				<c:set var="auxAlergia" value="alergia_${i}"/>
				<div id="alergia_${i}" class="form-group inline" <c:if test='${requestScope[auxIgnorar]}'>style="display:none"</c:if>>
					<div class="inline <c:if test='${requestScope[auxAlergia].error}'>has-error</c:if>">
						<input name="id_${i}" type="hidden" value="${requestScope[auxId]}" />
						<input name="ignorar_${i}" type="hidden" value="${requestScope[auxIgnorar] ? 'si' : 'no'}"/>
						<label class="control-label col-sm-3">Alergia</label>
						<div class="col-sm-5">
							<input name="alergia_${i}" type="text" class="form-control" value="${requestScope[auxAlergia].value}"/>
						</div>
					</div>
					<c:if test='${i + 1 > exploracionFisicaForm.counter}'>
					<div class="col-sm-2">
						<input id="${i}" type="button" class="btn btn-default bt-mas" value="+"/>
					</div>
					</c:if>
					<c:if test='${i + 1 <= exploracionFisicaForm.counter}'>
					<div class="col-sm-2">
						<input id="${i}" type="button" class="btn btn-default bt-menos" value="-"/>
					</div>
					</c:if>
				</div>
				</c:forEach>
			</div>
		</fieldset>
	</div>
	<div class="form-group col-md-12">
		<div align="center">
			<input type="submit" class="btn btn-default" value="Enviar" />
			<input type="reset" class="btn btn-default" value="Limpiar" />
		</div>
	</div>
</form>