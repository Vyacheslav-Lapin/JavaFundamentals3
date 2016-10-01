package sax;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.logging.Logger;

@FunctionalInterface
public interface LoggedHandler extends DefaultHandler {

    Logger getLogger();

    @Override
    default void startDocument() throws SAXException {
        getLogger().info("Parsing started.");
    }

    @Override
    default void endDocument() throws SAXException {
        getLogger().info("Parsing ended.");
    }

    @Override
    default void warning(SAXParseException e) throws SAXException {
        getLogger().warning(() -> "WARNING: line " + e.getLineNumber() + ": " + e.getMessage());
    }

    @Override
    default void error(SAXParseException e) throws SAXException {
        getLogger().severe(() -> "ERROR: line " + e.getLineNumber() + ": " + e.getMessage());
    }

    @Override
    default void fatalError(SAXParseException e) throws SAXException {
        getLogger().severe(() -> "FATAL: line " + e.getLineNumber() + ": " + e.getMessage());
        throw e;
    }
}