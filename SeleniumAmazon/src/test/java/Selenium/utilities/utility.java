package Selenium.utilities;
import org.testng.Reporter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.log4j.PropertyConfigurator;
import org.testng.log4testng.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class utility {
	
	static XSSFSheet sheet;
	static XSSFWorkbook workbook;
	static Cell cell;
	static String filePath="C:\\Users\\vgayakwad\\eclipse-workspace\\SeleniumAmazon\\src\\test\\java\\Selenium\\Excelfiles\\loginData.xlsx";
	//static String sheetName = "Sheet1";
	
	static Logger Logs=Logger.getLogger(utility.class);
	static String LogPropertyFilePath="C:\\Users\\vgayakwad\\eclipse-workspace\\SeleniumAmazon\\src\\test\\java\\Selenium\\logFileProperty\\log4j.properties";
	
	    public static void handleExcel() throws IOException{
	    	double mobileNumber;
	    	CellType type;
	    	try {
	    		// Create a FileInputStream from the Excel file
	            FileInputStream file = new FileInputStream(new File(filePath));

	            // Create a Workbook object for .xlsx file
	            Workbook workbook = new XSSFWorkbook(file);

	            // Get the desired sheet from the workbook
	            Sheet sheet = workbook.getSheetAt(0);
	            cell=sheet.getRow(1).getCell(0);
	            type = cell.getCellType();
	            System.out.println(type);
	            switch (type) {
	            case NUMERIC :  //numeric value in excel
	            	mobileNumber=cell.getNumericCellValue();
		            System.out.println(mobileNumber);	                
		            break;	            
	            default :
	                throw new RuntimeException("There is no support for this type of value in Apche POI");
	        }
	            /*if (){
		            mobileNumber=cell.getNumericCellValue();
		            System.out.println(mobileNumber);
	            }else{
	            	System.out.println("Cell Type Not found");
	            }*/
	            //return mobileNumber;
	    	}catch(IOException e) {
	    		e.printStackTrace();
	    	}
	    	//return mobileNumber;
	    }
	        
	public static void generateReport(String messages){
		Reporter.log(messages);
	}
	
	public static void getInfo(String message) {
		PropertyConfigurator.configure(LogPropertyFilePath);
		Logs.info(message);
	}
	
	public static void getError(String message) {
		PropertyConfigurator.configure(LogPropertyFilePath);
		Logs.error(message);
	}
	
	public static void getInfoLogReport(String message) {
		getInfo(message);
		generateReport(message);
	}
	public static void getErrorLogReport(String message, WebDriver driver) {
		getError(message);
		generateReport(message);
		TakeScreenshot(driver);
	}
	
	public static void TakeScreenshot(WebDriver driver) {
		try {
			TakesScreenshot ss= ((TakesScreenshot)driver);
			File srcFile = ss.getScreenshotAs(OutputType.FILE);
			File destFile = new File ("C:\\Users\\vgayakwad\\eclipse-workspace\\SeleniumAmazon\\src\\test\\java\\Selenium\\Screenshots");
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}