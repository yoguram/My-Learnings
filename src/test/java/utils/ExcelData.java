package utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelData {
	
	public static String[][] getData() throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("./Excel.xlsx");
		XSSFSheet ws = wb.getSheet("sheet1");
		int rowcount = ws.getLastRowNum();
		int cellCount = ws.getRow(0).getLastCellNum();
		String data[][] = new String[rowcount][cellCount];
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				String cellvalue =ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellvalue;
		    }
		}
		wb.close();
		return data;
		
	}
	

	@DataProvider(name = "readdata")
	public String[][] ReadExcel() throws IOException  {
		String readData[][] = ExcelData.getData();
		return readData;
	}

}
