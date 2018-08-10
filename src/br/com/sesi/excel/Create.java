package br.com.sesi.excel;

import java.io.IOException;

/**
 * Representa a interface de instanciação dos atributos de {@link Input} e
 * {@link Output}
 * 
 * @author PEDRO HENRIQUE
 *
 */
public interface Create {
	/**
	 * Instancia os atributos das classe {@link Input} e {@link Output}
	 * 
	 * @throws IOException
	 */
	public void create() throws IOException;
}
