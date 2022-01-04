import java.util.LinkedList;

public class Player {
    public Player() {
        this.name = "Debug";
        this.inventory = new LinkedList<Item>();
    }

    public String name;
    public Room location;
    private LinkedList<Item> inventory;

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public void setLocation(Room room) {
        this.location = room;
    }
}
