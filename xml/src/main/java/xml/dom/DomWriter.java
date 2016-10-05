package xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;

public class DomWriter {

    public static final String FILE_NAME = "xml/src/test/resources/dommenu.xml";

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {

        Document document = getDocument();

        Element breakfastMenu = document.createElement("breakfast-menu");
        Element food = document.createElement("food");
        food.setAttribute("id", "234");

        Element name = document.createElement("name");
        name.setTextContent("Waffles");

        food.appendChild(name);
        breakfastMenu.appendChild(food);
        document.appendChild(breakfastMenu);

        save2File(document);
    }

    private static void save2File(Document document) throws IOException, TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new FileWriter(FILE_NAME));
        transformer.transform(source, result);
    }

    private static Document getDocument() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }
}
