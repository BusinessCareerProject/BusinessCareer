package test;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Poi {

	public static void main(String[] args) {

		Workbook wb = new HSSFWorkbook();
	    Sheet sheet = wb.createSheet();

	    Row row1 = sheet.createRow(1);
	    Row row2 = sheet.createRow(2);

	    Cell cell1_0 = row1.createCell(0);
	    Cell cell1_1 = row1.createCell(1);
	    Cell cell1_2 = row1.createCell(2);

	    Cell cell2_0 = row2.createCell(0);
	    Cell cell2_1 = row2.createCell(1);
	    Cell cell2_2 = row2.createCell(2);

	    cell1_0.setCellValue(10);
	    cell1_1.setCellValue(-8.5);
	    cell1_2.setCellValue(3.14);

	    cell2_0.setCellValue("Hello");
	    cell2_1.setCellValue("表形式");
	    cell2_2.setCellValue("3.14");

	    FileOutputStream out = null;
	    try{
	      out = new FileOutputStream("sample3_1.xls");
	      wb.write(out);
	    }catch(IOException e){
	      System.out.println(e.toString());
	    }finally{
	      try {
	        out.close();
	      }catch(IOException e){
	        System.out.println(e.toString());
	      }
	    }
	  }

}
