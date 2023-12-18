<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
      body {
  font-family: Arial, sans-serif;
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
  margin: 0;
}

.formulario {
  max-width: 400px;
  width: 100%;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
}

label {
  display: block;
  margin-bottom: 8px;
}

input,
select {
  width: 100%;
  padding: 8px;
  margin-bottom: 16px;
  box-sizing: border-box;
}

button {
  background-color: #3498db;
  color: white;
  padding: 10px 15px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #2980b9;
}
      
</style>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="styles.css">
  <title>Formulário de Alteração</title>
</head>
<body>

  <form class="formulario" action="alt">
    <label for="nome">ID:</label>
    <input type="text" value="<%out.print(request.getAttribute("id"));%>" id="nome" name="id" readonly>
    
    <label for="nome">Novo Nome:</label>
    <input type="text" value="<%out.print(request.getAttribute("nome"));%>" id="nome" name="nome" required>

    <label for="cargaHoraria">Nova Carga Horária:</label>
    <input type="number" value="<%out.print(request.getAttribute("carga"));%>" id="cargaHoraria" name="carga" required>

    <label for="tipo">Novo Tipo:</label>
    <select id="tipo" name="tipo" required>
      <option value="integral">Integral</option>
      <option value="parcial">Parcial</option>
    </select>

    <button type="submit">Atualizar</button>
  </form>

</body>
</html>
