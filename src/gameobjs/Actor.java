package gameobjs;

import utils.Direction;

public abstract class Actor extends GameObject implements Mobile {

    public Actor(String name, String adjectives, Area location, String description) {
        super(name, adjectives, description);
        this.setLocation(location);
    }

    public void changeLocation(Area area) {
        this.setLocation(area);
    }

    public void moveToAreaByDirection(Direction direction) {
        if (this.getLocation().isValidConnection(direction)) {
            this.changeLocation(this.getLocation().getConnectingRoom(direction));
            this.getLocation().makeContainsVisible();
        }
    }
}
