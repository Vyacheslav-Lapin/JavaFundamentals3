package xml.stax;

import lombok.extern.java.Log;
import org.junit.Test;
import xml.Food;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.FileInputStream;
import java.io.InputStream;

@Log
public class StAXMenuParserTest {

    @Test
    public void itWorks() throws Exception {
        try (InputStream input = new FileInputStream("src/test/resources/menu.xml")) {
            StAXMenuParser.process(XMLInputFactory.newInstance().createXMLStreamReader(input)).stream()
                    .map(Food::toString)
                    .forEach(log::info);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}