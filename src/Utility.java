public class Utility {

    public static String oppositeDirection(String direction) {
        switch (direction) {
            case "north":
                return "south";
            case "northeast":
                return "southwest";
            case "east":
                return "west";
            case "southeast":
                return "northwest";
            case "south":
                return "north";
            case "southwest":
                return "northeast";
            case "west":
                return "east";
            case "northwest":
                return "southeast";
        }
        return "bad value";
    }
}
