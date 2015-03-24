<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--FORMULARIO PACIENTE-->
<c:if test="${not empty edit && edit}">
	<h2 class="page-header">Editar Paciente</h2>
</c:if>
<c:if test="${empty edit}">
	<h2 class="page-header">Nuevo Paciente</h2>
</c:if>

<form method="post" class="form-horizontal">	
	<form:hidden path="pacienteForm.id"/>
	<div class="col-md-6">
		<fieldset>
			<legend>Datos Personales</legend>
<!-- Nombre -->
			<c:set var="auxError"><form:errors path="pacienteForm.nombre"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="pacienteForm.nombre" class="control-label col-sm-3">Nombre</form:label>
				<div class="col-sm-9">
					<form:input path="pacienteForm.nombre" class="form-control" />
				</div>
			</div>
<!-- Apellido Paterno -->
			<c:set var="auxError"><form:errors path="pacienteForm.ap"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="pacienteForm.ap" class="control-label col-sm-3">Ap.Paterno</form:label>
				<div class="col-sm-9">
					<form:input path="pacienteForm.ap" class="form-control" />
				</div>
			</div>
<!-- Apellido Materno -->
			<c:set var="auxError"><form:errors path="pacienteForm.am"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="pacienteForm.am" class="control-label col-sm-3">Ap.Materno</form:label>
				<div class="col-sm-9">
					<form:input path="pacienteForm.am" class="form-control" />
				</div>
			</div>
<!-- Fecha de Nacimiento -->
			<c:set var="auxDDError"><form:errors path="pacienteForm.dd"/></c:set>
			<c:set var="auxMMError"><form:errors path="pacienteForm.mm"/></c:set>
			<c:set var="auxAAAAError"><form:errors path="pacienteForm.aaaa"/></c:set>
			<div class="form-group <c:if test='${( not empty auxDDError || not empty auxMMError || not empty auxAAAAError) }'>has-error</c:if>">
				<label class="control-label col-sm-3">Fecha Nacimiento</label>
				<div class="form-inline col-sm-9">
					<div class="input-group">
						<form:input path="pacienteForm.dd" class="form-control" placeholder="DD" size="1"
							maxlength="2" />
						<div class="input-group-addon">/</div>
						<form:select path="pacienteForm.mm" class="form-control">
							<form:option label="Enero" value="1" />
							<form:option value="2" label="Febrero" />
							<form:option value="3" label="Marzo" />
							<form:option value="4" label="Abril" />
							<form:option value="5" label="Mayo" />
							<form:option value="6" label="Junio" />
							<form:option value="7" label="Julio" />
							<form:option value="8" label="Agosto" />
							<form:option value="9" label="Septiembre" />
							<form:option value="10" label="Octubre" />
							<form:option value="11" label="Noviembre" />
							<form:option value="12" label="Diciembre" />
						</form:select>
						<div class="input-group-addon">/</div>
						<form:input path="pacienteForm.aaaa" class="form-control" placeholder="AAAA"
							size="3" maxlength="4" />
					</div>
				</div>
			</div>
<!-- Ocupacion -->
			<c:set var="auxError"><form:errors path="pacienteForm.ocupacion"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="pacienteForm.ocupacion" class="control-label col-sm-3">Ocupación</form:label>
				<div class="col-sm-9">
					<form:input path="pacienteForm.ocupacion" class="form-control" />
				</div>
			</div>
<!-- Sexo -->
			<c:set var="auxError"><form:errors path="pacienteForm.sexo"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="pacienteForm.sexo" class="control-label col-sm-3">Sexo</form:label>
				<div class="col-sm-9">
					<div class="radio-inline"><form:radiobutton path="pacienteForm.sexo" value="M" label="Masculino" /></div>
					<div class="radio-inline"><form:radiobutton path="pacienteForm.sexo" value="F" label="Femenino" /></div>
				</div>
			</div>
<!-- Estado Civil -->
			<c:set var="auxError"><form:errors path="pacienteForm.edo_civil"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<label class="control-label col-sm-3">Edo.Civil</label>
				<div class="col-sm-9">
					<form:select path="pacienteForm.edo_civil" class="form-control">
						<form:option value="Soltero" label="Soltero" />
						<form:option value="Casado" label="Casado" />
						<form:option value="Divorciado" label="Divorciado" />
						<form:option value="ULibre" label="U.Libre" />
					</form:select>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend>Dirección</legend>
			
			<div class="form-group inline">
