package co.com.diegozornosa.delivery.manager.interfaces;

import co.com.diegozornosa.delivery.manager.exceptions.DeliveryException;

import java.util.List;

public interface IDronJourneyExecutorService {

    void executeJourneyFileNamesLineList(List<String[]> journeyFileNamesLineList) throws DeliveryException;

}
