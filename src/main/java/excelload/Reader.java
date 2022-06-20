package excelload;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Reader {

    public static List<Entity> getEntitiesFromExcel(File file) throws IOException {
        List<Entity> entities = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(file);
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        // Get first sheet from the workbook
        HSSFSheet sheet = workbook.getSheetAt(0);
        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        int i = 0;

        while (rowIterator.hasNext()) {
            Entity entity = new Entity();
            Row row = rowIterator.next();
            // Get iterator to all cells of current row
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                String columnName = cell.getSheet().getRow(0).getCell(i++)
                        .getRichStringCellValue().toString();
                if (columnName.equals("id")) {
                    entity.setId((long) cell.getNumericCellValue());
                } else if (columnName.equals("Name")) {
                    entity.setName(cell.getStringCellValue());
                } else {
                    entity.setDescription(cell.getStringCellValue());
                }
            }
            entities.add(entity);
            i = 0;
        }
        return entities;
    }
}
