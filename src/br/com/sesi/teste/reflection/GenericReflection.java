package br.com.sesi.teste.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um reflex�o gen�rica
 * 
 * @author PEDRO HENRIQUE
 *
 * @param <T>
 *            Entidade que ser� construida na planilha Excel
 */
public class GenericReflection<T> {
	private Object reflection;
	private String classe;
	private Method metodo;

	public GenericReflection() {
	}

	public GenericReflection(T t) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		setClasse(t.toString().substring(0, t.toString().indexOf("@")));
		reflection = Class.forName(classe).newInstance();
	}

	/**
	 * 
	 * @return Todos os metodos da entidade gen�rica
	 */
	public Method[] listaMetodos() {
		return reflection.getClass().getMethods();
	}

	/**
	 * 
	 * @return Lista com todos os m�todos GETs da entidade gen�rica
	 */
	public List<String> listaGets() {
		Method[] m = listaMetodos();
		List<String> gets = new ArrayList<String>();

		for (int j = 0; j < m.length; j++) {
			if (m[j].getName().startsWith("get"))
				gets.add(m[j].getName());
			if (m[j].getName().startsWith("getClass"))
				gets.remove(gets.size() - 1);
		}

		return gets;
	}

	/**
	 * 
	 * @return Lista com todos os m�todos SETs da entidade gen�rica
	 */
	public List<String> listaSets() {
		Method[] m = listaMetodos();
		List<String> sets = new ArrayList<String>();

		for (int j = 0; j < m.length; j++) {
			if (m[j].getName().startsWith("set"))
				sets.add(m[j].getName());
		}
		return sets;
	}

	public Method[] getSets() {
		Method[] m = listaMetodos();

		int cont = 0;
		for (int j = 0; j < m.length; j++) {
			if (m[j].getName().startsWith("set"))
				cont++;
		}

		Method[] sets = new Method[cont];

		int k = 0;
		for (int j = k; j < m.length; j++) {
			if (m[j].getName().startsWith("set")) {
				sets[k] = (m[j]);
				k++;
			}
		}

		return sets;
	}

	/**
	 * Executa um m�todo Get
	 * 
	 * @param metodo
	 *            Nome do m�todo que ser� exceutado
	 * @param t
	 *            Entidade gen�rica que ter� um m�todo executado
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public void executaGet(String metodo, T t) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		this.metodo = reflection.getClass().getMethod(metodo, new Class[] {});
		this.metodo.invoke(t);
	}

	/**
	 * 
	 * @param metodo
	 *            Nome do m�todo que ser� exceutado
	 * @param t
	 *            Entidade gen�rica que ter� um m�todo executado
	 * @return Valor do m�todo que foi executado
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public String retornaGet(String metodo, T t) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.metodo = reflection.getClass().getMethod(metodo, new Class[] {});
		return String.valueOf(this.metodo.invoke(t));
	}

	public void executaSet(String metodo, Method m, T t, String param) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		switch (m.getParameterTypes()[0].toString()) {
		case "class java.lang.String":
			this.metodo = reflection.getClass().getMethod(metodo, new Class[] { String.class });
			this.metodo.invoke(t, param);
			break;
		case "int":
			this.metodo = reflection.getClass().getMethod(metodo, new Class[] { int.class });
			this.metodo.invoke(t, Integer.parseInt(param));
			break;
		}

	}

	public T devolve(T t) {
		return t;
	}

	public void executaSet(String metodo, Method m, T t, double param) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.metodo = reflection.getClass().getMethod(metodo, new Class[] { m.getParameterTypes().getClass() });
		this.metodo.invoke(t, param);
	}

	public void executaSet(String metodo, Method m, T t, int param) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.metodo = reflection.getClass().getMethod(metodo, new Class[] { m.getParameterTypes().getClass() });
		this.metodo.invoke(t, param);
	}

	public Object getReflection() {
		return reflection;
	}

	public void setReflection(Object reflection) {
		this.reflection = reflection;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public Method getMetodo() {
		return metodo;
	}

	public void setMetodo(Method metodo) {
		this.metodo = metodo;
	}
}
