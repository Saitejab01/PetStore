package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtil {
	public String getValueFromPropertiesFile(String Key) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\ninza_HRM_RestAssured_Backend_Testing_Framework\\config\\commonData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value=pro.getProperty(Key);
		fis.close();
		return value;
	}
	public String getValueFromExcelFile(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\ninza_HRM_RestAssured_Backend_Testing_Framework\\config\\commonData.properties");
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
	}
}
