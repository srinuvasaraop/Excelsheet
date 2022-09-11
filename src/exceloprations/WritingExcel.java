package exceloprations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcel {

	public static void main(String[] args) throws IOException   {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		Object empdata[][] = { { "EMPNO", "EMPNAME", "EMPSAL" },
				{ "1", "SAI", "1000" }, { 2, "RAJAaxmi", 2000 }, { 3, "SWARNA", 3000 } };
		//@@@@ for loop @@@/
/*		int rows = empdata.length;
		int cols = empdata[0].length;
		// System.out.println(rows+" "+cols);

		for (int r = 0; r < rows; r++) {
			XSSFRow row = sheet.createRow(r);
			for (int c = 0; c < cols; c++) 
			  {
				  XSSFCell cell = row.createCell(c);
				  Object value = empdata[r][c];
				  if (value instanceof Integer) {
					cell.setCellValue((Integer) value);
				   }
				  if (value instanceof String) {
					cell.setCellValue((String) value);
				  }
			 }
			
		}*/
		
		//for each loop//
		int rowcount=0;
		for(Object emp[]:empdata)
		{
			XSSFRow row=sheet.createRow(rowcount++);
			int colcount=0;
			for(Object value:emp)
			{
				XSSFCell cell=row.createCell(colcount++);
				if(value instanceof String)
					cell.setCellValue((String)value);
			if(value instanceof Integer)
					cell.setCellValue((Integer)value);
			if(value instanceof Boolean)
				cell.setCellValue((Boolean)value);
			}
		}
           
       
		String filePath=".\\datafiles\\employee1.xlsx";
		FileOutputStream fos=new FileOutputStream(filePath);
		workbook.write(fos);
		fos.close();
		System.out.println("Employee.xls file written successfully...");
	}

}
