package co.com.diegozornosa.delivery.manager.utils;

import co.com.diegozornosa.delivery.manager.constants.DeliveryConstants;
import co.com.diegozornosa.delivery.manager.exceptions.DeliveryException;

public class BusinessUtils {

    public static void validateMaxDronNumber(int dronCount) throws DeliveryException {
        if(dronCount > DeliveryConstants.MAX_DRON_NUMBER){
            String message = String.format("La cantidad de drones no puede ser mayor %s. Valor actual %s.", DeliveryConstants.MAX_DRON_NUMBER, dronCount);
            throw new DeliveryException(message);
        }
    }

    public static void validateMaxLunchCapacity(int dronAddressListSize) throws DeliveryException {
        if(dronAddressListSize > DeliveryConstants.MAX_DRON_LUNCH_CAPACITY){
            String message = String.format("La cantidad de almuerzos por dron no puede ser superior a %s. Cantidad actual de almuerzos %s.", DeliveryConstants.MAX_DRON_LUNCH_CAPACITY, dronAddressListSize);
            throw new DeliveryException(message);
        }
    }

    public static void validateMaxDronBlockDistance(int coordinateX, int coordinateY) throws DeliveryException {
        if(coordinateX >= DeliveryConstants.MAX_DRON_BLOCK_DISTANCE || coordinateY >= DeliveryConstants.MAX_DRON_BLOCK_DISTANCE){
            String message = String.format("El dron solo puede desplazarse %s cuadras a la redonda ubicación actual (%s, %s)", DeliveryConstants.MAX_DRON_BLOCK_DISTANCE, coordinateX, coordinateY);
            throw new DeliveryException(message);
        }
    }



}
