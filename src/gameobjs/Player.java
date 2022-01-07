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

    public String takeItem(Item target) {
        this.transferItem(this.getLocation().getContains(), target);
        StringBuffer sb = new StringBuffer("Got ").append(target.getNameWithAdjectives());
        System.out.println(this.getVisibleItems());
        return sb.toString();
    }
}
