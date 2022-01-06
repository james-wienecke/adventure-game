package gameobjs;

import utils.Direction;

interface Acquirable {
    void transferItem(Item container);
    void transferItem(Area area);
    void transferItem(GameObject container);
}

interface Mobile {
    void changeLocation(Area area);
    void moveToAreaByDirection(Direction direction);
}