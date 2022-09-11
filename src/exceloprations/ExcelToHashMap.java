package exceloprations;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToHashMap {

	public static void main(String[] args) throws Exception {
		try{
			FileInputStream fis = new FileInputStream(".\\datafiles\\student.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Student data");
			HashMap<String, String> map = new HashMap<String, String>();
			int rowno = 0;
			int lastRowNum = sheet.getLastRowNum();
			for (int i = 0; i <= lastRowNum; i++) {
				String key=sheet.getRow(i).getCell(0).getStringCellValue();
				String value=sheet.getRow(i).getCell(1).getStringCellValue();
				map.put(key, value);
			}
			//Read data from HashMap
			
			for(Map.Entry entry:map.entrySet())
			{
				System.out.println(entry.getKey()+" "+entry.getValue());
			}
		}catch(Exception e)
		{
		e.printStackTrace();	
		}
		

	}
}
