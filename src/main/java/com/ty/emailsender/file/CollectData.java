package com.ty.emailsender.file;

import java.util.ArrayList;

public class CollectData {

	public static ArrayList<String> allData() {
		String excelPath = "C:\\Users\\User\\Pictures\\candid.xlsx";
		String sheet = "Sheet1";

		FileRead fileRead = new FileRead(excelPath, sheet);

		ArrayList<String> list = new ArrayList<String>();
//		while (!(fileRead.getCellData(i, 1).isBlank())) {
//			String email = fileRead.getCellData(i, 1);
//			System.out.println(email);
//			list.add(fileRead.getCellData(i, 1));
//		}

		for (int a = 1; a <= fileRead.getRow(); a++) {
			String email = fileRead.getCellData(a, 1);
			list.add(fileRead.getCellData(a, 1));
		}
		return list;
	}
}
