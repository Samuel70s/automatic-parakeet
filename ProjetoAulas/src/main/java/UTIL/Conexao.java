package UTIL;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	//VARIAVEL DO DRIVE
			private static final String drive = "com.mysql.cj.jdbc.Driver";

		//Caminho do banco de dados
			private static final String url = "jdbc:mysql://127.0.0.1:3306/escola?useTimezone=true&serverTimezone=UTC";

		//Nome do usuario do banco do dados
			private static final String usuario = "root";

		//Senha do Banco de dados
			private static final String senha = "4338464@$Sa";

public static Connection createMYSQL() throws Exception {
	Class.forName(drive);
	Connection con = DriverManager.getConnection(url, usuario, senha);
	return con;
} 

public static void main(String[] args) throws Exception {
	Connection con = createMYSQL();
	if(con!=null) {
		System.out.println("CONEXAO JA ESTABELACIDA");
		con.close();
	}
}
public void testeconexao() {
	try {
		Connection con = createMYSQL();
		System.out.println(con);
	} catch (Exception e) {
		System.out.println(e);
	}
}

}
