import java.util.*;

public class Fleet {
    private final int boardSize;
    private final List<Ship> ships = new ArrayList<>();

    public Fleet(int boardSize) {
        this.boardSize = boardSize;
    }

    public boolean isValidPlacement(Ship ship) {
        if (hasShipOfType(ship.getType())) return false;
        for (Coordinate c : ship.getCoordinates()) {
            if (!isInBounds(c)) return false;
            if (isOccupied(c)) return false;
        }
        return true;
    }

    public boolean addShip(Ship ship) {
        if (!isValidPlacement(ship)) return false;
        ships.add(ship);
        return true;
    }

    public void removeShip(Ship ship) {
        ships.remove(ship);
    }

    public boolean isAllShipsPlaced() {
        return ships.size() == ShipType.values().length;
    }

    public boolean isAllShipsSunk() {
        if (ships.isEmpty()) return false;
        for (Ship s : ships) if (!s.isSunk()) return false;
        return true;
    }

    public List<Ship> getShips() {
        return Collections.unmodifiableList(ships);
    }

    // chỉ Fleet mới dùng các method này, để private

    // kiểm tra tàu có trong Board hay khônstat
    private boolean isInBounds(Coordinate c) {
        return c.getRow() >= 0 && c.getRow() < boardSize && c.getColumn() >= 0 && c.getColumn() < boardSize;
    }

    private boolean isOccupied(Coordinate c) {
        for (Ship s : ships) if (s.isOccupied(c)) return true;
        return false;
    }

    // kiểm tra Fleet đã có loại tàu ... chưa
    private boolean hasShipOfType(ShipType type) {
        for (Ship s : ships) if (s.getType() == type) return true;
        return false;
    }
}