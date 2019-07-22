package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo3 {
	public Object getData(String source) throws IOException {
		File src = new File(source);
		FileInputStream stream = new FileInputStream(src);
		XSSFWorkbook wb= new XSSFWorkbook(stream);
		XSSFSheet sheet1= wb.getSheetAt(0);
		
		String value1 = sheet1.getRow(0).getCell(1).getStringCellValue();
		
		System.out.println(value1);
		
		int rowNum = sheet1.getLastRowNum();
		System.out.println(rowNum);
		Object [] [] data = new Object[(rowNum+1)][2];
		for (int i = 0; i <=rowNum; i++) {
			String username_row = sheet1.getRow(i).getCell(0).getStringCellValue();
			String password_row = sheet1.getRow(i).getCell(1).getStringCellValue();
			
			data[i][0]=username_row;
			data[i][1]=password_row;
			
		}
		wb.close();
		return data;
		
	}
}
