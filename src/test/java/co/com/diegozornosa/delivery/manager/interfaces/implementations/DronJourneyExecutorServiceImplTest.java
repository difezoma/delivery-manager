package co.com.diegozornosa.delivery.manager.interfaces.implementations;

import co.com.diegozornosa.delivery.manager.exceptions.DeliveryException;
import co.com.diegozornosa.delivery.manager.interfaces.IDronJourneyExecutorService;
import co.com.diegozornosa.delivery.manager.utils.TextFileUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DronJourneyExecutorServiceImplTest {

    String resourcesPath;
    IDronJourneyExecutorService dronJourneyExecutorServiceImpl;

    @Before
    public void setUp() {
        dronJourneyExecutorServiceImpl = new DronJourneyExecutorServiceImpl();
        resourcesPath = "./src/test/resources/";
    }

    @Test
    public void testExecuteJourneyFileNamesLineListSuccess() throws Exception {
        List<String[]> journeyFileNamesLineList = TextFileUtils.readTextFile(resourcesPath.concat("dronJourneyFileNamesTestSuccess.txt"), ",");
        dronJourneyExecutorServiceImpl.executeJourneyFileNamesLineList(journeyFileNamesLineList);
    }

    @Test(expected = DeliveryException.class)
    public void testExecuteJourneyFileNamesLineListExtraDron() throws Exception {
        List<String[]> journeyFileNamesLineList = TextFileUtils.readTextFile(resourcesPath.concat("dronJourneyFileNamesTestExtraDron.txt"), ",");
        dronJourneyExecutorServiceImpl.executeJourneyFileNamesLineList(journeyFileNamesLineList);
    }

}