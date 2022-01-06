package gameobjs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import utils.Direction;

public class Area extends GameObject {
    private Map<Direction, Area> connections;
    private boolean accessible;

    public Area(String name, String adjectives, String description) {
        super(name, adjectives, description);
        connections = new HashMap<>();
    }

    public void addConnectingArea(Area room, Direction direction) {
        connections.put(direction, room);
        room.addOneWayConnection(this, Direction.getOpposite(direction));
    }

    public void addOneWayConnection(Area room, Direction direction) {
        connections.put(direction, room);
    }

    public boolean isValidConnection(Direction direction) {
        return connections.containsKey(direction);
    }

    public Area getConnectingRoom(Direction direction) {
        return connections.get(direction);
    }

    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public String describeConnectingRooms() {
        StringBuilder output = new StringBuilder();
        Iterator<Map.Entry<Direction, Area>> i = this.connections.entrySet().iterator();

        while (i.hasNext()) {
            Map.Entry connection = i.next();
            output.append(String.format("To the %s, there is %s.",
                    connection.getKey().toString(),
                    ((Area) connection.getValue()).getName()));
            if (i.hasNext()) output.append('\n'); // skip newlines if this is the last room
        }
        return output.toString();
    }
}
