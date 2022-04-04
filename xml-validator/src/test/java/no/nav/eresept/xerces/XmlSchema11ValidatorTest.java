package no.nav.eresept.xerces;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.validation.Schema;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.fail;

public class XmlSchema11ValidatorTest {

    @Test
    public void testValidator() {
        try {
            Schema schema = XmlSchema11Validator.loadSchema(getStream("anyuri.xsd"));
            XmlSchema11Validator.validate(schema, getStream("anyuri.xml"), null);
        } catch (SAXException | IOException e) {
            fail("failed", e);
        }

    }

    private InputStream getStream(String name) throws IOException {
        File f = new File("src/test/resources/" + name);
        return new FileInputStream(f);
    }

}
