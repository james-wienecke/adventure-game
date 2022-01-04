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
                    case "check exits":
                        System.out.printf("%s\n", currentRoom.describeConnectingRooms());
                        break;
                    case "go":
                        System.out.println("Go where?");
                        System.out.print("> ");
                        String direction = sc.nextLine();
                        if (currentRoom.isValidConnectionDirection(direction)) {
                            currentRoom = currentRoom.getConnectingRoom(direction);
                            System.out.println(currentRoom.describeLocation());
                        } else {
                            System.out.println("Invalid direction.");
                        }
                        break;
                    case "quit":
                        System.out.println("Bye bye!");
                        break;
                    default:
                        System.out.println("I don't know how to do that.");
                }
        }
    }
}
