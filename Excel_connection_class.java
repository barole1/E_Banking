package hybrid_package;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_connection_class 
{
	public static XSSFWorkbook wbook;
	public static XSSFSheet wsht;
	public static String path="Testdata\\";
	
	public static void excel_connection(String filename,String sheetname) 
	{
		try {
			
			FileInputStream fi=new FileInputStream(path+filename);
			wbook=new XSSFWorkbook(fi);
			wsht=wbook.getSheet(sheetname);
			
		} catch (Exception e)
		{
			
			System.out.println(e.getMessage());
		}
	}
	
	public static String excel_rows(int row,int col) 
	{
		return wsht.getRow(row).getCell(col).getStringCellValue();
	}
	
	

}
