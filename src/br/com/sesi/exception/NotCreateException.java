package br.com.sesi.exception;

/**
 * Representa a exceção que será gerada se o programador não utilizar o método
 * {@link br.com.sesi.excel.Create#create() create}
 * 
 * @author PEDRO HENRIQUE
 *
 * @see br.com.sesi.excel.Input#create() Implementação create no Input
 * 
 * @see br.com.sesi.excel.Input#create() Implementação create no Output
 */
@SuppressWarnings("serial")
public class NotCreateException extends Exception {
	public NotCreateException() {
		super("Os atributos da classe Output não foram instanciados, UTILIZE O MÉTODO create() da classe Output.");
	}

	public NotCreateException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public NotCreateException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public NotCreateException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public NotCreateException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
}
