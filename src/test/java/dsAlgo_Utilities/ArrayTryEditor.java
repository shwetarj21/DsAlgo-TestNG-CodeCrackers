package dsAlgo_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ArrayTryEditor {


	public String[] ArrayTryEditor(String filePath, String sheetName, int rowNumber) throws IOException {
		String path = System.getProperty("user.dir") + "\\" + filePath;
		File excelFile = new File(path);
		FileInputStream Fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(Fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);

        Row row = sheet.getRow(rowNumber);        
        String pythoncode = row.getCell(0).getStringCellValue();  
        String output = row.getCell(1).getStringCellValue();
        workbook.close();
        Fis.close();
        
        String[] editor = new String[2];
        editor[0] = pythoncode;
        editor[1] = output;

        return editor;
	}
}
