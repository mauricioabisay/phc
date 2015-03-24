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
<h2 class="page-header">Nuevo Antecedente Heredo-Familiar</h2>

<form method="post" class="form-horizontal">
<input type="hidden" id="counter" name="counter" value="1" />
	<div class="col-md-12">
		<fieldset>
			<legend>Antecedentes Heredofamiliares</legend>
			<div id="antecedentes">
			
			<c:forEach var="i" begin="1" end="${counter}">
			
			<c:set var="auxIgnorar" value="ignorar_${i}"/>
			<c:set var="auxEnf" value="enfermedad_${i}"/>
			<c:set var="auxPar" value="parentesco_${i}"/>
			<c:set var="auxEst" value="estado_${i}"/>
			
			<div id="antecedente_${i}" class="form-group inline" <c:if test='${requestScope[auxIgnorar]}'>style="display:none"</c:if>>
				
				<div class="inline <c:if test='${requestScope[auxEnf].error}'>has-error</c:if>">
					<input name="ignorar_${i}" type="hidden" value="${requestScope[auxIgnorar]?'si':'no'}" />
					<label class="control-label col-sm-2">Enfermedad</label>
					<div class="col-sm-2">
						<input name="enfermedad_${i}" type="text" class="form-control" value="${requestScope[auxEnf].value}" />
					</div>
				</div>
				
				<div class="inline <c:if test='${requestScope[auxPar].error}'>has-error</c:if>">
					<label class="control-label col-sm-1">Parentesco</label>
					<div class="col-sm-2">
						<input name="parentesco_${i}" type="text" class="form-control" value="${requestScope[auxPar].value}"/>
					</div>
				</div>
				
				<div class="inline <c:if test='${requestScope[auxEst].error}'>has-error</c:if>">
					<label class="control-label col-sm-1">Estado</label>
					<div class="col-sm-2">
						<select name="estado_${i}" class="form-control">
							<option value="Activo" <c:if test='${requestScope[auxEst]=="Activo"}'>selected="selected"</c:if>>Activo</option>
							<option value="Remision" <c:if test='${requestScope[auxEst]=="Remision"}'>selected="selected"</c:if>>Remisión</option>
						</select>
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
			<input type="submit" class="btn btn-default" value="Enviar" />
			<input type="reset" class="btn btn-default" value="Limpiar" />
		</div>
	</div>
</form>