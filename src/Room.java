import java.util.LinkedList;

public class Room {
    public Room() {
        this.description = "a small room";
        this.items = new LinkedList<Item>();
        this.addItem(new Item("painting of a young man with a sword wearing traditional Chinese robes", "painting"));
    }

    private String description;

    public String describeLocation() {
        return String.format("You are in %s.", description);
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public LinkedList<Item> items;
}
