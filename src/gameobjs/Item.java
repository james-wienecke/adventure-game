package gameobjs;

import java.util.ArrayList;

public class Item extends Entity implements Acquirable {
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
    public void addToContainer(Entity item) {
        if (isContainer)
            super.addToContainer(item);
    }

    @Override
    public void addToContainer(ArrayList<Entity> item) {
        if (isContainer)
            super.addToContainer(item);
    }
}
