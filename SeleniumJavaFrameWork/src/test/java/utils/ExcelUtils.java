package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static void main(String[] args) {
		getRowCount();
	}
	
	public static void getRowCount() {
		XSSFWorkbook workboock;
		try {
			String projectPath = System.getProperty("user.dir");
			workboock = new XSSFWorkbook(projectPath + "/excel/data.xlsx");
			XSSFSheet sheet = workboock.getSheet("Sheet1");
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of row count = " + rowCount);
		} 
		catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		
	}
	
	public static void getCellData() {
		
	}

}
