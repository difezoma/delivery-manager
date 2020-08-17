package co.com.diegozornosa.delivery.manager.interfaces;

import co.com.diegozornosa.delivery.manager.exceptions.DeliveryException;

public interface IDronDeliveryService {

    String executeDronJourney(String dronJourneyFilePath) throws DeliveryException;

}
