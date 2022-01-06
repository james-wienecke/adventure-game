package gameobjs;

import java.util.ArrayList;

public class Item extends GameObject implements Acquirable {
    private boolean isContainer = false;
    private boolean isKnown = false;

    public Item(String name, String adjectives, String description) {
        super(name, adjectives, description);
    }

    public Item(String name, String adjectives, String description, boolean isContainer) {
        super(name, adjectives, description);
        this.isContainer = isContainer;
    }

    @Override
    public void addToContainer(Item item) {
        if (isContainer)
            super.addToContainer(item);
    }

    @Override
    public void addToContainer(ArrayList<Item> item) {
        if (isContainer)
            super.addToContainer(item);
    }

    @Override
    public void transferItem(Item container) {
        container.addToContainer(this);
    }

    @Override
    public void transferItem(GameObject container) {
        container.addToContainer(this);
    }

    @Override
    public void transferItem(Area area) {
        area.addToContainer(this);
    }
}
