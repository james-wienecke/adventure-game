import java.util.Scanner;

public class Game {
    public Game() {
//        currentRoom = new Room();
        currentRoom = Scenario.demo();

    }

    public Room currentRoom;

    protected Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to video game!");

        System.out.println(currentRoom.describeLocation());

        String input = "";
        while (input.compareToIgnoreCase("quit") != 0) {
            System.out.print("> ");
            input = this.sc.nextLine();
            switch (input) {
                case "look around":
                    System.out.printf("%s\n", currentRoom.describeLocation());
                    break;
                case "search for items":
                    System.out.print(currentRoom.getVisibleItems());
                    break;
            }
        }
    }
}
