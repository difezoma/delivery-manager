package co.com.diegozornosa.delivery.manager.enums;

public enum DronDirectionEnum {

    N("Norte", "W", "E", 0, 1),
    E("Oriente","N", "S", 1, 0),
    S("Sur","E", "W", 0, -1),
    W("Occidente","S", "N", -1, 0);

    private final String orientationValue;
    private final String turnLeftOrientationValue;
    private final String turnRightOrientationValue;
    private final Integer coordinateX;
    private final Integer coordinateY;

    DronDirectionEnum(String orientationValue, String turnLeftOrientationValue, String turnRightOrientationValue, Integer coordinateX, Integer coordinateY) {
        this.orientationValue = orientationValue;
        this.turnLeftOrientationValue = turnLeftOrientationValue;
        this.turnRightOrientationValue = turnRightOrientationValue;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public String getOrientationValue() {
        return orientationValue;
    }

    public String getTurnLeftOrientationValue() {
        return turnLeftOrientationValue;
    }

    public String getTurnRightOrientationValue() {
        return turnRightOrientationValue;
    }

    public Integer getCoordinateX() {
        return coordinateX;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }

}