<!-- Calle -->
				<c:set var="auxError"><form:errors path="pacienteForm.calle"/></c:set>
				<div class="<c:if test='${not empty auxError}'>has-error</c:if>">
					<form:label path="pacienteForm.calle" class="control-label col-sm-3">Calle</form:label>
					<div class="col-sm-3">
						<form:input path="pacienteForm.calle" class="form-control" />
					</div>
				</div>
<!-- Num.Ext. -->				
				<c:set var="auxError"><form:errors path="pacienteForm.num_ext"/></c:set>
				<div class="<c:if test='${not empty auxError}'>has-error</c:if>">
					<form:label path="pacienteForm.num_ext" class="control-label col-sm-1">Ext.</form:label>
					<div class="col-sm-2">
						<form:input path="pacienteForm.num_ext" class="form-control" />
					</div>
				</div>
<!-- Num.Int. -->
				<c:set var="auxError"><form:errors path="pacienteForm.num_int"/></c:set>
				<div class="<c:if test='${not empty auxError}'>has-error</c:if>">
					<form:label path="pacienteForm.num_int" class="control-label col-sm-1">Int.</form:label>
					<div class="col-sm-2">
						<form:input path="pacienteForm.num_int" class="form-control" />
					</div>
				</div>
			</div>
<!-- Colonia -->
			<c:set var="auxError"><form:errors path="pacienteForm.colonia"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="pacienteForm.colonia" class="control-label col-sm-3">Colonia</form:label>
				<div class="col-sm-9">
					<form:input path="pacienteForm.colonia" class="form-control" />
				</div>
			</div>
<!-- Ciudad -->
			<c:set var="auxError"><form:errors path="pacienteForm.ciudad"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="pacienteForm.ciudad" class="control-label col-sm-3">Ciudad</form:label>
				<div class="col-sm-9">
					<form:input path="pacienteForm.ciudad" class="form-control" />
				</div>
			</div>
<!-- Estado -->
			<c:set var="auxError"><form:errors path="pacienteForm.estado"/></c:set>
				<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<label class="control-label col-sm-3">Estado</label>
				<div class="col-sm-9">
					<form:select path="pacienteForm.estado" class="form-control">
						<form:option value="AGU" label="Aguascalientes" />
						<form:option value="BCN" label="Baja California" />
						<form:option value="BCS" label="Baja California Sur" />
						<form:option value="CAM" label="Campeche" />
						<form:option value="CHP" label="Chiapas" />
						<form:option value="CHH" label="Chihuahua" />
						<form:option value="COA" label="Coahuila" />
						<form:option value="COL" label="Colima" />
						<form:option value="DIF" label="Distrito Federal" />
						<form:option value="DUR" label="Durango" />
						<form:option value="GUA" label="Guanajuato" />
						<form:option value="GRO" label="Guerrero" />
						<form:option value="HID" label="Hidalgo" />
						<form:option value="JAL" label="Jalisco" />
						<form:option value="MEX" label="Estado de México" />
						<form:option value="MIC" label="Michoacán" />
						<form:option value="MOR" label="Morelos" />
						<form:option value="NAY" label="Nayarit" />
						<form:option value="NLE" label="Nuevo León" />
						<form:option value="OAX" label="Oaxaca" />
						<form:option value="PUE" label="Puebla" />
						<form:option value="QUE" label="Querétaro" />
						<form:option value="ROO" label="Quintana Roo" />
						<form:option value="SLP" label="San Luis Potosí" />
						<form:option value="SIN" label="Sinaloa" />
						<form:option value="SON" label="Sonora" />
						<form:option value="TAB" label="Tabasco" />
						<form:option value="TAM" label="Tamaulipas" />
						<form:option value="TLA" label="Tlaxcala" />
						<form:option value="VER" label="Veracruz" />
						<form:option value="YUC" label="Yucatán" />
						<form:option value="ZAC" label="Zacatecas" />
					</form:select>
				</div>
			</div>

			<c:set var="auxError"><form:errors path="pacienteForm.cp"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="pacienteForm.cp" class="control-label col-sm-3">C.P.</form:label>
				<div class="col-sm-9">
					<form:input path="pacienteForm.cp" class="form-control" />
				</div>
			</div>
		</fieldset>
	</div>

	<div class="col-md-5">
		<fieldset>
			<legend>Información de Contacto</legend>
