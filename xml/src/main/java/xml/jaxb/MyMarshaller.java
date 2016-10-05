package xml.jaxb;

import xml.Food;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MyMarshaller {

    public static final String NAME = "xml/src/test/resources/food.xml";

    public static void main(String[] args) throws FileNotFoundException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(Food.class);
        Marshaller m = context.createMarshaller();

        Food food = Food.builder()
                .id(123)
                .name("nnn")
                .description("ddd")
                .calories(234)
                .price("333")
                .build();

        m.marshal(food, new FileOutputStream(NAME));
        m.marshal(food, System.out);// на консоль
        System.out.println("XML-файл создан");

    }
}
