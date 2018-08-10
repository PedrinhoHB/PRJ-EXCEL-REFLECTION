package br.com.sesi.to;

/**
 * Representa a entidade Catalogo de uma planilha no arquivo do Excel.
 * 
 * @author PEDRO HENRIQUE
 *
 */
public class Catalogo {
	private int codigo;
	private String processo;
	private String curso;
	private String objetivo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
}
