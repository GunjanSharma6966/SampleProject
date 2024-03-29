package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

    public String read() {
        //Path of the excel file
        FileInputStream fs = null;
        try {
            fs = new FileInputStream("C:\\Users\\Akshay-Gunjan\\IdeaProjects\\Practice\\config\\testdata\\data.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Creating a workbook
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(1);
        String a = sheet.getRow(1).getCell(1).toString();

        return a;
    }

    }

