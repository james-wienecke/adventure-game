public class Game {
    public Game() {
        currentRoom = new Room();
    }

    public Room currentRoom;

    public void start() {
        System.out.println("Welcome to video game!");

        System.out.println(currentRoom.describeLocation());

        for (Item item : currentRoom.items) {
            System.out.println(item.formatBriefDescription());
            System.out.println(item.formatFullDescription());
        }
    }
}
