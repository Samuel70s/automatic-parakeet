package DAO;

import UTIL.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import MODEL.Matricula;

public class CrudMatricula {
	Conexao conn = new Conexao();

	public void Salvar(Matricula matricula) {
		String in = "insert into matricular (data , idaluno , idcurso) values (?, ? , ?)";
		try {
			Connection con = conn.createMYSQL();
			PreparedStatement pst = con.prepareStatement(in);
			pst.setString(1, matricula.getData());
			pst.setString(2, matricula.getIdaluno());
			pst.setString(3, matricula.getIdcurso());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<Matricula> listar() {
		String li = "select * from matricular";
		ArrayList<Matricula> lista = new ArrayList<>();

		try {
			Connection con = conn.createMYSQL();
			PreparedStatement pst = con.prepareStatement(li);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idmatricula = rs.getString(1);
				String data = rs.getString(2);
				String idaluno = rs.getString(3);
				String idcurso = rs.getString(4);

				lista.add(new Matricula(idmatricula, data, idaluno, idcurso));

			}
			con.close();
			return lista;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void selection(Matricula matricula) {
		String sel = "select * from matricular where matricula = ?";
		try {
			Connection con = conn.createMYSQL();
			PreparedStatement pst = con.prepareStatement(sel);
			pst.setString(1, matricula.getMatriculaid());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				matricula.setMatriculaid(rs.getString(1));
				matricula.setData(rs.getString(2));				
				matricula.setIdaluno(rs.getString(3));
				matricula.setIdcurso(rs.getString(4));

			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void Editar(Matricula matricula) {
		String update = "update matricular set data = ? where matricula=?";
		try {
			Connection con = conn.createMYSQL();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, matricula.getData());
			pst.setString(2, matricula.getMatriculaid());
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}


public void ExcluirMatricula(Matricula matricula) {
      String ex =  "delete from matricular where matricula = ?";

	try {
		Connection con = conn.createMYSQL();
		PreparedStatement pst = con.prepareStatement(ex);
		pst.setString(1, matricula.getMatriculaid());
		pst.executeUpdate();
		con.close();;
	} catch (Exception e) {
		System.out.println(e);
		
	}
}

}