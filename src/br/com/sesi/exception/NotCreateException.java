package br.com.sesi.exception;

/**
 * Representa a exce��o que ser� gerada se o programador n�o utilizar o m�todo
 * {@link br.com.sesi.excel.Create#create() create}
 * 
 * @author PEDRO HENRIQUE
 *
 * @see br.com.sesi.excel.Input#create() Implementa��o create no Input
 * 
 * @see br.com.sesi.excel.Input#create() Implementa��o create no Output
 */
@SuppressWarnings("serial")
public class NotCreateException extends Exception {
	public NotCreateException() {
		super("Os atributos da classe Output n�o foram instanciados, UTILIZE O M�TODO create() da classe Output.");
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
