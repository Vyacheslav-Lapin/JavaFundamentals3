package xml.stax;

import org.junit.Test;

import java.io.FileWriter;

public class MenuWriterTest {

    @Test
    public void writeWorks() throws Exception {

        try (FileWriter fileWriter = new FileWriter("src/test/resources/new-menu.xml");
            XMLStreamWriter writer = XMLStreamWriter.get(fileWriter)) {

            writer.writeStartDocument();
            writer.writeStartElement("document");
            writer.writeStartElement("data");
            writer.writeAttribute("name", "value");
            writer.writeCharacters("content");
            writer.writeEndElement();
            writer.writeEndElement();
            writer.writeEndDocument();

            writer.flush(); // TODO: 03/10/16 try delete
        }
    }
}
