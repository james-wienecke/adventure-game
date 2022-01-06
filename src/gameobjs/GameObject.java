package gameobjs;

import java.util.ArrayList;

public class GameObject {
    private String name;
    private String[] adjectives;
    private String description;
    private ArrayList<GameObject> contains;
    private Area location;

    public GameObject(String name, String adjectives, String description) {
        this.name = name;
        this.adjectives = adjectives.split(" ");
        this.description = description;
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

    public void addToContainer(GameObject object) {
        this.contains.add(object);
    }

    public void addToContainer(ArrayList<GameObject> objects) {
        this.contains.addAll(objects);
    }

    public void setLocation(Area area) {
        this.location = area;
    }

    public Area getLocation() {
        return this.location;
    }
}
