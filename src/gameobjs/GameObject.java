package gameobjs;

import java.util.ArrayList;

public class GameObject implements Lookable {
    private String name;
    private String[] adjectives;
    private String description;
    private ArrayList<Entity> contains;
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

    public void addToContainer(Entity obj) {
        this.contains.add(obj);
    }

    public void addToContainer(ArrayList<Entity> obj) {
        this.contains.addAll(obj);
    }

    public void setLocation(Area area) {
        this.location = area;
    }

    public Area getLocation() {
        return this.location;
    }

    public ArrayList<Entity> getContains() { return this.contains; }

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
        for (Entity item : this.contains) {
            if (!item.isKnown()) item.setKnown(true);
        }
    }

    public boolean hasItem(String itemName) {
        for (Entity item : this.contains) {
            if (item.getName().equals(itemName))
                return true;
        }
        return false;
    }

    public boolean hasItem(Entity itemLookup) {
        return this.contains.contains(itemLookup);
    }

    public Entity lookupItemFromContains(String itemName) {
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

    public void transferItem(ArrayList<Entity> formerContainer, Entity item) {
            this.contains.add(item);
            formerContainer.remove(item);
    }

    public String getNameWithAdjs() {
        StringBuffer sb = new StringBuffer();
        for (String adj : this.adjectives) {
            sb.append(adj).append(' ');
        }
        return sb.append(this.name).toString();
    }

    public boolean isNowAContainer() {
        return this.contains.size() > 0;
    }

    public String lookAround() {
        StringBuffer sb = new StringBuffer("You see ").append(this.description);
        sb.append("\nInside this, you see: ");
        if (this.contains.size() > 0) {
            for (Entity obj : this.contains) {
                sb.append('\n').append(obj.getNameWithAdjs());
            }
        } else {
            sb.append("nothing\n");
        }

        return sb.toString();
    }

    public String takeItem(Entity target) {
        this.transferItem(this.getLocation().getContains(), target);
        StringBuffer sb = new StringBuffer("Got ").append(target.getNameWithAdjs());
        return sb.toString();
    }

    public String dropItem(Entity target) {
        this.getLocation().transferItem(this.getContains(), target);
        StringBuffer sb = new StringBuffer("Dropped ").append(target.getNameWithAdjs());
        return sb.toString();
    }

    public String examineItem(Entity target) {
        return target.getDescription();
    }
}
