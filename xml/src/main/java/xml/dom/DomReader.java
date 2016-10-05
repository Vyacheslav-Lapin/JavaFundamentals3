package xml.dom;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import lombok.extern.java.Log;
import lombok.val;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import xml.Food;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log
public class DomReader {

    public static void main(String[] args) throws IOException, SAXException {
        //создание DOM-анализатора (Xerces)

        DOMParser parser = new DOMParser();
        parser.parse("xml/src/test/resources/menu.xml");
        Document document = parser.getDocument();

        Element root = document.getDocumentElement();
        List<Food> menu = new ArrayList<>();

        NodeList foodList = root.getElementsByTagName("food");

        for (int i = 0; i < foodList.getLength(); i++) {
            val foodBuilder = Food.builder();
            Element foodElement = (Element) foodList.item(i);
            foodBuilder.id(Integer.parseInt(foodElement.getAttribute("id")));
            foodBuilder.name(getSingleChild(foodElement, "name").getTextContent().trim());
            foodBuilder.description(getSingleChild(foodElement, "description").getTextContent().trim());
            foodBuilder.price(getSingleChild(foodElement, "price").getTextContent().trim());
            foodBuilder.calories(Integer.parseInt(getSingleChild(foodElement, "calories").getTextContent().trim()));
            menu.add(foodBuilder.build());
        }

        log.info(menu::toString);
    }

    private static Element getSingleChild(Element element, String childName) {
        NodeList nlist = element.getElementsByTagName(childName);
        return (Element) nlist.item(0);
    }
}
