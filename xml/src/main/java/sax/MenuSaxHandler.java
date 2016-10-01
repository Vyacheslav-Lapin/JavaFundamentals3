package sax;

import lombok.Getter;
import lombok.extern.java.Log;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;
import java.util.List;

@Log
public class MenuSaxHandler implements DefaultHandler {
    @Getter
    private List<Food> foodList = new ArrayList<>();
    private Food food;
    private StringBuilder text;

    @Override
    public void startDocument() throws SAXException {
        log.info("Parsing started.");
    }

    @Override
    public void endDocument() throws SAXException {
        log.info("Parsing ended.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        log.info(() -> "startElement -> " + "uri: " + uri + ", localName: " + localName + ", qName: " + qName);

        if (localName.equals("food"))
            food = new Food(Integer.parseInt(attributes.getValue("id")));
        else
            text = new StringBuilder();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (localName) {
            case "name": food.setName(text.toString()); break;
            case "price": food.setPrice(text.toString()); break;
            case "description": food.setDescription(text.toString()); break;
            case "calories": food.setCalories(Integer.parseInt(text.toString())); break;
            case "food": foodList.add(food); food = null;
        }
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        log.warning(() -> "WARNING: line " + e.getLineNumber() + ": " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        log.severe(() -> "ERROR: line " + e.getLineNumber() + ": " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        log.severe(() -> "FATAL: line " + e.getLineNumber() + ": " + e.getMessage());
        throw e;
    }
}
