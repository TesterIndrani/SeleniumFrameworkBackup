package Generic_Utility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

/** 
 * This method is used to fetch data from Excel
 * @author Indrani
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @return
 * @throws Throwable
 */
	public String getExcelData(String sheetName,int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fes = new FileInputStream("E:/Qspiders Adv Selenium/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);	
		Row row = sheet.getRow(rowNum);		//to fetch data from 1st row	
		Cell cell = row.getCell(cellNum);		//to fetch data from 1st cell of that row
		String value = cell.getStringCellValue();
		return value;
	}
	
/**
 * Used to fetch data as it is from excel. Used for decimal values and phone number etc
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @return
 * @throws Throwable
 * @author Indrani
 */
	public String getExcelDataFormatter(String sheetName,int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fes = new FileInputStream("E:/Qspiders Adv Selenium/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		return data;
	}
	
	/**
	 * Used to fetch multiple set of data from Excel and store it in a 2-dimensional array of Object type
	 * @author Indrani
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultipleData(String sheetName) throws Throwable	//return type is 2 dimensional array of Object type
	{
		FileInputStream fes = new FileInputStream("E:/Qspiders Adv Selenium/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		
		Sheet sh = book.getSheet(sheetName);
		int lastRow = sh.getLastRowNum()+1;		//to get last row no with data
		int lastCell = sh.getRow(0).getLastCellNum();		//to get last column no with data
		
		Object[][] objarr = new Object[lastRow][lastCell];
		Excel_Utility elib = new Excel_Utility();		
		for(int i=0; i<lastRow; i++)
		{
			for(int j=0; j<lastCell; j++)
			{
				objarr[i][j] = elib.getExcelData("DataProvider", i, j);
			}
		}
	return objarr;		
	}
	
}
