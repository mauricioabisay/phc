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

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="<c:url value = '/resources/js/addForm.js' />"></script>
<!--FORMULARIO PACIENTE-->
<h2 class="page-header">Nuevo Padecimiento</h2>

<form method="post" class="form-horizontal">
<input type="hidden" id="counter" name="counter" value="1" />
	<div class="col-md-12">
		<fieldset><legend>Padecimiento</legend>
		<c:set var="auxError"><form:errors path="padecimientoForm.padecimiento"/></c:set>
		<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
			<label class="control-label col-sm-3">Padecimiento</label>
			<div class="col-sm-9">
				<form:input path="padecimientoForm.padecimiento" class="form-control"/>
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="padecimientoForm.estado"/></c:set>
		<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
			<label class="control-label col-sm-3">Estado</label>
			<div class="col-sm-9">
				<form:select path="padecimientoForm.estado" class="form-control">
					<form:option value="Activo" label="Activo"/>
					<form:option value="Remisión" label="Remisión"/>
				</form:select>
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="padecimientoForm.descripcion"/></c:set>
		<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
			<label class="control-label col-sm-3">Desc.</label>
			<div class="col-sm-9">
				<form:textarea path="padecimientoForm.descripcion" class="form-control" rows="3"/>
			</div>
		</div>
		</fieldset>
		
			<fieldset><legend>Tratamientos</legend>
			<c:set var="auxError"><form:errors path="padecimientoForm.tratamiento"/></c:set>
			<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="padecimientoForm.tratamiento" class="control-label col-sm-6">
					¿Actualmente esta bajo tratamiento para su padecimiento?
				</form:label>
				<div class="col-sm-6">
					<div class="radio-inline">
						<form:radiobutton path="padecimientoForm.tratamiento" value="si" label="Sí"/>
					</div>
					<div class="radio-inline">
						<form:radiobutton path="padecimientoForm.tratamiento" value="no" label="No"/>
					</div>
				</div>
			</div>
			
			<div id="tratamientos">
				<form:hidden path="padecimientoForm.counter"/>
				<c:forEach var="i" begin="1" end="${padecimientoForm.counter}">
					<c:set var="auxId" value="id_${i}"/>
					<c:set var="auxIgnorar" value="ignorar_${i}"/>
					<c:set var="auxTratamiento" value="tratamiento_${i}"/>
					<c:set var="auxTipo" value="tipo_${i}"/>
					<c:set var="auxDescripcion" value="descripcion_${i}"/>

					<div id="tratamiento_${i}" class="form-group inline">
						<div class="inline <c:if test='${requestScope[auxTratamiento].error}'>has-error</c:if>">
							<input name="ignorar_${i}" type="hidden" value="${requestScope[auxIgnorar] ? 'si' : 'no'}" />
							<c:if test='${not empty requestScope[auxId]}'>
								<input name="id_${i}" type="hidden" value="${requestScope[auxId].value}" />
							</c:if>
							<label class="control-label col-sm-1">Tratamiento</label>
							<div class="col-sm-2">
								<input name="tratamiento_${i}" value="${requestScope[auxTratamiento].value}" type="text" class="form-control"/>
							</div>
						</div>
						
						<div class="inline <c:if test='${requestScope[auxTipo].error}'>has-error</c:if>">
							<label class="control-label col-sm-1">Tipo</label>
							<div class="col-sm-2">
								<select name="tipo_${i}" class="form-control">
									<option value="Convencional" <c:if test='${requestScope[auxTipo].value == "Convencional"}'>selected="selected"</c:if>>Convencional</option>
									<option value="Alternativo" <c:if test='${requestScope[auxTipo].value == "Alternativo"}'>selected="selected"</c:if>>Alternativo</option>
									<option value="Tradicional" <c:if test='${requestScope[auxTipo].value == "Tradicional"}'>selected="selected"</c:if>>Tradicional</option>
								</select>
							</div>
						</div>
						
						<div class="inline <c:if test='${requestScope[auxDescripcion].error}'>has-error</c:if>">
							<label class="control-label col-sm-1">Desc.</label>
							<div class="col-sm-3">
								<textarea name="descripcion_${i}" class="form-control" rows="2">${requestScope[auxDescripcion].value}</textarea>
							</div>
						</div>
						
						<div class="col-sm-2">
							<input id="${i}" type="button" class="btn btn-default bt-mas" value="+" />
						</div>
					</div>
				</c:forEach>
			</div>
			</fieldset>
		
			
		
			
	</div>
	<div class="form-group col-md-12">
		<div align="center">
			<input type="submit" class="btn btn-default" value="Guardar" />
			<input type="reset" class="btn btn-default" value="Limpiar" />
		</div>
	</div>
</form>