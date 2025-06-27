package mainPackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

  public class ExcelWrite extends Commonfunction {
	
	  public ExcelWrite(WebDriver driver) {
		super(driver);
	}

	public XSSFWorkbook workbook;
	public XSSFSheet spreadsheet;
	public FileOutputStream out;
	
	
	public void createWorkBook() {
		workbook = new XSSFWorkbook();	      
	    spreadsheet = workbook.createSheet("Status");
	    Row row = spreadsheet.createRow(0);
	    row.createCell(0).setCellValue("UC");
	    row.createCell(1).setCellValue("User Question");
	    row.createCell(2).setCellValue("Expected Result");
	    row.createCell(3).setCellValue("Actual Result");
	    row.createCell(4).setCellValue("Status");
	    row.createCell(5).setCellValue("Row Number");
	    
	    XSSFCellStyle style = workbook.createCellStyle();
	    XSSFFont font = workbook.createFont();
	    font.setBold(true);
	    style.setFont(font);
	    row.getCell(0).setCellStyle(style);
	    row.getCell(1).setCellStyle(style);
	    row.getCell(2).setCellStyle(style);
	    row.getCell(3).setCellStyle(style);
	    row.getCell(4).setCellStyle(style);
	    row.getCell(5).setCellStyle(style);
	    row.setRowStyle(style);
	    }
	
	public void writeExcel(int rowNumber, int cellNumber, String cellValue) throws IOException {	
		if(spreadsheet.getRow(rowNumber)==null) {
		spreadsheet.createRow(rowNumber);
		}
		Row row = spreadsheet.getRow(rowNumber);
	    row.createCell(cellNumber).setCellValue(cellValue);		
	}
	
	public void closeWorkBook() throws Exception {
		Date d = new Date();
		out = new FileOutputStream(new File("./Report/Regression_ExcelReports/" + prop.getProperty("Application") + "_DefectReport_" + prop.getProperty("Environment") + "_" + d.toString().replace(":", "_").replace(" ", "_") +".xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("Excel is written successfully");	
	}
}
