package br.com.sesi.teste.reflection;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import br.com.sesi.excel.Input;
import br.com.sesi.to.Catalogo;

public class GenericReadImpl<T> extends GenericReflection<T> implements GenericRead<T> {
	public GenericReadImpl() {
	}

	public GenericReadImpl(T t) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		super(t);
	}

	@SuppressWarnings("unchecked")
	public List<T> read(Input ic, T t)
			throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {
		List<T> lista = new ArrayList<T>();
		Iterator<Row> rowIterator = ic.getSheet().iterator();
		int valida = 0; // Para validar se o método foi executado

		while (rowIterator.hasNext()) {
			ic.setRow(rowIterator.next());
			Iterator<Cell> cellIterator = ic.getRow().cellIterator();

			// Instanciar a classe desejada
			t = (T) new Catalogo();

			lista.add(t);
			int contaSet = 0; // Conta quantos sets da classe já foram usados

			while (cellIterator.hasNext()) {
				ic.setCell(cellIterator.next());
				valida = 0;

				for (int i = contaSet; i < getSets().length; i++) {
					if (valida == 0) {
						executaSet(listaSets().get(i), getSets()[contaSet], t, ic.getCell().getStringCellValue());
						valida = 1;
					}
				}
				contaSet++;
			}

			ic.getWorkbook().close();
		}
		return lista;
	}
}
