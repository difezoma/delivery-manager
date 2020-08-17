import co.com.diegozornosa.delivery.manager.constants.DeliveryConstants;
import co.com.diegozornosa.delivery.manager.exceptions.DeliveryException;
import co.com.diegozornosa.delivery.manager.interfaces.IDronJourneyExecutorService;
import co.com.diegozornosa.delivery.manager.interfaces.implementations.DronJourneyExecutorServiceImpl;
import co.com.diegozornosa.delivery.manager.utils.TextFileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DeliveryManagerApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryManagerApp.class);
    private static final IDronJourneyExecutorService dronJourneyExecutorService = new DronJourneyExecutorServiceImpl();

    public static void main(String[] args) throws DeliveryException {

        LOGGER.info("**** Dron delivery app starts successfully ***");

        List<String[]> journeyFileNamesLineList = TextFileUtils.readTextFile(DeliveryConstants.DRON_JOURNEY_FILE_NAMES_PATH, ",");
        dronJourneyExecutorService.executeJourneyFileNamesLineList(journeyFileNamesLineList);

        LOGGER.info("**** Dron delivery app ends successfully ***");
    }

}
