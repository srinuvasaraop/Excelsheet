package exceloprations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;




/*import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;*/
import org.apache.poi.xssf.usermodel.*;

public class WrittingdatausingArraylist {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet Sheet = book.createSheet();
		ArrayList<Object[]> empdata = new ArrayList<Object[]>();
		empdata.add(new Object[] { "Empid", "Name", "Job" });
		empdata.add(new Object[] { 101, "David", "Enginner" });
		empdata.add(new Object[] { 102, "Smith", "Manager" });
		empdata.add(new Object[] { 103, "Scott", "Analyst" });
		int rowcount=0;
       for(Object[] emp:empdata)
       {
    	  XSSFRow row=Sheet.createRow(rowcount++);
    	  int cellnum=0; 
    	  for(Object value:emp)
    	  {
    		  
    		  XSSFCell cell=row.createCell(cellnum++);
    		  if(value instanceof String)
					cell.setCellValue((String)value);
			if(value instanceof Integer)
					cell.setCellValue((Integer)value);
			if(value instanceof Boolean)
				cell.setCellValue((Boolean)value);
    	  }
       }
       String filePath=".\\datafiles\\arraylistemployee.xlsx";
		FileOutputStream outstream=new FileOutputStream(filePath);
		book.write(outstream);
		
		outstream.close();
		
		System.out.println("Employee.xls file written successfully...");
	}

}
