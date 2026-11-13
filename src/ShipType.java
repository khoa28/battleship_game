public enum ShipType {
    CARRIER(5) ,
    BATTLESHIP(4),
    CRUISER(3),
    SUBMARINE(3),
    DESTROYER(2);
    private final int shipSize;
    ShipType(int shipSize) {
        this.shipSize = shipSize;
    }
    public int getShipSize() {return shipSize;}
}
