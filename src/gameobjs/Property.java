package gameobjs;

interface Acquirable {
    void transferItem(Item container);
    void transferItem(Area area);
    void transferItem(GameObject container);
}