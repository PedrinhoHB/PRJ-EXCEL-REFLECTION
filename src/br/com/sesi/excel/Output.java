package br.com.sesi.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Representa os dados que serão retirados de uma planilha Excel
 * 
 * @author PEDRO HENRIQUE
 *
 */
public final class Output extends Creation implements Create {
	private FileOutputStream output;
	private String planilha;

	/**
	 * Implementação do método create na classe {@link Output}
	 */
	public void create() throws FileNotFoundException {
		output = new FileOutputStream(caminho + "/" + arquivo + ".xls");
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet(planilha);
	}

	/**
	 * Escreve os dados na planilha
	 * 
	 * @throws IOException
	 */
	public void write() throws IOException {
		getWorkbook().write(getOutput());
	}

	public FileOutputStream getOutput() {
		return output;
	}

	public void setOutput(FileOutputStream output) {
		this.output = output;
	}

	public String getPlanilha() {
		return planilha;
	}

	public void setPlanilha(String planilha) {
		this.planilha = planilha;
	}
}
