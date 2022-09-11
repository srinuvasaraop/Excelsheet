package datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {

	public String path;
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	File xlfile;

	XLUtility(String path) {
		this.path = path;
	}

	public int getRowCcount(String sheetName) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowcount;
	}

	public int getCellCount(String sheetName, int rowno) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowno);
		int cols = row.getLastCellNum();
		return cols;
	}

	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
{
	fis=new FileInputStream(path);
	workbook=new XSSFWorkbook(fis);
	sheet=workbook.getSheet(sheetName);
	row=sheet.getRow(rownum);
	cell=row.getCell(colnum);
	DataFormatter formatter = new DataFormatter();
	
	String data;
	try{
	data =formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
	}
	catch(Exception  e)
	{
		data="";
	}
	workbook.close();
	fis.close();
	return data;
}
	public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
	
	{
		//first here check file exst or noy.
		//if not exist create new one..
		//f exist take that file using fileinputstream
		File xlfile=new File(path);
		if(!xlfile.exists())    // If file not exists then create new file
		{
		workbook=new XSSFWorkbook();
		fos=new FileOutputStream(path);
		workbook.write(fos);
		}
				
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
			
		if(workbook.getSheetIndex("Sheet1")==-1) // If sheet not exists then create new Sheet
			workbook.createSheet("Sheet1");
		
		sheet=workbook.getSheet("Sheet1");
					
		if(sheet.getRow(rownum)==null)   // If row not exists then create new Row
				sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fos=new FileOutputStream(path);
		workbook.write(fos);		
		workbook.close();
		fis.close();
		fos.close();
		}
	}

