package mainPackage;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelRead extends Commonfunction {
	int rowCount;
	int colCount;

	public ExcelRead(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public Object[][] read() throws Exception {
		Object[][] obj=null;
		FileInputStream file = new FileInputStream(prop.getProperty("SheetPath"));
		XSSFWorkbook wb = new XSSFWorkbook(file);
		int sheetno = Integer.parseInt(prop.getProperty("SheetNo"));
		XSSFSheet sheet = wb.getSheetAt(sheetno);
		//String sheetname = sheet.getSheetName();
		 rowCount = sheet.getLastRowNum() + 1;
		System.out.println("total rows" + rowCount);
		colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("total Coulmn" + colCount);
		obj = new Object[rowCount][colCount];
		
        for(int i=1;i<rowCount;i++) {
            //obj[i-1]=new Object[sheet.getRow(i).getPhysicalNumberOfCells()];
		
        for (int j = 0; j < colCount; j++) {
        	obj[i][j]=sheet.getRow(i).getCell(j).toString();
        }
        }
        wb.close();
        file.close();
       
		return obj;

	}
}
