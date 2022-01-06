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
        this.contains = new ArrayList<>();
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
        for (int i = 0; i < this.contains.size(); i++) {
            if (this.contains.get(i).isKnown()) {
                output.append(this.contains.get(i).getName());
                if (i < this.contains.size()) {
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
        for (Item item : this.contains) {
            if (!item.isKnown()) item.setKnown(true);
        }
    }

    public boolean hasItem(String itemName) {
        for (Item item : this.contains) {
            if (item.getName().equals(itemName))
                return true;
        }
        return false;
    }

    public boolean hasItem(Item itemLookup) {
        return this.contains.contains(itemLookup);
    }

    public Item lookupItemFromContains(String itemName) {
        int tgtIndex = -1;
        for (int i = 0; i < this.contains.size(); i++) {
            if (this.contains.get(i).getName().equals(itemName)) {
                tgtIndex = i;
                System.out.println("Found item");
            }
        }
        System.out.println(this.contains.get(tgtIndex).getName());
        return this.contains.get(tgtIndex);
    }

    public void transferItem(ArrayList<Item> formerContainer, Item item) {
            this.contains.add(item);
            formerContainer.remove(item);
    }
}
