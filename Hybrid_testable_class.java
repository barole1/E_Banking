package hybrid_package;

import org.testng.annotations.Test;

public class Hybrid_testable_class 
{
  @Test(priority=0)
  public void Application() 
  {
	  Helper_Class.excel_helper_class("Hybrid_excelsheet.xlsx","URL");
  }
  
  @Test(priority=1)
  public void Admin_login() 
  {
	  Helper_Class.excel_helper_class1("Hybrid_excelsheet.xlsx","Admin","Admin_login");
  }
  
 @Test(priority=2)
  public void RolesCreation() 
  {
	  Helper_Class.excel_helper_class1("Hybrid_excelsheet.xlsx","Roles","Roles_Creation");
  }
}
