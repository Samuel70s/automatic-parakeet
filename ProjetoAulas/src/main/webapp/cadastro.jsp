<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro Plataforma </title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			
			<div class="col-md-4 text-center">
			<h2>Cadastrar no Sistema</h2>
				<form action="cadastro">
					  <div class="form-group">
					    <label for="exampleInputEmail1">Email</label>
					    <input type="email" class="form-control" name="usuario" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Seu email">
					   
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">Senha</label>
					    <input type="password" name ="senha" class="form-control" id="exampleInputPassword1" placeholder="Senha">
					  </div>
					 
					  <button type="submit" class="btn btn-primary">Enviar</button>
				</form>							
			</div>
			
			<div class="col-md-4"></div>

		</div>
	</div>
