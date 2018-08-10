package br.com.sesi.excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Representa os dados que serão escritos em uma planilha Excel
 * 
 * @author PEDRO HENRIQUE
 *
 */
public final class Input extends Creation implements Create {
	private FileInputStream input;
	private int planilha;

	/**
	 * Implementação do método create na classe {@link Input}
	 */
	public void create() throws IOException {
		input = new FileInputStream(caminho + "/" + arquivo + ".xls");
		workbook = new HSSFWorkbook(input);
		sheet = workbook.getSheetAt(planilha);
	}

	public FileInputStream getInput() {
		return input;
	}

	public void setInput(FileInputStream input) {
		this.input = input;
	}

	public int getPlanilha() {
		return planilha;
	}

	public void setPlanilha(int planilha) {
		this.planilha = planilha;
	}
}
