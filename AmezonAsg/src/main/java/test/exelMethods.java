package test;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class exelMethods {
	 public static ArrayList<String> getTestcaseData(String SheetName, String Tcname) throws IOException {
         
         FileInputStream file = new FileInputStream("C:\\Users\\Hp\\Desktop\\Automation Testing\\amezon.xlsx");
         
         XSSFWorkbook wbook = new XSSFWorkbook(file);
         System.out.println(wbook.getNumberOfSheets());
         
         ArrayList <String> getTestcaseData = new ArrayList();
         
         XSSFSheet sheet   = wbook.getSheet(SheetName);
         Iterator <Row> row    =sheet.rowIterator();
         while(row.hasNext())
         {
            Row specificrow  = row.next();
            if(specificrow.getCell(0).getStringCellValue().equalsIgnoreCase(Tcname))
            {
                
            Iterator <Cell> cell = specificrow.cellIterator();
         
          while(cell.hasNext())
          {
             Cell specificCellValue= cell.next();
             String cell2= specificCellValue.getStringCellValue();
             getTestcaseData.add(cell2);
          }
          break;
        }
     }
         return getTestcaseData;   


    }
    public static void FullSheet(String SheetName) throws IOException
    {
        FileInputStream file = new FileInputStream("C:\\Users\\Hp\\Desktop\\Automation Testing\\amezon.xlsx");
         
         XSSFWorkbook wbook = new XSSFWorkbook(file);
         
         ArrayList <String> testcasedata = new ArrayList<>();
         
         XSSFSheet sheet   = wbook.getSheet(SheetName);
         Iterator <Row> row    =sheet.rowIterator();
         while(row.hasNext())
         {
           Row specificrow     = row.next();
    
           Iterator <Cell> cell   = specificrow.cellIterator();
         
          while(cell.hasNext())
          {
             Cell specificCellValue= cell.next();
             String cell2= specificCellValue.getStringCellValue();
             System.out.println(cell2);
          }
          System.out.println();
     }
             
    }
    
public ArrayList<String> exel(String sheetname, String testcaseName) throws IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\Hp\\Desktop\\Automation Testing\\amezon.xlsx");
		
		XSSFWorkbook wbook = new XSSFWorkbook(file);
		
	    ArrayList <String> testcasedata = new ArrayList<>();
	    
	    XSSFSheet sheet   = wbook.getSheet(sheetname);
        Iterator <Row> row	=sheet.rowIterator();
        while(row.hasNext()) {
       Row specificrow 	= row.next();
   
    if (specificrow.getCell(0).getStringCellValue().equalsIgnoreCase(testcaseName)) {
    	 Iterator <Cell> cell   = specificrow.cellIterator();
    	
    	 while(cell.hasNext()) {
    		Cell specificCellValue= cell.next();
    	String cell2= specificCellValue.getStringCellValue();
    		testcasedata.add(cell2);
    	 }
    	 System.out.println();
    }
        	
        }
        return testcasedata;
	}
}

