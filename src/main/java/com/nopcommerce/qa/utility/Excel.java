package com.nopcommerce.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.nopcommerce.qa.Enum.AddressOfFiles;

public class Excel {
	private static final String EXCEL_FILE_PATH = AddressOfFiles.DataFile;
	
	/** Reading the whole excel data from a excel file and storing it into 
	 * the object you can use data Provider to access the excel data 
	 * 
	 * @Example
	 *     @DataProvider(name = "excelDataProvider")
               public Object[][] provideTestData() {
                return ExcelUtils.readExcelData("Sheet1");
    }*/
	public static Object[][] readExcelData(String sheetName) {
		Object[][] testData = null;
		try (FileInputStream fis = new FileInputStream(EXCEL_FILE_PATH)) {
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);

			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();

			testData = new Object[rowCount][colCount];

			for (int i = 0; i < rowCount; i++) {
				Row row = sheet.getRow(i + 1);
				for (int j = 0; j < colCount; j++) {
					Cell cell = row.getCell(j);
					switch (cell.getCellType()) {
					case STRING:
						testData[i][j] = cell.getStringCellValue();
						break;
					case NUMERIC:
						testData[i][j] = cell.getNumericCellValue();
						break;
					case BOOLEAN:
						testData[i][j] = cell.getBooleanCellValue();
						break;
					default:
						testData[i][j] = null;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testData;

	}
	
	/** This Method will return the Last  Row of the Sheet*/
	public static int getRowCount(String sheetName) {
	    int rowCount = 0;
	    try (FileInputStream fis = new FileInputStream(EXCEL_FILE_PATH)) {
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet(sheetName);
	        rowCount = sheet.getLastRowNum();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return rowCount;
	}
	
	/** This Method will return the Column Count */
	public static int getColumnCount(String sheetName) {
	    int colCount = 0;
	    try (FileInputStream fis = new FileInputStream(EXCEL_FILE_PATH)) {
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet(sheetName);
	        colCount = sheet.getRow(0).getLastCellNum();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return colCount;
	}
	/** To Get the Particular Cell Data you need to pass the Sheet Name  row and column
	 * @Note current it will deal with the excel file which we have already stored
	 * if you want you can pass the file data by changing the argument and adding.
	 * */
	public static Object getCellData(String sheetName, int rowNum, int colNum) {
	    Object cellData = null;
	    try (FileInputStream fis = new FileInputStream(EXCEL_FILE_PATH)) {
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet(sheetName);
	        Row row = sheet.getRow(rowNum);
	        Cell cell = row.getCell(colNum);
	        switch (cell.getCellType()) {
	            case STRING:
	                cellData = cell.getStringCellValue();
	                break;
	            case NUMERIC:
	                cellData = cell.getNumericCellValue();
	                break;
	            case BOOLEAN:
	                cellData = cell.getBooleanCellValue();
	                break;
	            default:
	                cellData = null;
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return cellData;
	}




}
