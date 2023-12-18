<%@page import="MODEL.Aluno"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


    
  
   <%@page import = "java.util.ArrayList"%>
   
    <!-- ALIMENTAR O OBJETO LISTA COM OS DADOS DA LISTA ALUNOS -->
    <%
    ArrayList<Aluno> listar = (ArrayList<Aluno>) request.getAttribute("dados");
	%>
    
    
    
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <!-- Meta tags Obrigatórias -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Relatório de Alunos</title>
  </head>
  <body>
    <div class="container-fluid" >
    	<div class="row">
    		<div class="col-md-12 text-center">
    		
    			<h3>Relatório de Alunos</h3>
    		</div>    	
    	</div> 
    	
    	<div class="row">
    	
			    	<table class="table table-dark">
			  <thead>
			    <tr>
			      <th scope="col">Código</th>
			      <th scope="col">Nome</th>
			      <th scope="col">Telefone</th>
			      <th scope="col">Email</th>
			      <th scope="col">Cpf</th>
			    </tr>
			  </thead>
			  <tbody><!-- PREENCHER COM DADOS DA CLASSE/TABELA -->
			  	
			  	<tr>
			  	<%for(int i = 0 ; i<listar.size() ; i++){%>
			  	
			      <td><%=listar.get(i).getIdaluno()%></td>			      
			      <td><%=listar.get(i).getNome()%></td>
			      <td><%=listar.get(i).getTelefone()%></td>
			      <td><%=listar.get(i).getEmail()%></td>
			      <td><%=listar.get(i).getCpf()%></td>	
			     
			      <td><a href="select?idcon=<%=listar.get(i).getIdaluno()%>">
			      <button type="button" class="btn btn-primary">Editar</button></a></td>
			      	
			      <td><a href="index.jsp">
			      <button type="button" class="btn btn-primary">Inicio</button></a></td>
			      	
			      
			     <td><a href="Excluir?id=<%=listar.get(i).getIdaluno()%>>"><button type="button" class="btn btn-danger">Excluir</button></a></td>		      	      
			    </tr>
			    <%}%>
			    
			   
			  </tbody>
			</table>
			    	
    </div>	
    	   
    </div>
    
    
    
    
    
    

    <!-- JavaScript (Opcional) -->
    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>