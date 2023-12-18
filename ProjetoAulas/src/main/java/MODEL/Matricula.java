package MODEL;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Matricula {
	private String matriculaid;
	private String data;
	private String idaluno;
	private String idcurso;

	public Matricula(String matriculaid, String data, String idaluno, String idcurso) {
		super();
		this.matriculaid = matriculaid;
		this.data = data;
		this.idaluno = idaluno;
		this.idcurso = idcurso;
	}

	

	public String getMatriculaid() {
		return matriculaid;
	}



	public void setMatriculaid(String matriculaid) {
		this.matriculaid = matriculaid;
	}



	public Matricula() {
		super();

	}

	public String getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(String idcurso) {
		this.idcurso = idcurso;
	}

	public String getIdaluno() {
		return idaluno;
	}

	public void setIdaluno(String idaluno) {
		this.idaluno = idaluno;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public static String formatarData(String dataStr) {
	    SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy");

	    try {
	        Date data = (Date) formatoEntrada.parse(dataStr);
	        
	        return formatoSaida.format(data);
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return null;
	    }
	    }



}
