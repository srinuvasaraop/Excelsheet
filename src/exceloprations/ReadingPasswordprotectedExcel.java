package exceloprations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingPasswordprotectedExcel {

	public static void main(String[] args)  {
		try{
			
			FileInputStream inputStream = new FileInputStream(new File(".\\datafiles\\customers.xlsx"));
			String password="test123";
			
			XSSFWorkbook workbook=(XSSFWorkbook)WorkbookFactory.create(inputStream,password);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			Iterator<Row> iterator =sheet.iterator();
			while(iterator.hasNext())
			{
				Row nextRow =iterator.next();
				Iterator<Cell> celliterator=nextRow.cellIterator();
				while(celliterator.hasNext())
				{
					Cell cell=celliterator.next();
					switch (cell.getCellType()) {
					case STRING:
	                    System.out.print(cell.getStringCellValue());
	                    break;
	                case BOOLEAN:
	                    System.out.print(cell.getBooleanCellValue());
	                    break;
	                case NUMERIC:
	                    System.out.print(cell.getNumericCellValue());
	                    break;
	                default:
	                    break;
					}
					System.out.print(" | ");
				}
				System.out.println();
			}
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		
	}

}
