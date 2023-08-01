package testdata_parameterization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData_driven {
	public static Workbook work;
	public static Sheet wrksht;
	
	public static Object[][] viewdata(String Sheetname){
		FileInputStream stream = null;
		try { 
			stream = new FileInputStream("C:\\Users\\tithi\\Desktop\\Software Testing\\"
					+ "TDD_HRProject\\src\\test\\java\\testdata_parameterization\\Data Details.xlsx ");
		}
		catch(FileNotFoundException f) {f.printStackTrace();}
		
		try {
			work =	WorkbookFactory.create(stream);
		} 
		catch (IOException e) { e.printStackTrace(); }
		
			wrksht =	work.getSheet(Sheetname);
		
			Object[][] data = new Object[wrksht.getLastRowNum()][wrksht.getRow(0).getLastCellNum()];
			
			for (int t=0;t<wrksht.getLastRowNum();t++) {
				for (int d=0;d<wrksht.getRow(0).getLastCellNum();d++) { 
					data[t][d]=wrksht.getRow(t+1).getCell(d).toString();	
				}}
			return data;
			
	}
	

}
