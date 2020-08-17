package co.com.diegozornosa.delivery.manager.constants;

public class DeliveryConstants {

    //Paths
    public static final String SOURCE_PATH_PREFIX = "./src/main/resources/";
    public static final String DRON_JOURNEY_FILE_NAMES_PATH = SOURCE_PATH_PREFIX.concat("dronJourneyFileNames.txt");
    public static final String DELIVERY_REPORTS_FOLDER = SOURCE_PATH_PREFIX.concat("delivery-reports/");
    public static final String DRON_JOURNEYS_FOLDER = SOURCE_PATH_PREFIX.concat("dron-journeys/");

    //Business rules
    public static final int MAX_DRON_NUMBER = 20;
    public static final int MAX_DRON_LUNCH_CAPACITY = 3;
    public static final int MAX_DRON_BLOCK_DISTANCE = 10;

}
