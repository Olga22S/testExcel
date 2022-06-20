package excelload;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.util.List;

//В предыдущих версиях Microsoft Office (97-2003) файлы excel имели формат XLS
// и новый версии обычно используют формат XSLX.
// Для работы с файлами XSL вам нужно использовать классы с приставкой HSSF.
// Для файлов формата XSLX нужно использовать классы с приставкой XSSF.
public class Writer {

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public static HSSFWorkbook getHSSFWorkbook(String sheetName, List<Entity> entities) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);

        int rownum = 0;
        Cell cell;
        Row row;

        HSSFCellStyle style = createStyleForTitle(workbook);
        row = sheet.createRow(rownum);

        cell = row.createCell(0, CellType.NUMERIC);
        cell.setCellValue("id");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Name");
        cell.setCellStyle(style);

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Description");
        cell.setCellStyle(style);

        for (Entity entity : entities) {
            rownum++;
            row = sheet.createRow(rownum);
            // ID (A)
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(entity.getId());
            // NAME (B)
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(entity.getName());
            // Description (C)
            cell = row.createCell(2, CellType.NUMERIC);
            cell.setCellValue(entity.getDescription());
        }
        return workbook;
    }
}
