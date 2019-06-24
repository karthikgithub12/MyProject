package com.sathya.qa.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	//"wbk" is an instance for Workbook interface
	Workbook wbk =null;
	
	//"sht" is an instance for Sheet interface
	Sheet sht = null;
	
	//"row" is an instance for Row interface
	Row row = null;
	
	//"cell" is an instance for Cell interface
	Cell cell = null;
	
	//"out" is a static instance for FileOutputStream class
	FileOutputStream out = null;
	
	public ExcelWrite() {
		wbk = new XSSFWorkbook();
	}
	
	public void toCreateSheet(String data) {
		sht = wbk.createSheet(data);
	}
	
	public void rowCreation(int i) {
		row = sht.createRow(i);
	}
	
	public void cellCreationAndWrite(int i, String data) {
		
		cell = row.createCell(i);
		cell.setCellValue(data);
	}
	
	public void fileCreation() throws IOException {
		out = new FileOutputStream(new File("C:\\Sathya.xlsx")); 
		wbk.write(out);
		out.close();
	}

}
