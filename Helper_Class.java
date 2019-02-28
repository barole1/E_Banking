package hybrid_package;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Helper_Class 
{
	
	public static WebDriver driver;
	
	public static void excel_helper_class(String filename,String sheetname) 
	{
		Excel_connection_class.excel_connection(filename, sheetname);
		
		String app_url=Excel_connection_class.wsht.getRow(1).getCell(0).getStringCellValue();
		
		//Application
		driver=new FirefoxDriver();
		driver.get(app_url);
		driver.manage().window().maximize();
		
	}
	
	public static void excel_helper_class1(String filename,String sheetname,String imagename) 
	{
		Excel_connection_class.excel_connection(filename, sheetname);
		
		//count
		int rc=Excel_connection_class.wsht.getLastRowNum();
		
		for (int i = 1; i <=rc; i++) 
		{
			
			String proname=Excel_connection_class.wsht.getRow(i).getCell(1).getStringCellValue();
			String provalue=Excel_connection_class.wsht.getRow(i).getCell(2).getStringCellValue();
			String Actions=Excel_connection_class.wsht.getRow(i).getCell(3).getStringCellValue();
			String Inputdata=Excel_connection_class.wsht.getRow(i).getCell(4).getStringCellValue();
			
			
			switch (Actions) 
			{
			case "Textbox":
				WebElement ele=driver.findElement(Excel_locators_class.excel_locators(proname, provalue));
				ele.clear();
				ele.sendKeys(Inputdata);
				break;
			case "Button":
				WebElement ele1=driver.findElement(Excel_locators_class.excel_locators(proname, provalue));
				ele1.click();
				break;
			case "DropDown":
				Select drop=new Select(driver.findElement(Excel_locators_class.excel_locators(proname, provalue)));
				drop.selectByVisibleText(Inputdata);
				break;
			case "Alert":
				driver.switchTo().alert().accept();
				break;
			case "CaptureScreen":
				try {
					
					File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(src,new File("screens1\\"+imagename+".png"));
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
              break;
              
			default:
				break;
			}
			
			
			
			
		}
		
		
		
		
	}

}
