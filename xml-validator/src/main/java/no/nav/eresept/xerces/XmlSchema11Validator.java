package no.nav.eresept.xerces;

import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import org.apache.xerces.jaxp.validation.XMLSchema11Factory;
import org.apache.xerces.impl.Constants;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class XmlSchema11Validator {

    private static final SchemaFactory FACTORY = XMLSchema11Factory.newInstance(Constants.W3C_XML_SCHEMA11_NS_URI);

    private XmlSchema11Validator() {}

    public static void validate(final Schema schema, InputStream inputStream, final ErrorHandler errorHandler) throws IOException, SAXException {
            final Validator validator = schema.newValidator();
            validator.setErrorHandler(errorHandler);
            final SAXSource source = new SAXSource(
                    new InputSource(inputStream));
            validator.validate(source);
    }

    public static Schema loadSchema(String name) throws SAXException {
        return FACTORY.newSchema(new File(name));
    }

    public static Schema loadSchema(URL url) throws SAXException {
        return FACTORY.newSchema(url);
    }

    public static Schema loadSchema(InputStream inputStream) throws SAXException {
        return FACTORY.newSchema(new StreamSource(inputStream));
    }
}
