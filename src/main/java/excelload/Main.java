package excelload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Entity entity1 = new Entity(1L, "Ent1", "Description 1");
        Entity entity2 = new Entity(2L, "Ent2", "Description 2");
        Entity entity3 = new Entity(3L, "Ent3", "Description 3");
        List<Entity> entities = new ArrayList<>();
        entities.add(entity1);
        entities.add(entity2);
        entities.add(entity3);

       File file = new File("employee.xls");

//
//        FileOutputStream outFile = new FileOutputStream(file);
//        Writer.getHSSFWorkbook("Entities Sheet", entities).write(outFile);
//        System.out.println("Created file: " + file.getAbsolutePath());
        List<Entity> entities1 =  Reader.getEntitiesFromExcel(file);
        entities1.forEach(entity -> System.out.println(entity));

    }
}
