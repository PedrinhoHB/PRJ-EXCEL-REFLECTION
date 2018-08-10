package br.com.sesi.teste.reflection;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import br.com.sesi.excel.Output;
import br.com.sesi.exception.NotCreateException;

/**
 * Representa uma implementa��o gen�rica de constru��o de uma planilha Excel
 * 
 * @author PEDRO HENRIQUE
 *
 * @param <T>
 *            Entidade que ser� construida na planilha Excel
 */
public class GenericBuildImpl<T> extends GenericReflection<T> implements GenericBuild<T> {

	public GenericBuildImpl() {
	}

	public GenericBuildImpl(T t) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		super(t);
	}

	/**
	 * Constr�i uma planilha com os dados
	 * 
	 * @param lista
	 *            Lista de entidades gen�ricas
	 * @param oc
	 *            Objeto Output
	 */
	public void build(ArrayList<T> lista, Output oc)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IOException, NotCreateException {

		if (oc.getWorkbook() == null && oc.getSheet() == null && oc.getOutput() == null)
			throw new NotCreateException();

		int cont = 0;
		for (int i = 0; i < lista.size(); i++) {
			oc.setRow(oc.getSheet().createRow(cont));

			// Invoca os m�todos da lista de GETS dentro de uma c�lula do excel
			for (int j = 0; j < listaGets().size(); j++) {
				oc.setCell(oc.getRow().createCell(j));
				oc.getCell().setCellValue(retornaGet(listaGets().get(j), lista.get(i)));
			}
			cont++;
		}

		System.out.println("Arquivo excel gerado com sucesso!");

		oc.write();
		oc.getWorkbook().close();
	}
}