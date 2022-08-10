package com.ty.emailsender.file;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileRead {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public FileRead(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getCellData(int row, int column) {
		DataFormatter dataFormatter = new DataFormatter();
		return dataFormatter.formatCellValue(sheet.getRow(row).getCell(column));
	}

	public static int getRow() {
		return sheet.getLastRowNum();
	}
}
