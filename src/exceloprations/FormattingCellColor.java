package exceloprations;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

public class FormattingCellColor {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream(
				".\\datafiles\\styles1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1");
		XSSFRow row = sheet.createRow(1);

		// Setting Background color
		XSSFCell cell = row.createCell(1);
		cell.setCellValue("welcome");

		XSSFCellStyle style = workbook.createCellStyle();

		style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.BIG_SPOTS);
		cell.setCellStyle(style);

		// Setting Foreground color
		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell = row.createCell(2);
		cell.setCellValue("Automation");
		cell.setCellStyle(style);
		workbook.write(fos);
		workbook.close();
		fos.close();
		System.out.println("Done!!!");
	}

}
