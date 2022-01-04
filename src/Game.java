import java.util.Scanner;

public class Game {
    public Game() {
//        this.currentRoom = Scenario.demo();
        this.player = new Player();
        player.location = Scenario.demo();
    }

//    public Room currentRoom;
    public Player player;

    // gonna do my best to only use the scanner in one class
    protected Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to video game!");

        System.out.println(player.location.describeLocation());

        String input = "";
        while (input.compareToIgnoreCase("quit") != 0) {
                System.out.print("> ");
                input = this.sc.nextLine();
                switch (input) {
                    case "look around":
                        System.out.printf("%s\n", player.location.describeLocation());
                        break;
                    case "search":
                        System.out.print(player.location.getVisibleItems());
                        break;
                    case "look at":
                        System.out.println("Look at what item?");
                        System.out.print("> ");
                        String itemQuery = sc.nextLine();
                        String itemQueryReply = "";
                        for (Item item : player.location.items) {
                            if (itemQuery.equalsIgnoreCase(item.getShortDescription()))
                                itemQueryReply = item.formatFullDescription();
                        }
                        if (itemQueryReply.isEmpty())
                            itemQueryReply = "I don't know what that is!";
                        System.out.println(itemQueryReply);
                        break;
                    case "check exits":
                        System.out.printf("%s\n", player.location.describeConnectingRooms());
                        break;
                    case "go":
                        System.out.println("Go where?");
                        System.out.print("> ");
                        String direction = sc.nextLine();
                        if (player.location.isValidConnection(direction)) {
                            player.location = player.location.getConnectingRoom(direction);
                            System.out.println(player.location.describeLocation());
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
