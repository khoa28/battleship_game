import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ship {
    private final ShipType type;
    private final Set<Coordinate> coordinates;
    private final Orientation orientation;
    private final Set<Coordinate> hits = new HashSet<>();

    public Ship(ShipType type, List<Coordinate> coordinates, Orientation orientation) {
        Set<Coordinate> unique = Set.copyOf(coordinates);
        if (unique.size() != type.getShipSize()
                || coordinates.size() != unique.size()) {
            throw new IllegalArgumentException(
                    "Ship " + type + " needs exactly " + type.getShipSize()
                            + " distinct coordinates");
        }
        this.type = type;
        this.coordinates = unique;
        this.orientation = orientation;
    }

    public boolean isOccupied(Coordinate c) {
        return coordinates.contains(c);
    }

    public boolean registerHit(Coordinate c) {
        if (!isOccupied(c)) return false;
        return hits.add(c);          // add() trả false nếu đã bắn rồi
    }

    public boolean isSunk() {
        return hits.size() == coordinates.size();
    }
}