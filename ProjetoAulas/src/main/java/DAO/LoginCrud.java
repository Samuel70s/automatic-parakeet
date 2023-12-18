package DAO;
import UTIL.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import MODEL.login;

public class LoginCrud {
	Conexao conect = new Conexao();
	
//VALIDAÇÃO DE EMAIL E SENHA
	public ResultSet valid(login log) {
		String va = "select * from login where email =? and senha =?";

		try {
			Connection con = conect.createMYSQL();
			PreparedStatement pst = con.prepareStatement(va);
			pst.setString(1, log.getEmail());
			pst.setString(2, log.getSenha());
			ResultSet rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			System.out.println(e);
			return null;
			
		}
	}
	
	
	public void Cadastro(login log) {
		
		String in = "insert into login (email , senha) values (?, ?)";
		try {
			Connection con = conect.createMYSQL();
		    PreparedStatement pst = con.prepareStatement(in);
		    pst.setString(1, log.getCadastroEmail());
		    
		    pst.setString(2, log.getCadastroSenha());
		     pst.executeUpdate();
		     con.close();
		    
		
		} catch (Exception e) {
		    System.out.println(e);
		}
	}
}
