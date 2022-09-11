package exceloprations;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadFormuladata {

	public static void main(String[] args) throws Exception{
		
			FileInputStream file = new FileInputStream(
					".\\datafiles\\readformula.xlsx");

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int countrows = sheet.getLastRowNum();
			int countcols = sheet.getRow(0).getLastCellNum();
			for (int r = 0; r < countrows; r++) {
				XSSFRow row=sheet.getRow(r);  
				for (int c = 0; c < countcols; c++) {

	               XSSFCell cell=row.getCell(c);
					switch(cell.getCellType()) {

					case STRING:
						System.out.print(cell.getStringCellValue());
						break;
					case NUMERIC:
						System.out.print(cell.getNumericCellValue());
						break;
					case BOOLEAN:
						System.out.print(cell.getBooleanCellValue());
						break;
					case FORMULA:
					System.out.print(cell.getNumericCellValue());
					break;

					}
					System.out.print(" | ");
				}

				System.out.println();
			}
			file.close();
		}
}
