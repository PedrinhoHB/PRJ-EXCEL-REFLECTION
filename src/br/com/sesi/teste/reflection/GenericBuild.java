package br.com.sesi.teste.reflection;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import br.com.sesi.excel.Output;
import br.com.sesi.exception.NotCreateException;

/**
 * Representa uma interface de construção de uma planilha Excel
 * 
 * @author PEDRO HENRIQUE
 *
 * @param <T>
 *            Entidade que será construida na planilha Excel
 */
public interface GenericBuild<T> {
	void build(ArrayList<T> catalogos, Output oc)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IOException, NotCreateException;
}
