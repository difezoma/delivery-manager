package co.com.diegozornosa.delivery.manager.interfaces.implementations;

import co.com.diegozornosa.delivery.manager.dtos.DronLocationDTO;
import co.com.diegozornosa.delivery.manager.enums.DronDirectionEnum;
import co.com.diegozornosa.delivery.manager.exceptions.DeliveryException;
import co.com.diegozornosa.delivery.manager.interfaces.IDronDeliveryService;
import co.com.diegozornosa.delivery.manager.utils.BusinessUtils;
import co.com.diegozornosa.delivery.manager.utils.ReportUtils;
import co.com.diegozornosa.delivery.manager.utils.TextFileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class DronDeliveryServiceImpl implements IDronDeliveryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DronDeliveryServiceImpl.class);

    private int coordinateX;
    private int coordinateY;
    private DronDirectionEnum dronDirection;

    private String report;

    private DronLocationDTO dronLocationDTO;

    public DronDeliveryServiceImpl() {
        coordinateX = 0;
        coordinateY = 0;
        dronDirection = DronDirectionEnum.N;
        report = "== Reporte de entregas == \n\n";
        dronLocationDTO = new DronLocationDTO();
    }

    @Override
    public String executeDronJourney(String dronJourneyFilePath) throws DeliveryException {

        LOGGER.info("Inicia ejecución de la ruta para el dron del archivo ".concat(dronJourneyFilePath));

        List<String[]> dronAddressList = TextFileUtils.readTextFile(dronJourneyFilePath, "");
        BusinessUtils.validateMaxLunchCapacity(dronAddressList.size());

        for(String[] address: dronAddressList) {
            executeDronAddressDelivery(address, dronLocationDTO);
            report = ReportUtils.generateAddressReport(dronLocationDTO, report);
        }

        LOGGER.info("Finaliza ejecución de la ruta para el dron del archivo ".concat(dronJourneyFilePath));

        return report;
    }

    private void executeDronAddressDelivery(String[] address, DronLocationDTO dronLocationDTO) throws DeliveryException {

        LOGGER.info(String.format("Inicia entrega del dron a la dirección con pasos %s, coordenadas (%s, %s, %s)",
                Arrays.toString(address), coordinateX, coordinateY, dronDirection.getOrientationValue()));

        for(String addressStep: address){
            switch (addressStep) {
                case "A":
                    BusinessUtils.validateMaxDronBlockDistance(coordinateX, coordinateY);
                    coordinateX += dronDirection.getCoordinateX();
                    coordinateY += dronDirection.getCoordinateY();
                    break;
                case "I":
                    dronDirection = DronDirectionEnum.valueOf(dronDirection.getTurnLeftOrientationValue());
                    break;
                case "D":
                    dronDirection = DronDirectionEnum.valueOf(dronDirection.getTurnRightOrientationValue());
                    break;
            }
        }

        dronLocationDTO.setCoordinateX(coordinateX);
        dronLocationDTO.setCoordinateY(coordinateY);
        dronLocationDTO.setOrientation(dronDirection.getOrientationValue());

        LOGGER.info(String.format("Finaliza entrega del dron a la dirección con pasos %s, coordenadas (%s, %s, %s)",
                Arrays.toString(address), coordinateX, coordinateY, dronDirection.getOrientationValue()));
    }


}
