import co.com.diegozornosa.delivery.manager.constants.DeliveryConstants;
import co.com.diegozornosa.delivery.manager.exceptions.DeliveryException;
import co.com.diegozornosa.delivery.manager.interfaces.IDronDeliveryService;
import co.com.diegozornosa.delivery.manager.interfaces.implementations.DronDeliveryServiceImpl;
import co.com.diegozornosa.delivery.manager.utils.BusinessUtils;
import co.com.diegozornosa.delivery.manager.utils.ReportUtils;
import co.com.diegozornosa.delivery.manager.utils.TextFileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DeliveryManagerApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryManagerApp.class);

    public static void main(String[] args) throws DeliveryException {

        LOGGER.info("**** Dron delivery app starts successfully ***");

        List<String[]> journeyFileNamesLineList = TextFileUtils.readTextFile(DeliveryConstants.DRON_JOURNEY_FILE_NAMES_PATH, ",");

        for(String[] journeyFileNameLine: journeyFileNamesLineList){
            BusinessUtils.validateMaxDronNumber(journeyFileNameLine.length);
            for(int i=1;i<=journeyFileNameLine.length;i++){
                try{
                    IDronDeliveryService dronDeliveryService = new DronDeliveryServiceImpl();
                    String report = dronDeliveryService.executeDronJourney(DeliveryConstants.DRON_JOURNEYS_FOLDER.concat(journeyFileNameLine[i-1]));
                    ReportUtils.generateDronJourneyReport(report, i);
                }catch(DeliveryException exception){
                    LOGGER.error("Ha ocurrido un error con el envío del dron. ".concat(exception.getMessage()));
                }
            }
        }

        LOGGER.info("**** Dron delivery app ends successfully ***");
    }

}
