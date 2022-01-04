public class Utility {

    public static String oppositeDirection(String direction) {
        String opposite ="";
        switch (direction) {
            case "north":
                opposite = "south";
                break;
            case "northeast":
                opposite = "southwest";
                break;
            case "east":
                opposite = "west";
                break;
            case "southeast":
                opposite = "northwest";
                break;
            case "south":
                opposite = "north";
                break;
            case "southwest":
                opposite = "northeast";
                break;
            case "west":
                opposite = "east";
                break;
            case "northwest":
                opposite = "southeast";
        }
        return opposite;
    }
}
