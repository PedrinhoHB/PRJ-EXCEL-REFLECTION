package br.com.sesi.teste.reflection;

import br.com.sesi.to.Catalogo;

public class CatalogoBuild extends GenericBuildImpl<Catalogo> implements GenericBuild<Catalogo> {
	public CatalogoBuild(Catalogo t) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		super(t);
	}
}
