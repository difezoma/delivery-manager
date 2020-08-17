package co.com.diegozornosa.delivery.manager.utils;

import co.com.diegozornosa.delivery.manager.exceptions.DeliveryException;
import org.junit.Test;

public class TextFileUtilsTest {

    @Test(expected = DeliveryException.class)
    public void testReadTextFile() throws Exception {
        TextFileUtils.readTextFile("notFound.txt", "regex");
    }

    @Test(expected = DeliveryException.class)
    public void testWriteTextFile() throws Exception {
        TextFileUtils.writeTextFile("Z://notFound.txt", "fileName", "text");
    }
}