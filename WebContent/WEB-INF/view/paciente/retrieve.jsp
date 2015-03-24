<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 class="page-header">${pacienteForm.nombre}&nbsp;${pacienteForm.ap}&nbsp;${pacienteForm.am}</h2>
<div>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Datos Personales</h3>
		</div>
		<div class="panel-body">
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Nombre</span>
				<span class="col-sm-9 text-left">${pacienteForm.nombre}&nbsp;${pacienteForm.ap}&nbsp;${pacienteForm.am}</span>
			</div>
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Fecha Nacimiento</span>
				<span class="col-sm-9">${pacienteForm.fecha_nacimiento}</span>
			</div>
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Edad</span>
				<span class="col-sm-9">${pacienteForm.edad}</span>
			</div>
		<!-- Ocupacion -->
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Ocupación</span>
				<span class="col-sm-9">${pacienteForm.ocupacion}</span>
			</div>
		<!-- Sexo -->
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Sexo</span>
				<span class="col-sm-9">${pacienteForm.sexo}</span>
			</div>
		<!-- Estado Civil -->
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Edo.Civil</span>
				<span class="col-sm-9">${pacienteForm.edo_civil}</span>
			</div>	
		</div>
	</div>
	
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Dirección</h3>
		</div>
		<div class="panel-body">
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Calle</span>
				<span class="col-sm-9">
					${pacienteForm.calle}&nbsp;
					Ext.&nbsp;${pacienteForm.num_ext}&nbsp;
					Int.&nbsp;${pacienteForm.num_int}
				</span>
			</div>
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Colonia</span>
				<span class="col-sm-9">${pacienteForm.colonia}</span>
			</div>
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Ciudad</span>
				<span class="col-sm-9">${pacienteForm.ciudad}</span>
			</div>
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Estado</span>
				<span class="col-sm-9">${pacienteForm.estado}</span>
			</div>
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">C.P.</span>
				<span class="col-sm-9">${pacienteForm.cp}</span>
			</div>
		</div>
	</div>
	
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Información de Contacto</h3>
		</div>
		<div class="panel-body">
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Teléfono</span>
				<span class="col-sm-9">${pacienteForm.telefono}</span>
			</div>
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Celular</span>
				<span class="col-sm-9">${pacienteForm.celular}</span>
			</div>
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Recomendado por</span>
				<span class="col-sm-9">${pacienteForm.recomendado_por}</span>
			</div>
		</div>
	</div>
</div>

<div class="form-group col-md-12">
	<div align="center">
		<a href="${pageContext.request.contextPath}/paciente/update/${pacienteForm.id}">
			<input type="button" class="btn btn-default" value="Editar" />
		</a>
	</div>
</div>