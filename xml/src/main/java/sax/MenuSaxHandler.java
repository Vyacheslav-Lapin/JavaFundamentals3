package sax;

import lombok.Getter;
import lombok.extern.java.Log;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Log
public class MenuSaxHandler implements LoggedHandler {

    @Getter
    private List<Food> foodList = new ArrayList<>();
    private Food.FoodBuilder foodBuilder;
    private StringBuilder text;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        log.info(() -> "startElement -> " + "uri: " + uri + ", localName: " + localName);

        if (localName.equals("food"))
            foodBuilder = Food.builder().id(Integer.parseInt(attributes.getValue("id")));
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
            case "name":
                foodBuilder.name(text.toString());
                break;
            case "price":
                foodBuilder.price(text.toString());
                break;
            case "description":
                foodBuilder.description(text.toString());
                break;
            case "calories":
                foodBuilder.calories(Integer.parseInt(text.toString()));
                break;
            case "food":
                foodList.add(foodBuilder.build());
                foodBuilder = null;
        }
    }

    @Override
    public Logger getLogger() {
        return log;
    }
}