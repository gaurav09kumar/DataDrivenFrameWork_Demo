package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {
	public static void main(String[] args) throws IOException {
		try {
			
		
		File src = new File("C:\\Users\\VSPICT\\DataDrivenFramework\\src\\testData\\TestData.xlsx");

		FileInputStream stream = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(stream);
		XSSFSheet sheet1 = wb.getSheetAt(0);

		String value1 = sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println(value1);

		int roNum = sheet1.getLastRowNum();

		System.out.println("the number of rows in the excel sheet are: " + roNum);

		for (int i = 0; i <= roNum; i++) {
			String username_row = sheet1.getRow(i).getCell(0).getStringCellValue();
			String password_row = sheet1.getRow(i).getCell(1).getStringCellValue();
			System.out.println(username_row+" "+password_row);
		}
		wb.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
