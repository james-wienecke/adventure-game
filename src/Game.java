import java.util.Scanner;

public class Game {
    public Game() {
        currentRoom = Scenario.demo();
    }

    public Room currentRoom;

    // gonna do my best to only use the scanner in one class
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
                    case "search":
                        System.out.print(currentRoom.getVisibleItems());
                        break;
                    case "look at":
                        System.out.println("Look at what item?");
                        System.out.print("> ");
                        String itemQuery = sc.nextLine();
                        String itemQueryReply = "";
                        for (Item item : currentRoom.items) {
                            if (itemQuery.equalsIgnoreCase(item.getShortDescription()))
                                itemQueryReply = item.formatFullDescription();
                        }
                        if (itemQueryReply.isEmpty())
                            itemQueryReply = "I don't know what that is!";
                        System.out.println(itemQueryReply);
                        break;
                    case "check exits":
                        System.out.printf("%s\n", currentRoom.describeConnectingRooms());
                        break;
                    case "go":
                        System.out.println("Go where?");
                        System.out.print("> ");
                        String direction = sc.nextLine();
                        if (currentRoom.isValidConnection(direction)) {
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
