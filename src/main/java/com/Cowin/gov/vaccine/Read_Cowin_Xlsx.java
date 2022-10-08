package com.Cowin.gov.vaccine;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Cowin_Xlsx {
	static	String value;
	public static String particularData(String sheet, int row, int cell) throws IOException {
		File f = new File("C:\\Users\\ANBU\\Desktop\\Project.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		CellType ce = c.getCellType();
		if (ce.equals(CellType.STRING)) {
			value = c.getStringCellValue();
		} else if (ce.equals(CellType.NUMERIC)) {
			double d = c.getNumericCellValue();
			int a = (int) d;
			 value = Integer.toString(a);
		}
return value;
	}
}

