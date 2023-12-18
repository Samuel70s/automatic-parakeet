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
  background-color: #4caf50;
  color: white;
  padding: 10px 15px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #45a049;
}
      
</style>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="styles.css">
  <title>Formulário</title>
</head>
<body>

  <form class="formulario" action="add">
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required>

    <label for="cargaHoraria">Carga Horária:</label>
    <input type="number" id="cargaHoraria" name="carga" required>

    <label for="tipo">Tipo:</label>
    <select id="tipo" name="tipo" required>
      <option value="integral">Integral</option>
      <option value="parcial">Parcial</option>
    </select>

    <button type="submit">Enviar</button>
  </form>

</body>
</html>
