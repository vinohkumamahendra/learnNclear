package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelReadWrite {
	List<String> irctcuser, irctcpassword, IrctcStatus;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		ExcelReadWrite read = new ExcelReadWrite();
		read.readNWriteExcel();
		read.loginIrctc();
		read.WriteExcel();
		
	}
	
	public void WriteExcel(){
		try {
			XSSFWorkbook workBook = new XSSFWorkbook();
			
			XSSFSheet sheet = workBook.createSheet("IRCTC STATUS");
			
			
			sheet.createRow(0).createCell(0).setCellValue("UserName");
			sheet.getRow(0).createCell(1).setCellValue("Password");
			sheet.getRow(0).createCell(2).setCellValue("Status");
			for(int i =0; i < irctcuser.size() ; i++){
				sheet.createRow(i+1).createCell(0).setCellValue(irctcuser.get(i));
				sheet.getRow(i+1).createCell(1).setCellValue(irctcpassword.get(i));
				sheet.getRow(i+1).createCell(2).setCellValue(IrctcStatus.get(i));
			}
			
			
			
		//	makeRowBold(workBook,sheet.getRow(0));
			FileOutputStream fos  = new FileOutputStream(new File("Data/IrctcResult.xlsx"));
			workBook.write(fos);
			
			
		}catch (IOException e) {
			System.out.println("Unable to write the file & error thrown as "  + e.getMessage());
		}
	}
	
	
	public void loginIrctc(){
		//code to login and verify the status
		IrctcStatus = new LinkedList<>();
		
		ChromeDriver driver = new ChromeDriver();
		for(int i =0; i < irctcuser.size() ; i++){
			try {
				driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
				driver.findElement(By.id("usernameId")).sendKeys(irctcuser.get(i));
				driver.findElement(By.name("j_password")).sendKeys(irctcpassword.get(i));
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[text()='Login']")).sendKeys(irctcpassword.get(i));
				Thread.sleep(5000);
				
				if(driver.getCurrentUrl().contains("eticketing/home")){
					IrctcStatus.add("Passed");
				}
				else{
					IrctcStatus.add("Failed");
				}
			} catch (Exception e) {
				System.out.println("Unable to login " + irctcuser.get(i));
			}
			
		}
		
		
		
	}
	public void readNWriteExcel(){
		try {
			XSSFWorkbook workBook = new XSSFWorkbook("Data/Credential.xlsx");
		/*	//xls
			HSSFWorkbook wrk = new HSSFWorkbook(inp)*/
			XSSFSheet sheet = workBook.getSheet("IRCTC");
			/*irctcuser = sheet.getRow(1).getCell(0).getStringCellValue();
			irctcpassword = sheet.getRow(1).getCell(1).getStringCellValue();
			System.out.println("Usernmae " +irctcuser);
			System.out.println("Password " +irctcpassword)*/;
			irctcuser = new LinkedList<>();
			irctcpassword = new LinkedList<>();
			for(int i=1; i <= sheet.getLastRowNum();  i++){
				irctcuser.add(sheet.getRow(i).getCell(0).getStringCellValue());
				irctcpassword.add(sheet.getRow(i).getCell(1).getStringCellValue());
				System.out.println("Usernmae " +irctcuser);
				System.out.println("Password " +irctcpassword);
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println("Unable to read & write  the file & error thrown as "  + e.getMessage());
		}
	}
	
	
	
	

}
