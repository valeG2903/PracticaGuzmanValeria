<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>
<title>Practica03 Valeria Guzman</title>
</head>

<body> 
<div class="container">
 <h2>Consulta de Revista</h2>
		<div class="col-md-23" >  
		       <form accept-charset="UTF-8"  action="consultaRevista" class="simple_form" id="defaultForm2"  method="post">
					<div class="row">
						<div class="col-md-3">	
								<select id="id_categoria" name="idCategoria" class='form-control'>
										<option value=" "> [ Seleccione Categoria ]</option>    
								</select>
						</div>
								
						</div>
						<div class="col-md-3">
								<input class="form-control" id="id_nombre" name="nombre" placeholder="Ingrese el nombre" type="text"/>
						
						<div class="col-md-3">
								<button type="submit" class="btn btn-primary" id="validateBtnw1" >FILTRA</button><br>&nbsp;<br>
						</div>
					</div>
					<div class="row" > 
						<div class="col-md-12">
								<div class="content" >
						
									<table id="tableRevista" class="table table-striped table-bordered" >
										<thead>
											<tr>
												<th>ID</th>
												<th>Nombre</th>
												<th>Precio</th>
												<th>Serie</th>
												<th>Categoria</th>
												<th>FechaLanzamiento</th>
												<th>FechaEdicion</th>
												<th>Categoria</th>
											</tr>
										</thead>
										<tbody>  
												<c:forEach items="${revista}" var="x">
													<tr>
														<td>${x.idRevista}</td>
														<td>${x.nombre}</td>
														<td>${x.precio}</td>
														<td>${x.serie}</td>
														<td>${x.categoria}</td>
														<td>${x.fechaLanzamiento}</td>
														<td>${x.fechaEdicion}</td>
														<td>${x.categoria.nombre}</td>
													</tr>
												</c:forEach>
										</tbody>
										</table>	
									
								</div>	
						</div>
					</div>
		 		</form>
		  </div>
  
 </div>

<script type="text/javascript">
$.getJSON("cargaCategoria", {}, function(data){
	$.each(data, function(index,item){
		$("#id_categoria").append("<option value="+item.idCategoria +">"+ item.nombre +"</option>");
	});
});
</script>
    
</body>
</html> 
