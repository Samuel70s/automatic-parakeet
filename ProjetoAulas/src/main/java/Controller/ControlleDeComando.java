package Controller;

import java.io.IOException;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AlunoCrud;
import DAO.CrudMatricula;
import DAO.CursoCrud;
import DAO.LoginCrud;
import MODEL.Aluno;
import MODEL.Curso;
import MODEL.Matricula;
import MODEL.login;

@WebServlet(urlPatterns = { "/ControlleDeComando", "/alunonovo", "/main3", "/select", "/editar", "/Excluir", "/main5",
		"/add", "/edit", "/excluir", "/login", "/logon", "/mat", "/matriculatab", "/selecionar", "/matricular",
		"/aluno", "/alterar", "/ExcluirMatricula", "/cadastro" })
public class ControlleDeComando extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControlleDeComando() {
		super();

	}

	Aluno aluno = new Aluno();
	AlunoCrud alunoc = new AlunoCrud();
	Curso curso = new Curso();
	CursoCrud crud = new CursoCrud();
	login log = new login();
	LoginCrud logc = new LoginCrud();
	CrudMatricula daomatr = new CrudMatricula();
	Matricula matr = new Matricula();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/alunonovo")) {
			AddAluno(request, response);
		}

		else if (action.equals("/aluno")) {
			Listar(request, response);
		} else if (action.equals("/select")) {
			selection(request, response);
		} else if (action.equals("/editar")) {
			editar(request, response);
		} else if (action.equals("/Excluir")) {
			Excluir(request, response);
		}

		// Cursos

		else if (action.equals("/add")) {
			AddCurso(request, response);
		}

		else if (action.equals("/main5")) {
			ListarCurso(request, response);
		} else if (action.equals("/editar")) {
			EditarCurso(request, response);
		} else if (action.equals("/edit")) {
			SelecionarCurso(request, response);
		} else if (action.equals("/excluir")) {
			ExcluirCurso(request, response);
		}

		// MATRICULA
		else if (action.equals("/matricular")) {
			ADDMatricula(request, response);
		} else if (action.equals("/mat")) {
			ListarAlunosMatricula(request, response);
		}

		else if (action.equals("/selecionar")) {
			SelecionarMatricula(request, response);
		} else if (action.equals("/matriculatab")) {
			ListarMatricula(request, response);
		} else if (action.equals("/matriculatab")) {
			ListarMatricula(request, response);
		} else if (action.equals("/alterar")) {
			EditarMatricula(request, response);
		} else if (action.equals("/ExcluirMatricula")) {
			ExcluirMatricula(request, response);
		}

		// LOGIN
		else if (action.equals("/login")) {
			ValidaLogin(request, response);
		} else if (action.equals("/cadastro")) {

			CadastrarLogin(request, response);

		} else if (action.equals("/login")) {
			ValidaLogin(request, response);
		} else if (action.equals("/logon")) {
			Sair(request, response);
		}

	}

	// VALIDAÇÃO
	protected void ValidaLogin(HttpServletRequest request, HttpServletResponse response) {
		try {

			System.out.println(request.getParameter("usuario"));

			System.out.println(request.getParameter("senha"));
			log.setEmail(request.getParameter("usuario"));
			log.setSenha(request.getParameter("senha"));

			logc.valid(log);
			ResultSet rs = logc.valid(log);
			if (rs.next()) {
				response.sendRedirect("index.jsp");

			} else {
				response.sendRedirect("Login.jsp");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void CadastrarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("usuario"));
		System.out.println(request.getParameter("senha"));

		log.setCadastroEmail(request.getParameter("usuario"));
		log.setCadastroSenha(request.getParameter("senha"));

		logc.Cadastro(log);
		response.sendRedirect("Login.jsp");

	}

	// LOOGAUT
	protected void Sair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.setEmail(null);
		log.setSenha(null);
		response.sendRedirect("Login.jsp");

	}

	protected void Cadastrar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println();

	}

	protected void AddAluno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("telefone"));
		System.out.println(request.getParameter("datanasc"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("cpf"));
		System.out.println(request.getParameter("rg"));
		System.out.println(request.getParameter("cep"));
		System.out.println(request.getParameter("numero"));
		System.out.println(request.getParameter("complemento"));

		aluno.setNome(request.getParameter("nome"));
		aluno.setTelefone(request.getParameter("telefone"));
		aluno.setEmail(request.getParameter("email"));
		aluno.setCpf(request.getParameter("cpf"));
		aluno.setRg(request.getParameter("rg"));
		aluno.setCep(request.getParameter("cep"));
		aluno.setNumero(request.getParameter("numero"));
		aluno.setComplemento(request.getParameter("complemento"));
		aluno.setDatanasc(request.getParameter("datanasc"));
		alunoc.inserir(aluno);
		response.sendRedirect("AcessoTabelas.html");
	}

	protected void Listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (log.getEmail() == null) {
			response.sendRedirect("Login.jsp");
		}

		else {

			ArrayList<Aluno> list = alunoc.listar();

			request.setAttribute("dados", list);
			RequestDispatcher rd = request.getRequestDispatcher("RelAluno.jsp");
			rd.forward(request, response);

			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getIdaluno());
				System.out.println(list.get(i).getNome());
				System.out.println(list.get(i).getTelefone());
				System.out.println(list.get(i).getEmail());
				System.out.println(list.get(i).getCpf());
				System.out.println(list.get(i).getRg());
				System.out.println(list.get(i).getCep());
				System.out.println(list.get(i).getNumero());
				System.out.println(list.get(i).getComplemento());

			}

		}

	}

	protected void selection(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("idcon");
		System.out.println(id);

		aluno.setIdaluno(id);

		alunoc.selection(aluno);

		System.out.println(aluno.getNome());

		System.out.println(aluno.getTelefone());

		System.out.println(aluno.getEmail());

		System.out.println(aluno.getDatanasc());

		System.out.println(aluno.getCpf());

		System.out.println(aluno.getRg());

		System.out.println(aluno.getCep());

		System.out.println(aluno.getNumero());

		System.out.println(aluno.getComplemento());

		request.setAttribute("id", aluno.getIdaluno());

		request.setAttribute("nome", aluno.getNome());

		request.setAttribute("telefone", aluno.getTelefone());

		request.setAttribute("email", aluno.getEmail());

		request.setAttribute("data", aluno.getDatanasc());

		request.setAttribute("cpf", aluno.getCpf());

		request.setAttribute("rg", aluno.getRg());

		request.setAttribute("cep", aluno.getCep());

		request.setAttribute("numero", aluno.getNumero());

		request.setAttribute("complemento", aluno.getComplemento());

		RequestDispatcher rd = request.getRequestDispatcher("EditaAluno.jsp");
		rd.forward(request, response);

	}

	protected void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		aluno.setNome(request.getParameter("nome"));
		aluno.setTelefone(request.getParameter("telefone"));
		aluno.setEmail(request.getParameter("email"));
		aluno.setDatanasc(request.getParameter("data"));
		aluno.setCpf(request.getParameter("cpf"));
		aluno.setRg(request.getParameter("rg"));
		aluno.setCep(request.getParameter("cep"));
		aluno.setNumero(request.getParameter("numero"));
		aluno.setComplemento(request.getParameter("complemento"));

		alunoc.editar(aluno);
		response.sendRedirect("main3");

	}

	protected void Excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		aluno.setIdaluno(id);
		alunoc.Excluir(aluno);
		response.sendRedirect("main3");
	}

	/** Parte dos Cursos */

	protected void AddCurso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("carga"));
		System.out.println(request.getParameter("tipo"));

		curso.setNome(request.getParameter("nome"));
		curso.setCargaHoraria(request.getParameter("carga"));
		curso.setTipo(request.getParameter("tipo"));
		crud.inseriCurso(curso);
		response.sendRedirect("index.jsp");

	}

	protected void ListarCurso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (log.getEmail() == null) {
			response.sendRedirect("Login.jsp");
		}

		else {

			ArrayList<Curso> listar = crud.listar();
			request.setAttribute("cursos", listar);
			RequestDispatcher rd = request.getRequestDispatcher("TabelaCurso.jsp");
			rd.forward(request, response);

			for (int i = 0; i < listar.size(); i++) {

				System.out.println(listar.get(i).getId());
				System.out.println(listar.get(i).getNome());
				System.out.println(listar.get(i).getCargaHoraria());
				System.out.println(listar.get(i).getTipo());
			}
		}
	}

	protected void SelecionarCurso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println(id);
		curso.setId(id);

		crud.select(curso);

		// TESTE RECEBIMENTO
		System.out.println(curso.getId());
		System.out.println(curso.getNome());
		System.out.println(curso.getCargaHoraria());
		System.out.println(curso.getTipo());

		request.setAttribute("id", curso.getId());
		request.setAttribute("nome", curso.getNome());
		request.setAttribute("carga", curso.getCargaHoraria());
		request.setAttribute("tipo", curso.getTipo());

		RequestDispatcher rd = request.getRequestDispatcher("CursoAlt.jsp");
		rd.forward(request, response);

	}

	protected void EditarCurso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		curso.setId(request.getParameter("id"));
		curso.setNome(request.getParameter("nome"));
		curso.setCargaHoraria(request.getParameter("carga"));
		curso.setTipo(request.getParameter("tipo"));
		crud.edite(curso);
		response.sendRedirect("main5");
	}

	protected void ExcluirCurso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		curso.setId(id);
		crud.Excluir(curso);
		response.sendRedirect("main5");

	}

	/** AREA DE MATRICULAS */

	protected void ListarAlunosMatricula(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (log.getEmail() == null) {
			response.sendRedirect("Login.jsp");
		}

		else {

			// CURSO
			ArrayList<Curso> listar = crud.listar();
			request.setAttribute("cursosMatricula", listar);

			for (int i = 0; i < listar.size(); i++) {
				System.out.println(listar.get(i).getId());
				System.out.println(listar.get(i).getNome());
				System.out.println(listar.get(i).getCargaHoraria());
				System.out.println(listar.get(i).getTipo());
			}

			// ALUNO

			ArrayList<Aluno> list = alunoc.listar();
			request.setAttribute("dadosMatricula", list);
			RequestDispatcher rd = request.getRequestDispatcher("CadMatricula.jsp");
			rd.forward(request, response);

			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getIdaluno());
				System.out.println(list.get(i).getNome());
				System.out.println(list.get(i).getTelefone());
				System.out.println(list.get(i).getEmail());
				System.out.println(list.get(i).getCpf());
				System.out.println(list.get(i).getRg());
				System.out.println(list.get(i).getCep());
				System.out.println(list.get(i).getNumero());
				System.out.println(list.get(i).getComplemento());

			}

		}

	}

	protected void ADDMatricula(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("aluno"));
		System.out.println(request.getParameter("curso"));
		System.out.println(request.getParameter("data"));

		matr.setIdaluno(request.getParameter("aluno"));
		matr.setIdcurso(request.getParameter("curso"));
		matr.setData(request.getParameter("data"));
		daomatr.Salvar(matr);
		response.sendRedirect("index.jsp");
	}

	protected void ListarMatricula(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Matricula> listar = daomatr.listar();
		request.setAttribute("matriculas", listar);

		RequestDispatcher rd = request.getRequestDispatcher("TabelaMatricula.jsp");
		rd.forward(request, response);

		for (int i = 0; i < listar.size(); i++) {
			System.out.println(listar.get(i).getMatriculaid());
			System.out.println(listar.get(i).getData());
			System.out.println(listar.get(i).getIdaluno());
			System.out.println(listar.get(i).getIdcurso());
		}
	}

	protected void SelecionarMatricula(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		matr.setMatriculaid(id);

		daomatr.selection(matr);

		System.out.println(matr.getData());

		request.setAttribute("data", matr.getData());

		RequestDispatcher rd = request.getRequestDispatcher("AlteracaoMatricula.jsp");
		rd.forward(request, response);

	}

	protected void EditarMatricula(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("dataMatricula"));
		matr.setData(request.getParameter("dataMatricula"));
		daomatr.Editar(matr);
		response.sendRedirect("matriculatab");

	}

	protected void ExcluirMatricula(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		matr.setMatriculaid(id);
		daomatr.ExcluirMatricula(matr);
		response.sendRedirect("matriculatab");
		;

	}

}
