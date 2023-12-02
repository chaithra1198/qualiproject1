package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

public class wpsUtils {
	static String Projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public wpsUtils(String wpspath,String sheetName){
		try {
		
		workbook=new XSSFWorkbook(wpspath);
		sheet=workbook.getSheet(sheetName);
		}catch(Exception exp)
		{
			exp.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//getRowcount();
		getCelldataString(0,0);
		getCelldataNumber(1,1);
	}
	public static int getRowcount(){
		int rowcount=0;
		try {
			
			rowcount=sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows: "+rowcount);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.getStackTrace();
		}
		return rowcount;

	}
	public static void getCelldataString(int rowNum,int colNum){
		try {
			
			String Celldata= sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(Celldata);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.getStackTrace();
		}

	}
	public static void getCelldataNumber(int rowNum, int colNum){
		try {
			
			double Celldata= sheet.getRow(rowNum).getCell(rowNum).getNumericCellValue();
			System.out.println(Celldata);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.getStackTrace();
		}
	}
	public static int getColcount(){
		int colCount=0;
		try {
			
			colCount=sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No of Colms: "+colCount);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.getStackTrace();
			
		}return colCount;

	}
}
