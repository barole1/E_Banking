package hybrid_package;

import org.openqa.selenium.By;

public class Excel_locators_class 
{
	
	public static  By excel_locators(String proname,String provalue)
	{
		By obj=null;
		
		switch (proname) 
		{
		case "xpath":
			obj=By.xpath(provalue);
			break;
		case "css":
			obj=By.cssSelector(provalue);
			break;
		case "id":
			obj=By.id(provalue);
			break;
		case "name":
			obj=By.name(provalue);
			break;
		case "linktext":
			obj=By.linkText(provalue);
			break;
			

		default:
			break;
		}
		
		
		
		
		return obj;
		
		
	}
	
	

}
