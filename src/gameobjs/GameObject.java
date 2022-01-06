package gameobjs;

import java.util.ArrayList;

public class GameObject {
    private String name;
    private String[] adjectives;
    private String description;
    private ArrayList<Item> contains;
    private Area location;
    private boolean isKnown;

    public GameObject(String name, String adjectives, String description) {
        this.name = name;
        this.adjectives = adjectives.split(" ");
        this.description = description;
        contains = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String[] getAdjectives() {
        return adjectives;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdjectives(String[] adjectives) {
        this.adjectives = adjectives;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addToContainer(Item item) {
        this.contains.add(item);
    }

    public void addToContainer(ArrayList<Item> item) {
        this.contains.addAll(item);
    }

    public void setLocation(Area area) {
        this.location = area;
    }

    public Area getLocation() {
        return this.location;
    }

    public ArrayList<Item> getContains() { return this.contains; }

    public String getVisibleItems() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < contains.size(); i++) {
            if (contains.get(i).isKnown()) {
                output.append(contains.get(i).getName());
                if (i < contains.size()) {
                    output.append("\n");
                }
            }
        }
        return output.toString();
    }

    public boolean isKnown() {
        return isKnown;
    }

    public void setKnown(boolean known) {
        isKnown = known;
    }

    public void makeContainedItemsVisible() {
        for (Item item : contains) {
            if (!item.isKnown()) item.setKnown(true);
        }
    }

    public boolean hasItem(String itemName) {
        for (Item item : contains) {
            if (item.getName().equals(itemName))
                return true;
        }
        return false;
    }

    public boolean hasItem(Item itemLookup) {
        return contains.contains(itemLookup);
    }

    public void transferItem(ArrayList<Item> formerContainer, Item item) {
        if (hasItem(item)) {
            addToContainer(this.contains);
            formerContainer.remove(item);
        }
    }
}
