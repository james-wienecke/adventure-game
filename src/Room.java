import java.util.LinkedList;

public class Room {
    public Room() {
        this.description = "a small room";
        this.items = new LinkedList<Item>();
        this.addItems(itemTestList());
    }

    private String description;

    public String describeLocation() {
        return String.format("You are in %s.", description);
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void addItems(LinkedList<Item> items) {
        this.items.addAll(items);
    }

    public LinkedList<Item> items;

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

    private LinkedList<Item> itemTestList() {
        LinkedList<Item> testItems = new LinkedList<Item>();
        testItems.add(new Item("painting of a young man with a sword wearing traditional Chinese robes", "painting"));
        testItems.add(new Item("silver-white Chinese stringed instrument", "guqin"));
        testItems.add(new Item("dog food bag"));
        return testItems;
    }
}
