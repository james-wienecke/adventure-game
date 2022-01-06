package gameobjs;

import java.util.Map;
import utils.Direction;

public class Area extends GameObject {
    private Map<Direction, Area> connections;
    private boolean accessible;

    public Area(String name, String adjectives, String description) {
        super(name, adjectives, description);
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
}
