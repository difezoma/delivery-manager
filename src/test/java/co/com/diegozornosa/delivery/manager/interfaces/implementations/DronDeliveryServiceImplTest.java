package co.com.diegozornosa.delivery.manager.interfaces.implementations;

import co.com.diegozornosa.delivery.manager.exceptions.DeliveryException;
import co.com.diegozornosa.delivery.manager.interfaces.IDronDeliveryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DronDeliveryServiceImplTest {

    String resourcesPath;
    IDronDeliveryService dronDeliveryServiceImpl;

    @Before
    public void setUp() {
        dronDeliveryServiceImpl = new DronDeliveryServiceImpl();
        resourcesPath = "./src/test/resources/";
    }

    @Test
    public void testExecuteDronJourneySuccess() throws Exception {
        String result = dronDeliveryServiceImpl.executeDronJourney(resourcesPath.concat("inTest01Success.txt"));
        String expected = "== Reporte de entregas == \n\n" +
                "(-2, 4) dirección Occidente \n\n" +
                "(-1, 3) dirección Sur \n\n" +
                "(0, 0) dirección Occidente \n\n";
        Assert.assertEquals(expected, result);
    }

    @Test(expected = DeliveryException.class)
    public void testExecuteDronWithExtraCapacity() throws Exception {
        dronDeliveryServiceImpl.executeDronJourney(resourcesPath.concat("inTest01ExtraCapacity.txt"));
    }

    @Test(expected = DeliveryException.class)
    public void testExecuteDronJourneyExceedingBounds() throws Exception {
        dronDeliveryServiceImpl.executeDronJourney(resourcesPath.concat("inTest01OutOfBounds.txt"));
    }
}