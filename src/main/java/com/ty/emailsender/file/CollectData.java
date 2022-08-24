package com.ty.emailsender.file;

import java.util.ArrayList;

public class CollectData {

	public static ArrayList<String> allData() {
		String excelPath = "C:\\Users\\User\\Documents\\Zoom\\hello.xlsx";
		String sheet = "Sheet1";
		ArrayList<String> list = new ArrayList<String>();

//		try {
//			FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\User\\Documents\\hi.xlsx");
		FileRead fileRead = new FileRead(excelPath, sheet);

//			while (!(fileRead.getCellData(i, 1).isBlank())) {
//				String email = fileRead.getCellData(i, 1);
//				System.out.println(email);
//				list.add(fileRead.getCellData(i, 1));
//			}

		for (int a = 1; a <= fileRead.getRow(); a++) {
//				if(fileRead.getCellData(a, 2)==null) {
//					
			list.add(fileRead.getCellData(a, 1));
			// }

		}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return list;

	}

	public static ArrayList<String> templates() {
		String excelPath = "C:\\Users\\User\\Documents\\Hello.xlsx";
		String sheet = "Sheet1";
		ArrayList<String> templateList = new ArrayList<String>();
		FileRead fileRead = new FileRead(excelPath, sheet);

		for (int i = 1; i <= fileRead.getRow(); i++) {
			templateList.add(fileRead.getCellData(i, 2));
		}
		return templateList;

	}

}
