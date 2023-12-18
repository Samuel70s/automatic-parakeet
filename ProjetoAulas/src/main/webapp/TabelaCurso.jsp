<%@page import="MODEL.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <%  --%>
<!-- //     HttpSession secao = request.getSession(false);  -->
    
<!-- //     request.getSession().getAttribute("usuario");  -->
    
<!-- //      Object usu = secao.getAttribute("usuario");  -->
    
<!-- //      if(usu==null) {  -->
<!-- //   	response.sendRedirect("Login.jsp");  -->
<!-- //      }  -->
    
<!-- //      else {  -->
<!-- //      	response.sendRedirect("index.jsp");  -->

//     } 
<%--   %>  --%>

    <%ArrayList<Curso> lista = (ArrayList<Curso>) request.getAttribute("cursos"); %>
    <style>
    body {
  font-family: Arial, sans-serif;
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
  margin: 0;
}

.tabela {
  border-collapse: collapse;
  width: 100%;
  margin-top: 20px;
}

.tabela th, .tabela td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

.tabela th {
  background-color: #3498db;
  color: white;
}

.tabela tr:nth-child(even) {
  background-color: #f2f2f2;
}

.tabela tr:hover {
  background-color: #e5e5e5;
}

.editar, .excluir {
  padding: 5px 10px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.editar {
  background-color: #3498db;
  color: white;
}

.editar:hover {
  background-color: #2980b9;
}

.excluir {
  background-color: #e74c3c;
  color: white;
}

.excluir:hover {
  background-color: #c0392b;
}
    
    
    
</style>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="styles.css">
  <title>Tabela de Dados</title>
</head>
<body>
<a href="index.jsp" class="botao1">Retornar a Tela incial</a>
	
  <table class="tabela">
    <thead>
      <tr>
        <th>id</th>
        <th>Nome</th>
        <th>Carga Horária</th>
        <th>Tipo</th>
        <th>Ações</th>
      </tr>
    </thead>
    <tbody>
      <tr>
      <%for(int i=0 ;i<lista.size();i++){%>
      
        <td><%=lista.get(i).getId()%></td>
        <td><%=lista.get(i).getNome()%></td>
        <td><%=lista.get(i).getCargaHoraria()%></td>
        <td><%=lista.get(i).getTipo()%></td>
        
        <td>
          <button class="editar"> <a href="edit?id=<%=lista.get(i).getId()%>">Editar</a></button>
          <button class="excluir"> <a href="excluir?id=<%=lista.get(i).getId()%>">Excluir</a></button>
          <button class="editar"> <a href="index.jsp">Inicio</a></button>
    
        </td>
      </tr>
      <%}%>
      <!-- Adicione mais linhas conforme necessário -->
    </tbody>
  </table>

</body>
</html>
