package datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DateinExcel {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Date Sheet");
		 XSSFCell cell     = sheet.createRow(0).createCell(0);
		 cell.setCellValue(new Date());
		 CreationHelper createHelper = workbook.getCreationHelper();  
		 XSSFCellStyle style=workbook.createCellStyle();
		 style.setDataFormat(  
	                createHelper.createDataFormat().getFormat("d/m/yy h:mm"));  
		  cell.setCellStyle(style); 
		 
      //format type is mm/dd/yyyys
		 XSSFCell celltwo     = sheet.createRow(1).createCell(0);
		 celltwo.setCellValue(new Date());
		 style.setDataFormat(  
	                createHelper.createDataFormat().getFormat("mm/dd/yyyy h:mm"));  
		 celltwo.setCellStyle(style); 
		 FileOutputStream fos=new FileOutputStream(".\\datafiles\\dateformat.xlsx");
		 workbook.write(fos);
		 System.out.println("Done");
	}

}
