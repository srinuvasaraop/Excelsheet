package exceloprations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class WriteFormulaCell1 {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet();
		XSSFRow  row=sheet.createRow(0);
		row.createCell(0).setCellValue(2);
		row.createCell(1).setCellValue(1);
		row.createCell(2).setCellValue(3);
		row.createCell(3).setCellValue(4);
		row.createCell(4).setCellValue(5);
		//here we are writing formula to excel sheet
        row.createCell(5).setCellFormula("A1*B1*C1*D1*E1");
        String file=".\\datafiles\\writeformula.xlsx";
        FileOutputStream fos=new FileOutputStream(file);
        workbook.write(fos);
        fos.close();
        System.out.println("data writen using formula");
	}

}
