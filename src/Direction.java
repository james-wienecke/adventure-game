public enum Direction {
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
    WNW;

    private Direction opposite;
    static {
        NW.opposite = Direction.SE;
        NNW.opposite = Direction.SSE;
        N.opposite = Direction.S;
        NNE.opposite = Direction.SSW;
        NE.opposite = Direction.SW;
        ENE.opposite = Direction.WSW;
        E.opposite = Direction.W;
        ESE.opposite = Direction.WNW;
        SE.opposite = Direction.NW;
        SSE.opposite = Direction.NNW;
        S.opposite = Direction.N;
        SSW.opposite = Direction.NNE;
        SW.opposite = Direction.NE;
        WSW.opposite = Direction.ENE;
        W.opposite = Direction.E;
        WNW.opposite = Direction.ESE;
    }
}
