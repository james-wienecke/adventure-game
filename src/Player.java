import java.util.LinkedList;

public class Player {
    public Player() {
        this.name = "Debug";
        this.inventory = new LinkedList<Item>();
    }

    public String name;
    private Room location;
    private LinkedList<Item> inventory;

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public Item takeItem(String itemQuery) {
        Item item = this.location.getItemFromLocation(itemQuery);
        this.location.removeItem(itemQuery);
        return item;
    }

    public void collectItem(String itemQuery) {
        this.addItemToInventory(takeItem(itemQuery));
    }

    public void setLocation(Room room) {
        this.location = room;
    }

    public void setLocation(String direction) {
        this.location = this.location.getConnectingRoom(direction);
    }

    public Room getLocation() {
        return this.location;
    }

    public String listFormatInventory() {
        StringBuilder output = new StringBuilder();
        for (Item item : this.inventory) {
            output.append(String.format("You have a %s\n", item.getShortDescription()));
        }
        return output.toString();
    }
}
