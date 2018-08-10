package br.com.sesi.excel;

import java.util.ArrayList;

/**
 * Configura os valores retornados pelas células do Excel.
 * 
 * @author PEDRO HENRIQUE
 *
 */
public class CellConfig {
	/**
	 * Executa os métodos {@link #enterToString(String)} e
	 * {@link #stringToList(String)}.
	 * 
	 * @param texto
	 *            Texto para execução.
	 * @return Lista de textos.
	 * @author PEDRO HENRIQUE
	 */
	public ArrayList<String> enterToLista(String texto) {
		return stringToList(enterToString(texto));
	}

	/**
	 * Executa os métodos {@link #enterToString(String, String)} e
	 * {@link #stringToList(String)}.
	 * 
	 * @param texto
	 *            Texto para execução
	 * @param separador
	 *            Texto ou caractér para utilizar como separador
	 * @return Lista de textos
	 */
	public ArrayList<String> enterToLista(String texto, String separador) {
		return stringToList(enterToString(texto, separador));
	}

	/**
	 * Transforma o texto vindo de uma celula do excel em uma String sem quebra de
	 * linha. O método também insere um ponto e vírgula no lugar da quebra de linha.
	 * 
	 * @param texto
	 *            Texto com quebra de linha.
	 * @return Texto sem quebra de linha.
	 * @author PEDRO HENRIQUE
	 */
	private String enterToString(String texto) {
		char[] sequencia = texto.toCharArray();
		String novo = "";
		for (int i = 0; i < texto.length(); i++) {
			if ((int) sequencia[i] != 10)// Se NÃO possuir ENTER
				novo += "" + sequencia[i];
			else // Se possuir ENTER
				novo += ";";
		}

		return novo;
	}

	/**
	 * Transforma o texto vindo de uma celula do excel em uma String sem quebra de
	 * linha. O método também insere um separador no lugar da quebra de linha.
	 * 
	 * @param texto
	 *            Texto para execução
	 * @param separador
	 *            Texto ou caractér para utilizar como separador
	 * @return Texto sem quebra de linha
	 * @author PEDRO HENRIQUE
	 */
	public String enterToString(String texto, String separador) {
		char[] sequencia = texto.toCharArray();
		String novo = "";
		for (int i = 0; i < texto.length(); i++) {
			if ((int) sequencia[i] != 10)// Se NÃO possuir ENTER
				novo += "" + sequencia[i];
			else // Se possuir ENTER
				novo += separador;
		}

		return novo;
	}

	/**
	 * Transforma um texto em uma lista de textos. O método utiliza como referência
	 * o ponto e virgula para separar os textos. O método utiliza o método
	 * {@link #format(String)}.
	 * 
	 * @param texto
	 *            Texto para execução.
	 * @return Lista de textos.
	 * @author PEDRO HENRIQUE
	 */
	private ArrayList<String> stringToList(String texto) {
		ArrayList<String> lista = new ArrayList<String>();

		int cont = 0;
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) == ';') {
				lista.add(texto.substring(cont, i + 1));
				cont = i;
			}
		}

		lista.add(texto.substring(cont, texto.length()));

		return lista;
	}

	/**
	 * Transforma um texto em uma lista de textos. O método utiliza uma referência
	 * para separar os textos. O método utiliza o método {@link #format(String)}.
	 * 
	 * @param texto
	 *            Texto para execução.
	 * @param ref
	 *            Referência para separar os textos.
	 * @return Lista de Textos
	 */
	public ArrayList<String> stringToList(String texto, char ref) {
		ArrayList<String> lista = new ArrayList<String>();

		int cont = 0;
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) == ref) {
				lista.add(format(texto.substring(cont, i)));
				cont = i;
			}
		}

		return lista;
	}

	/**
	 * Formata um texto de acordo com a Regra de Negócio
	 * 
	 * @param texto
	 *            Texto para formatação.
	 * @return Texto formatado.
	 * @author PEDRO HENRIQUE
	 */
	private String format(String texto) {
		return texto.replace(";", "").trim();
	}

	/*
	 * public ArrayList<String> listCelula(String texto2) { // Cria lista
	 * ArrayList<String> lista = new ArrayList<String>();
	 * 
	 * // Transforma o texto vindo de uma celula do excel em uma String sem ENTER
	 * String texto = texto2; char[] sequencia = texto.toCharArray(); String novo =
	 * ""; for (int i = 0; i < texto.length(); i++) { if ((int) sequencia[i] !=
	 * 10)// Se NÃO possuir ENTER novo += "" + sequencia[i]; else // Se possuir
	 * ENTER novo += ";"; }
	 * 
	 * System.out.println(novo);
	 * 
	 * // Transforma a String em uma lista de palavras int cont = 0; for (int i = 0;
	 * i < novo.length(); i++) { if (novo.charAt(i) == ';') {
	 * lista.add(novo.substring(cont, i).replace(";", "").trim()); cont = i; } }
	 * 
	 * if (!texto.endsWith(";")) lista.add(novo.substring(cont,
	 * novo.length()).replace(";", "").trim());
	 * 
	 * return lista; }
	 */
}
