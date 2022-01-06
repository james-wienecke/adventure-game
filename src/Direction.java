public enum Direction {
    // compass directions
    NW,
    NNW,
    N,
    NNE,
    NE,
    ENE,
    E,
    ESE,
    SE,
    SSE,
    S,
    SSW,
    SW,
    WSW,
    W,
    WNW,
    // relative directions
    UP,
    DOWN,
    LEFT,
    RIGHT,
    FRONT,
    BACK;

    private Direction opposite;
    static {
        NW.opposite = SE;
        NNW.opposite = SSE;
        N.opposite = S;
        NNE.opposite = SSW;
        NE.opposite = SW;
        ENE.opposite = WSW;
        E.opposite = W;
        ESE.opposite = WNW;
        SE.opposite = NW;
        SSE.opposite = NNW;
        S.opposite = N;
        SSW.opposite = NNE;
        SW.opposite = NE;
        WSW.opposite = ENE;
        W.opposite = E;
        WNW.opposite = ESE;

        UP.opposite = DOWN;
        DOWN.opposite = UP;
        LEFT.opposite = RIGHT;
        RIGHT.opposite = LEFT;
        FRONT.opposite = BACK;
        BACK.opposite = FRONT;
    }
}
