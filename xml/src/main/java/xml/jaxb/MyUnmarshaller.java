package xml.jaxb;

import xml.Food;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class MyUnmarshaller {

    public static final String PATHNAME = "xml/src/test/resources/food.xml";

    public static void main(String[] args) throws JAXBException {
        File file = new File(PATHNAME);
        JAXBContext jaxbContext = JAXBContext.newInstance(Food.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Food food = (Food) jaxbUnmarshaller.unmarshal(file);

        System.out.println(food.getName());

    }
}
