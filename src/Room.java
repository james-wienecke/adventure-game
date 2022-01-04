public class Room {
    public Room() {
        description = "a small room";
    }

    private String description;

    public String describeLocation() {
        return String.format("You are in %s.", description);
    }
}
