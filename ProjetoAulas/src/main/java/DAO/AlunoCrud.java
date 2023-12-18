package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import MODEL.Aluno;
import UTIL.Conexao;

public class AlunoCrud {
	Conexao conect = new Conexao();

	public void inserir(Aluno aluno) {

		try {
			String in = "INSERT INTO alunos(nome,telefone,email,datanasc,cpf,rg,cep,numero,complemento) VALUES (?,?,?,?,?,?,?,?,?)";

			Connection con = conect.createMYSQL();
			PreparedStatement pst = con.prepareStatement(in);

			pst.setString(1, aluno.getNome());
			pst.setString(2, aluno.getTelefone());
			pst.setString(3, aluno.getEmail());
			pst.setString(4, aluno.getDatanasc());
			pst.setString(5, aluno.getCpf());
			pst.setString(6, aluno.getRg());
			pst.setString(7, aluno.getCep());
		    pst.setString(8, aluno.getNumero());
			pst.setString(9, aluno.getComplemento());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}
	}

	public ArrayList<Aluno> listar() {
		ArrayList<Aluno> lista = new ArrayList<>();
		String list = "SELECT * FROM alunos";
		try {
			Connection con = conect.createMYSQL();
			PreparedStatement pst = con.prepareStatement(list);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String telefone = rs.getString(3);
				String email = rs.getString(4);
				String dataNasc = rs.getString(7);
				String cpf = rs.getString(6);
				String rg = rs.getString(5);
				String cep = rs.getString(8);
				String numero = rs.getString(9);
				String complemento = rs.getString(10);
				lista.add(new Aluno(id, nome, telefone, email, rg, cpf, dataNasc, cep, numero, complemento));

			}
			con.close();
			return lista;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public void selection(Aluno aluno) {
		
		String sel = " select*from alunos where idaluno = ?";

		try {
			Connection con = conect.createMYSQL();
			PreparedStatement pst = con.prepareStatement(sel);
			
			pst.setString(1, aluno.getIdaluno());
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				aluno.setIdaluno(rs.getString(1));
				aluno.setNome(rs.getString(2));
				aluno.setTelefone(rs.getString(3));
				aluno.setEmail(rs.getString(4));
				aluno.setDatanasc(rs.getString(5));
				aluno.setCpf(rs.getString(6));
				aluno.setRg(rs.getString(7));
				aluno.setCep(rs.getString(8));
				aluno.setNumero(rs.getString(9));
				aluno.setComplemento(rs.getString(10));

			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
//	INSERT INTO alunos(nome,telefone,email,datanasc,cpf,rg,cep,numero,complemento)
	public void editar(Aluno aluno) {
		String edit = "update alunos set nome = ? , telefone = ? , email =? , datanasc = ? , cpf = ? , rg = ? , cep = ? ,  numero = ? , complemento = ? where idaluno = ? ";

		try {
			Connection con = conect.createMYSQL();
			
			PreparedStatement pst = con.prepareStatement(edit);
			
			pst.setString(1, aluno.getNome());
			pst.setString(2, aluno.getTelefone());
			pst.setString(3, aluno.getEmail());
			pst.setString(4, aluno.getDatanasc());
			pst.setString(5, aluno.getCpf());
			pst.setString(6, aluno.getRg());
			pst.setString(7, aluno.getCep());
			pst.setString(8, aluno.getNumero());
			pst.setString(9, aluno.getComplemento());
			pst.setString(10, aluno.getIdaluno());

			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void Excluir(Aluno aluno) {
		String del = "delete from alunos where idaluno = ? ";
		try {
			Connection con = conect.createMYSQL();
			PreparedStatement pst = con.prepareStatement(del);
			pst.setString(1, aluno.getIdaluno());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
