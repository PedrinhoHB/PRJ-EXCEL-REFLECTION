package br.com.sesi.teste.reflection;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import br.com.sesi.excel.Input;

public interface GenericRead<T> {
	List<T> read(Input ic, T t) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException;
}
