import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerDeserTest {
    @Test
    public void serDeser() throws Exception {
        // сериализация
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Object objSave = 1;
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(objSave);

        // смотрим, во что превратился сериализованный объект
        byte[] bArray = os.toByteArray();
        for (byte b : bArray) {
            System.out.print((char) b);
        }
        System.out.println();

        // десериализация
        ByteArrayInputStream is = new ByteArrayInputStream(bArray);
        ObjectInputStream ois = new ObjectInputStream(is);
        Object objRead = ois.readObject();

        // проверяем идентичность объектов
        System.out.println("readed object is: " + objRead.toString());
        System.out.println("Object equality is: " + (objSave.equals(objRead)));
        System.out.println("Reference equality is: " + (objSave == objRead));
    }
}
