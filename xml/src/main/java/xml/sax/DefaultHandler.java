package xml.sax;

import org.xml.sax.*;

public interface DefaultHandler extends ContentHandler, ErrorHandler {

    @Override
    default void setDocumentLocator(Locator locator) {
    }

    @Override
    default void startDocument() throws SAXException {
    }

    @Override
    default void endDocument() throws SAXException {
    }

    @Override
    default void startPrefixMapping(String prefix, String uri) throws SAXException {
    }

    @Override
    default void endPrefixMapping(String prefix) throws SAXException {
    }

    @Override
    default void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
    }

    @Override
    default void endElement(String uri, String localName, String qName) throws SAXException {
    }

    @Override
    default void characters(char[] ch, int start, int length) throws SAXException {
    }

    @Override
    default void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
    }

    @Override
    default void processingInstruction(String target, String data) throws SAXException {
    }

    @Override
    default void skippedEntity(String name) throws SAXException {
    }

    @Override
    default void warning(SAXParseException exception) throws SAXException {
    }

    @Override
    default void error(SAXParseException exception) throws SAXException {
    }

    @Override
    default void fatalError(SAXParseException exception) throws SAXException {
    }
}
