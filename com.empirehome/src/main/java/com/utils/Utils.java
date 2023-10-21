package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.base.Testbase;

public class Utils extends Testbase {

	public Utils(WebDriver driver) throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	public  static  Object[][]   getdatafromexcel(String sheetname) throws IOException
	{
		File file=new File("./src/main/java/com/testdata/TestDataA.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook book=new XSSFWorkbook(fis);
		XSSFSheet sheet=book.getSheet(sheetname);
		int rownum=sheet.getPhysicalNumberOfRows();
		int cellnum=sheet.getRow(1).getLastCellNum();
		Object[][] data =new Object[rownum-1][cellnum];
		for(int i=0;i<rownum-1;i++)
		{ 
			for(int j=0;j<cellnum;j++)
			{
				DataFormatter format=new DataFormatter();
				data[i][j]=format.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
			
		}
		return data; 
	}

}