<!-- Teléfono -->
			<div class="form-group">
				<label class="control-label col-sm-3">Teléfono</label>
				<div class="form-inline col-sm-9">
					<div class="input-group">
						<div class="input-group-addon">(</div>
						<c:set var="auxError"><form:errors path="pacienteForm.tel_lada"/></c:set>
						<div class="<c:if test='${not empty auxError}'>has-error</c:if>">
							<form:input path="pacienteForm.tel_lada" class="form-control" maxlength="3" size="1" />
						</div>
						<div class="input-group-addon">)</div>
						<c:set var="auxError"><form:errors path="pacienteForm.tel_1"/></c:set>
						<div class="<c:if test='${not empty auxError}'>has-error</c:if>">
							<form:input path="pacienteForm.tel_1" class="form-control" maxlength="1" size="1" />
						</div>
						<div class="input-group-addon">-</div>
						<c:set var="auxError"><form:errors path="pacienteForm.tel_2"/></c:set>
						<div class="<c:if test='${not empty auxError}'>has-error</c:if>">
							<form:input path="pacienteForm.tel_2" class="form-control" maxlength="2" size="1" />
						</div>
						<div class="input-group-addon">-</div>
						<c:set var="auxError"><form:errors path="pacienteForm.tel_3"/></c:set>
						<div class="<c:if test='${not empty auxError}'>has-error</c:if>">
							<form:input path="pacienteForm.tel_3" class="form-control" maxlength="2" size="1" />
						</div>
						<div class="input-group-addon">-</div>
						<c:set var="auxError"><form:errors path="pacienteForm.tel_4"/></c:set>
						<div class="<c:if test='${not empty auxError}'>has-error</c:if>">
							<form:input path="pacienteForm.tel_4" class="form-control" maxlength="2" size="1" />
						</div>
					</div>
				</div>
			</div>
<!-- Celular -->
			<div class="form-group">
				<label class="control-label col-sm-3">Celular</label>
				<div class="form-inline col-sm-9">
					<div class="input-group">
						<c:set var="auxError"><form:errors path="pacienteForm.cel_1"/></c:set>
						<div class="<c:if test='${not empty auxError}'>has-error</c:if>">
							<form:input path="pacienteForm.cel_1" class="form-control" maxlength="2" size="1" />
						</div>
						<div class="input-group-addon">-</div>
						<c:set var="auxError"><form:errors path="pacienteForm.cel_2"/></c:set>
						<div class="<c:if test='${not empty auxError}'>has-error</c:if>">
							<form:input path="pacienteForm.cel_2" class="form-control" maxlength="2" size="1" />
						</div>
						<div class="input-group-addon">-</div>
						<c:set var="auxError"><form:errors path="pacienteForm.cel_3"/></c:set>
						<div class="<c:if test='${not empty auxError}'>has-error</c:if>">
							<form:input path="pacienteForm.cel_3" class="form-control" maxlength="2" size="1" />
						</div>
						<div class="input-group-addon">-</div>
						<c:set var="auxError"><form:errors path="pacienteForm.cel_4"/></c:set>
						<div class="<c:if test='${not empty auxError}'>has-error</c:if>">
							<form:input path="pacienteForm.cel_4" class="form-control" maxlength="2" size="1" />
						</div>
						<div class="input-group-addon">-</div>
						<c:set var="auxError"><form:errors path="pacienteForm.cel_5"/></c:set>
						<div class="<c:if test='${not empty auxError}'>has-error</c:if>">
							<form:input path="pacienteForm.cel_5" class="form-control" maxlength="2" size="1" />
						</div>
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend>Referencia</legend>
<!-- Referencia -->
			<c:set var="auxError"><form:errors path="pacienteForm.recomendado_boolean"/></c:set>
			<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
				<label class="control-label col-sm-9">¿Ha venido por
					instrucciones de su médico u otra persona?</label>
				<div class="col-sm-3">
					<div class="radio-inline">
						<form:radiobutton path="pacienteForm.recomendado_boolean" value="si" label="Sí" />
					</div>
					<div class="radio-inline">
						<form:radiobutton path="pacienteForm.recomendado_boolean" value="no" label="No"/>
					</div>
				</div>
			</div>
			<c:set var="auxError"><form:errors path="pacienteForm.recomendado_por"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="pacienteForm.recomendado_por" class="control-label col-sm-3">Referencia</form:label>
				<div class="col-sm-9">
					<form:input path="pacienteForm.recomendado_por" class="form-control" />
				</div>
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