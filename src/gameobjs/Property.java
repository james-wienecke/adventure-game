package gameobjs;

import utils.Direction;

import java.util.ArrayList;

interface Acquirable {
    void transferItem(ArrayList<Item> formerContainer, Item item);
}

interface Mobile {
    void changeLocation(Area area);
    void moveToAreaByDirection(Direction direction);
}

interface Lookable {
    String lookAround();
}