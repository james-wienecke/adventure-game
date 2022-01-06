package gameobjs;

import java.util.ArrayList;

public class Item extends GameObject implements Acquirable {
    private boolean isContainer = false;

    public Item(String name, String adjectives, String description) {
        super(name, adjectives, description);
    }

    public Item(String name, String adjectives, String description, boolean isContainer) {
        super(name, adjectives, description);
        this.isContainer = isContainer;
    }

    @Override
    public void addToContainer(GameObject object) {
        if (isContainer)
            super.addToContainer(object);
    }

    @Override
    public void addToContainer(ArrayList<GameObject> objects) {
        if (isContainer)
            super.addToContainer(objects);
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
