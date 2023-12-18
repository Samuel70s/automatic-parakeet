package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import UTIL.Conexao;
import MODEL.Curso;

public class CursoCrud {
	Conexao conect = new Conexao();

	public void inseriCurso(Curso curso) {
		String in = "insert into curso (nome , cargahoraria ,tipocurso) values (? , ? , ?);";
		try {
			Connection con = conect.createMYSQL();
			PreparedStatement pst = con.prepareStatement(in);
			pst.setString(1, curso.getNome());
			pst.setString(2, curso.getCargaHoraria());
			pst.setString(3, curso.getTipo());

			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public ArrayList<Curso> listar() {
		
		String li = "select*from curso";
		ArrayList<Curso> curso = new ArrayList<Curso>();

		
		try {
			Connection con = conect.createMYSQL();
			PreparedStatement pst = con.prepareStatement(li);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String carga = rs.getString(3);
				String tipo = rs.getString(4);
				curso.add(new Curso(id, nome, carga, tipo));

			}
			
			con.close();
			return curso;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void select(Curso curso) {
		

		String sel =  "select*from curso where idcurso = ?";

		try {

			Connection con = conect.createMYSQL();
			PreparedStatement pst = con.prepareStatement(sel);
			
			pst.setString(1, curso.getId());
			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				curso.setId(rs.getString(1));
				curso.setNome(rs.getString(2));
				curso.setCargaHoraria(rs.getString(3));
				curso.setTipo(rs.getString(4));

			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}
	}

	public void edite(Curso curso) {
		String edit = " update curso set nome = ? ,  cargahoraria = ? , tipocurso = ? where  idcurso = ?";
		try {
			Connection con = conect.createMYSQL();
			PreparedStatement pst = con.prepareStatement(edit);
			pst.setString(1, curso.getNome());
			pst.setString(2, curso.getCargaHoraria());
			pst.setString(3, curso.getTipo());
			pst.setString(4, curso.getId());
			
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void Excluir(Curso curso) {
		String ex = "delete from  curso where idcurso = ?";
		try {
			Connection con = conect.createMYSQL();
			PreparedStatement pst = con.prepareStatement(ex);
			pst.setString(1, curso.getId());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
