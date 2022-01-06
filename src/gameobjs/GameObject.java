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

    public void makeContainsVisible() {
        if (this.contains.size() > 0) {
            for (Item item : this.contains) {
                if (item.isKnown()) item.setKnown(true);
            }
        }
    }
}
