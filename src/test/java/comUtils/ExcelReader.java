package comUtils;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
	
//String cellData = getCellData(rowNumber, cellNumber);
	public class ExcelReader {
		
		    public static String getCellData(int rowNumber, int cellNumber) {
		    	String filePath= "./src/test/resources/testData/Testdata.xlsx";
		    	String cellData = "";
                
		        try (FileInputStream fis = new FileInputStream(filePath);
		             Workbook workbook = new XSSFWorkbook(fis)) {

		            // Get the specified sheet
		            Sheet sheet = workbook.getSheet("Login");
		            if (sheet == null) {
		                System.out.println("Sheet with name '" + "Login" + "' does not exist.");
		                return null;
		            }

		            // Get the specified row
		            Row row = sheet.getRow(rowNumber);
		            if (row == null) {
		                System.out.println("Row " + rowNumber + " does not exist.");
		                return null;
		            }

		            // Get the specified cell
		            Cell cell = row.getCell(cellNumber);
		            cellData = getCellValue(cell);

		        } catch (IOException e) {
		            e.printStackTrace();
		        }

		        return cellData;
		    }

		    private static String getCellValue(Cell cell) {
		        if (cell == null) {
		            return "";
		        }

		        switch (cell.getCellType()) {
		            case STRING:
		                return cell.getStringCellValue();
		            case NUMERIC:
		                return String.valueOf(cell.getNumericCellValue());
		            case BOOLEAN:
		                return String.valueOf(cell.getBooleanCellValue());
		            case FORMULA:
		                return cell.getCellFormula();
		            default:
		                return "";
		        }
		    }
		}

