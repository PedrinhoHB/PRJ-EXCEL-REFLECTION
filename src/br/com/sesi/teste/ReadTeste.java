package br.com.sesi.teste;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import br.com.sesi.excel.Input;
import br.com.sesi.teste.reflection.CatalogoRead;
import br.com.sesi.to.Catalogo;

public class ReadTeste {

	public static void main(String[] args)
			throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {

		Catalogo cat = new Catalogo();
		CatalogoRead r = new CatalogoRead(cat);

		Input ic = new Input();
		ic.setCaminho("C:/Users/ss1055158/Desktop/excel");
		ic.setArquivo("TesteReflection30");
		ic.setPlanilha(0);
		ic.create();

		for (Catalogo c : r.read(ic, cat)) {
			System.out.println(c.getCodigo());
		}
	}

}
