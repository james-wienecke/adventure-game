public class Game {
    public Game() {
    }


    public void start() {
        System.out.println("Welcome to video game!");

        Room currentRoom = new Room();
        System.out.println(currentRoom.describeLocation());
    }
}
