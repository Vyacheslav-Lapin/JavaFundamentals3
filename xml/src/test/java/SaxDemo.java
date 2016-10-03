import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import xml.sax.MenuSaxHandler;
import xml.Food;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SaxDemo {
    @Test
    public void parse() throws Exception {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        MenuSaxHandler handler = new MenuSaxHandler();
        reader.setContentHandler(handler);
        reader.parse(new InputSource("src/test/resources/menu.xml"));

        List<Food> menu = handler.getFoods();

        assertThat(menu.size(), is(2));
    }
}
