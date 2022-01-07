package gameobjs;

import utils.Direction;

import java.util.ArrayList;

interface Acquirable {
    void transferItem(ArrayList<Entity> formerContainer, Entity item);
}

interface Mobile {
    void changeLocation(Area area);
    void moveToAreaByDirection(Direction direction);
}

interface Lookable {
    String lookAround();
}

