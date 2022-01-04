import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Room {
    public Room() {
        this("a blank room");
    }

    public Room(String description) {
        this.description = description;
        this.items = new LinkedList<Item>();
        this.connections = new HashMap<String, Room>();
    }

    private String description;

    public String describeLocation() {
        return String.format("You are in %s.", description);
    }

    private String descriptionEntrance = "a dimly lit room";

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void addItems(LinkedList<Item> items) {
        this.items.addAll(items);
    }

    public LinkedList<Item> items;
    public HashMap<String, Room> connections;

    public String getVisibleItems() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isVisible()) {
                output.append(items.get(i).formatBriefDescription());
                if (i < items.size()) {
                    output.append("\n");
                }
            }
        }
        return output.toString();
    }

    public void addConnectingRoom(String direction, Room room) {
        connections.put(direction, room);
        room.addOneWayConnection(Utility.oppositeDirection(direction), this);
    }

    public void addOneWayConnection(String direction, Room room) {
        connections.put(direction, room);
    }

    public boolean isValidConnectionDirection(String direction) {
        return connections.containsKey(direction);
    }

    public Room getConnectingRoom(String direction) {
        return connections.get(direction);
    }


    public String describeConnectingRooms() {
        StringBuilder output = new StringBuilder();
        Iterator<Map.Entry<String, Room>> i = this.connections.entrySet().iterator();

        while (i.hasNext()) {
            Map.Entry connection = i.next();
            output.append(String.format("To the %s, there is %s.", connection.getKey(), ((Room) connection.getValue()).getDescriptionEntrance()));
            if (i.hasNext()) output.append("\n");
        }

        return output.toString();
    }

    public String getDescriptionEntrance() {
        return descriptionEntrance;
    }

    private LinkedList<Item> itemTestList() {
        LinkedList<Item> testItems = new LinkedList<Item>();
        testItems.add(new Item("painting of a young man with a sword wearing traditional Chinese robes", "painting"));
        testItems.add(new Item("silver-white Chinese stringed instrument", "guqin"));
        testItems.add(new Item("dog food bag"));
        return testItems;
    }
}
