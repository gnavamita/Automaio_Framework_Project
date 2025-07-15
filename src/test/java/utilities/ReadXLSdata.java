package utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.lang.reflect.Method;

public class ReadXLSdata {

    @DataProvider(name ="bvtdata")
    public String[][] getData(Method m) throws IOException {


        String excelSheetName = m.getName();

        File f = new File(System.getProperty("user.dir") + "/src/test/resources/testdata/testdata.xlsx");

        FileInputStream file = new FileInputStream(f);

        Workbook wb = WorkbookFactory.create(file);

        Sheet sheetname = wb.getSheet(excelSheetName);

        int totalRows = sheetname.getLastRowNum();

        System.out.println(totalRows);

        Row rowCells = sheetname.getRow(0);

        int totalCols = rowCells.getLastCellNum();

        System.out.println(totalCols);

        DataFormatter format = new DataFormatter();

        String testData[][] = new String[totalRows][totalCols];

        for(int i=1; i<=totalRows; i++){
            for (int j=0; j<=totalCols; j++){
                testData[i-1][j]= format.formatCellValue(sheetname.getRow(i).getCell(j));
                System.out.println( testData[i-1][j]);
            }
        }
        return testData;

    }
}
