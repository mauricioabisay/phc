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
<h2 class="page-header">Nuevo Estudio de Laboratorio/Gabinete</h2>

<form method="post" class="form-horizontal">
<input type="hidden" id="counter" name="counter" value="1" />
	<div class="col-md-12">
		<fieldset>
			<legend>Estudios de Laboratorio/Gabinete</legend>
			<div id="antecedentes">
			
			<c:forEach var="i" begin="1" end="${counter}">
			
			<c:set var="auxIgnorar" value="ignorar_${i}"/>
			<c:set var="auxLab" value="laboratorio_${i}"/>
			<c:set var="auxObs" value="observaciones_${i}"/>
			<c:set var="auxEst" value="estado_${i}"/>
			
			<div id="laboratorio_${i}" class="form-group inline" <c:if test='${requestScope[auxIgnorar]}'>style="display:none"</c:if>>
				
				<div class="inline <c:if test='${requestScope[auxLab].error}'>has-error</c:if>">
					<input name="ignorar_${i}" type="hidden" value="${requestScope[auxIgnorar]?'si':'no'}" />
					<label class="control-label col-sm-1">Estudio</label>
					<div class="col-sm-1">
						<input name="laboratorio_${i}" type="text" class="form-control" value="${requestScope[auxLab].value}" />
					</div>
				</div>
				
				<div class="inline">
					<label class="control-label col-sm-1">Tipo</label>
					<div class="col-sm-1">
						<select name="tipo_${i}" class="form-control">
							<option value="Laboratorio">Laboratorio</option>
							<option value="Gabinete">Gabinete</option>
						</select>
					</div>
				</div>
				
				<div class="inline <c:if test='${requestScope[auxEst].error}'>has-error</c:if>">
					<label class="control-label col-sm-1">Estado</label>
					<div class="col-sm-1">
						<select name="estado_${i}" class="form-control">
							<option value="Solicitud" <c:if test='${requestScope[auxEst]=="Solicitado"}'>selected="selected"</c:if>>Solicitado</option>
							<optgroup label="Resultado">
								<option value="Normal" <c:if test='${requestScope[auxEst]=="Resultado"}'>selected="selected"</c:if>>Normal</option>
								<option value="Alterado" <c:if test='${requestScope[auxEst]=="Resultado"}'>selected="selected"</c:if>>Alterado</option>
							</optgroup>
						</select>
					</div>
				</div>
				
				<div class="inline <c:if test='${requestScope[auxObs].error}'>has-error</c:if>">
					<label class="control-label col-sm-1">Obs.</label>
					<div class="col-sm-4">
						<textarea name="observaciones_${i}" type="text" class="form-control">${requestScope[auxObs].value}</textarea>
					</div>
				</div>
				
				<div class="col-sm-1">
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