<%@page import="MODEL.Matricula"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
         ArrayList<Matricula> lista = (ArrayList<Matricula>) request.getAttribute("matriculas");
    
    
    
    %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    body {
      font-family: Arial, sans-serif;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }

    th, td {
      border: 1px solid #ddd;
      padding: 8px;
      text-align: left;
    }

    th {
      background-color: #f2f2f2;
    }

    .edit-btn, .delete-btn {
      padding: 5px 10px;
      margin-right: 5px;
      cursor: pointer;
    }

    .edit-btn {
      background-color: #4CAF50;
      color: white;
      border: none;
    }

    .delete-btn {
      background-color: #f44336;
      color: white;
      border: none;
    }
  </style>
</head>
<body>

  <table>
    <thead>
      <tr>
        <th>ID Matricula</th>
        <th>Data da Matrícula</th>
        <th>ID Aluno</th>
        <th>ID Curso</th>
        <th>Ações</th>
      </tr>
    </thead>
    <tbody>
      <tr>
      <%for(int i = 0 ; i<lista.size() ; i++){ %>
        <td><%=lista.get(i).getMatriculaid() %></td>
        <td><%=Matricula.formatarData(lista.get(i).getData())%></td>
        <td><%=lista.get(i).getIdaluno()%></td>
        <td><%=lista.get(i).getIdcurso()%></td>
        <td>
          <button class="edit-btn"><a href="selecionar?id=<%=lista.get(i).getMatriculaid()%>">Editar</a></button>
          <button class="delete-btn"><a href="ExcluirMatricula?id=<%=lista.get(i).getMatriculaid()%>">Excluir</a></button>
          <button class="edit-btn"><a href="index.jsp">Inicio</a></button>
        </td>
        
          </tr>
        <%}%>
    </tbody>
  </table>

</body>
</html>
