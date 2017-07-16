package helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data {
	
	public static List<HashMap<String,String>> data(){
		List<HashMap<String,String>> mydata = null;
		try
		{

			FileInputStream fs = new FileInputStream("Data/CustomerDetails.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet("CustomerDetails");
			Row HeaderRow = sheet.getRow(0);
			mydata = new ArrayList<HashMap<String,String>>();

			for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
			{
				Row currentRow = sheet.getRow(i);
				HashMap<String,String> currentHash = new HashMap<String,String>();
				for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
				{
					Cell currentCell = currentRow.getCell(j);
					currentCell.setCellType(Cell.CELL_TYPE_STRING);
					currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());

				}
				mydata.add(currentHash);
			}

			fs.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return mydata;

	}

	public static List<HashMap<String,String>> data(String spreadSheetName, String sheetName){
		List<HashMap<String,String>> mydata = null;
		try
		{

			FileInputStream fs = new FileInputStream("Data/" + spreadSheetName );
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row HeaderRow = sheet.getRow(0);
			mydata = new ArrayList<HashMap<String,String>>();

			for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
			{
				Row currentRow = sheet.getRow(i);
				HashMap<String,String> currentHash = new HashMap<String,String>();
				for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
				{
					Cell currentCell = currentRow.getCell(j);
					currentCell.setCellType(Cell.CELL_TYPE_STRING);
					currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());

				}
				mydata.add(currentHash);
			}

			fs.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return mydata;

	}
}
