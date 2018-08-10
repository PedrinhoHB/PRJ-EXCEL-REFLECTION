package br.com.sesi.teste;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import br.com.sesi.excel.Output;
import br.com.sesi.exception.NotCreateException;
import br.com.sesi.teste.reflection.CatalogoBuild;
import br.com.sesi.to.Catalogo;

public class BuildTeste {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException,
			IOException, NotCreateException {
		Catalogo catalogo = new Catalogo();
		CatalogoBuild bo = new CatalogoBuild(catalogo);

		ArrayList<Catalogo> catalogos = new ArrayList<Catalogo>();
		catalogo = new Catalogo();
		catalogo.setCodigo(1);
		catalogo.setCurso("Analize e Desenvolvimento de Sistemas");
		catalogo.setObjetivo("Formar o aluno em programação avançada");
		catalogo.setProcesso("Tecnologo de 2 anos, 7 diciplinas");
		catalogos.add(catalogo);

		catalogo = new Catalogo();
		catalogo.setCodigo(2);
		catalogo.setCurso("Administração");
		catalogo.setObjetivo("Tornar o estudante capaz de administrar qualquer negócio");
		catalogo.setProcesso("Bacharel de 4 anos, 20 diciplinas");
		catalogos.add(catalogo);

		catalogo = new Catalogo();
		catalogo.setCodigo(3);
		catalogo.setCurso("Medicina");
		catalogo.setObjetivo("Tornar o estudante habil em medcina avançada");
		catalogo.setProcesso("Bacharel 5 anos,  30 diciplinas");
		catalogos.add(catalogo);

		Output oc = new Output();
		oc.setCaminho("C:/excel");
		oc.setArquivo("TesteReflection30");
		oc.setPlanilha("Planilhaa1");
		oc.create();

		bo.build(catalogos, oc);
	}
}
