package br.com.sesi.teste.reflection;

import br.com.sesi.to.Catalogo;

public class CatalogoRead extends GenericReadImpl<Catalogo> implements GenericRead<Catalogo> {
	public CatalogoRead(Catalogo cat) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		super(cat);
	}
}
