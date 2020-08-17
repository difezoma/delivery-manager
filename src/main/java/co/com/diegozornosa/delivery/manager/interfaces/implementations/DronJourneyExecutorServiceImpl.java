package co.com.diegozornosa.delivery.manager.interfaces.implementations;

import co.com.diegozornosa.delivery.manager.constants.DeliveryConstants;
import co.com.diegozornosa.delivery.manager.exceptions.DeliveryException;
import co.com.diegozornosa.delivery.manager.interfaces.IDronDeliveryService;
import co.com.diegozornosa.delivery.manager.interfaces.IDronJourneyExecutorService;
import co.com.diegozornosa.delivery.manager.utils.BusinessUtils;
import co.com.diegozornosa.delivery.manager.utils.ReportUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DronJourneyExecutorServiceImpl implements IDronJourneyExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DronJourneyExecutorServiceImpl.class);

    @Override
    public void executeJourneyFileNamesLineList(List<String[]> journeyFileNamesLineList) throws DeliveryException {

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

    }
}
