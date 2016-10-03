package xml.stax;

import lombok.SneakyThrows;
import common.reflect.InvocationHandler;

import javax.xml.stream.XMLOutputFactory;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;

public interface XMLStreamWriter extends javax.xml.stream.XMLStreamWriter, AutoCloseable {

    @SneakyThrows
    static XMLStreamWriter get(FileWriter fileWriter) {

        javax.xml.stream.XMLStreamWriter xmlStreamWriter =
                XMLOutputFactory.newInstance().createXMLStreamWriter(fileWriter);

        return InvocationHandler.getProxyMakerFor(XMLStreamWriter.class)
                        .apply((proxy, method, chain, args) -> {
                            try {
                                return method.invoke(xmlStreamWriter, args);
//                                 return chain.apply(xmlStreamWriter); // TODO: 03/10/16 разобраться почему не работает
                            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                                throw new RuntimeException(e);
                            }
                        });
    }
}