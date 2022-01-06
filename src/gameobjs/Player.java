package gameobjs;

import utils.Direction;

public class Player extends Actor {
    public Player(String name, String adjectives, Area location, String description) {
        super(name, adjectives, location, description);
        this.getLocation().makeContainedItemsVisible();
    }

    @Override
    public void moveToAreaByDirection(Direction direction) {
        super.moveToAreaByDirection(direction);
        this.getLocation().makeContainedItemsVisible();
    }
}
