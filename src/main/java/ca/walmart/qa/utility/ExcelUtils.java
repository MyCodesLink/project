package ca.walmart.qa.utility;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		}
		catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}
	public static void getAnyCellData(int rowNum,int colNum) throws IOException {
		
		DataFormatter formatter = new DataFormatter();
		Object value=formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		System.out.println(value);
		
		
	}

	public static String getStringCellData(int rowNum,int colNum) throws IOException {
	
	//String value= sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	//System.out.println(value);
	return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	
	}
	
	public static String getNumericCellData(int rowNum,int colNum) throws IOException {
		
			double value= sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
				 int number = (int) value;
				 String cellvalue=String.valueOf(number); 
			 	 return cellvalue;
		
			
		}
	
	
	
	
	
	
}
