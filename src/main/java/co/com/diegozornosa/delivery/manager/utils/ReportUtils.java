package co.com.diegozornosa.delivery.manager.utils;

import co.com.diegozornosa.delivery.manager.constants.DeliveryConstants;
import co.com.diegozornosa.delivery.manager.dtos.DronLocationDTO;
import co.com.diegozornosa.delivery.manager.exceptions.DeliveryException;

public class ReportUtils {

    public static String generateAddressReport(DronLocationDTO dronLocationDTO, String report){
        String routeLineReport = String.format("(%s, %s) dirección %s \n\n",
                dronLocationDTO.getCoordinateX(), dronLocationDTO.getCoordinateY(), dronLocationDTO.getOrientation());
        return report.concat(routeLineReport);
    }

    public static void generateDronJourneyReport(String report, int dronNumber) throws DeliveryException {
        String fileName = dronNumber < 10 ? "out0"+dronNumber+".txt" : "out"+dronNumber+".txt";
        TextFileUtils.writeTextFile(DeliveryConstants.DELIVERY_REPORTS_FOLDER, fileName, report);
    }

}
