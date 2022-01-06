import java.util.Arrays;

import gameobjs.Player;
import textutils.TextParser;
import utils.Direction;
import utils.Input;

public class Game {
    public Game() {
//        this.player = new Player();
//        player.setLocation(Scenario.demo2());
        this.player = new Player("Player", "", Scenario.demo2(), "this is you.");
    }

    public Player player;

    // gonna do my best to only use the scanner in one class
    protected Input sc = new Input();

    public void start() {
        System.out.println("Welcome to video game!");

        System.out.println(player.getLocation().getName());

        String input = "";
        while (input.compareToIgnoreCase("quit") != 0) {
                System.out.print("> ");
                input = this.sc.nextLine();
                switch (input) {
                    case "look around":
                        System.out.printf("%s\n", player.getLocation().getDescription());
                        break;
//                    case "search":
//                        if (player.getLocation().getVisibleItems().isEmpty())
//                            System.out.println("You don't see anything useful.");
//                        else
//                            System.out.print(player.getLocation().getVisibleItems());
//                        break;
//                    case "take":
//                        System.out.println("Take what item?");
//                        System.out.print("> ");
//                        String takeQuery = sc.nextLine();
//                        if (player.getLocation().hasItem(takeQuery)) {
//                            player.collectItem(takeQuery);
//                            System.out.printf("Took %s\n", takeQuery);
//                        } else {
//                            System.out.println("I can't find that item!");
//                        }
//                        break;
//                    case "look at":
//                        System.out.println("Look at what item?");
//                        System.out.print("> ");
//                        String itemQuery = sc.nextLine();
//                        String itemQueryReply = "";
//                        for (Item item : player.getLocation().items) {
//                            if (itemQuery.equalsIgnoreCase(item.getShortDescription()))
//                                itemQueryReply = item.formatFullDescription();
//                        }
//                        if (itemQueryReply.isEmpty())
//                            itemQueryReply = "I don't know what that is!";
//                        System.out.println(itemQueryReply);
//                        break;
//                    case "inventory":
//                        System.out.print(player.listFormatInventory());
//                        break;
                    case "check exits":
                        System.out.printf("%s\n", player.getLocation().describeConnectingRooms());
                        break;
                    case "go":
                        System.out.println("Go where?");
                        System.out.print("> ");
                        String in = sc.nextLine();
                        Direction dir;
                        switch (in) {
                            case "north":
                            case "n":
                                dir = Direction.N;
                                player.moveToAreaByDirection(dir);
                                System.out.println(player.getLocation().getDescription());
                                break;
                            case "east":
                            case "e":
                                dir = Direction.E;
                                player.moveToAreaByDirection(dir);
                                System.out.println(player.getLocation().getDescription());

                                break;
                            case "west":
                            case "w":
                                dir = Direction.W;
                                player.moveToAreaByDirection(dir);
                                System.out.println(player.getLocation().getDescription());

                                break;
                            case "south":
                            case "s":
                                dir = Direction.S;
                                player.moveToAreaByDirection(dir);
                                System.out.println(player.getLocation().getDescription());

                                break;
                            default:
                                System.out.println("Invalid direction");
                        }

//                        if (player.getLocation().isValidConnection(direction)) {
//                            player.setLocation(direction);
//                            System.out.println(player.getLocation().describeLocation());
//                        } else {
//                            System.out.println("Invalid direction.");
//                        }
                        break;
                    case "help":
                        System.out.println("Game help:");
                        System.out.println("[COMMANDS]");
                        System.out.println("\"help\": this command");
                        System.out.println("\"quit\": quit game");
                        System.out.println("\"go\": enter change location mode");
                        System.out.println("\"check exits\": list all visible connections to other rooms");
                        System.out.println("\"look around\": get a detailed description of the current room");
                        System.out.println("\"search\": list all visible items in the room");
                        System.out.println("\"take\": grab an item from the room and put it in your inventory");
                        System.out.println("\"look at\": enter item inspection mode");
                        System.out.println("----------------------------------------------------------------");
                        break;
                    case "quit":
                        System.out.println("Bye bye!");
                        break;
                    case "test":
                        TextParser.test();
                        // testing retrieval of previous input by 0-indexed reverse-order lookup
                        System.out.println(Arrays.toString(TextParser.getRawSentencesHistoryOrder()));
                        break;
                    default:
                        System.out.println("I don't know how to do that.");
                }
        }
    }

    private void win() {
        System.out.println("Congrats! YOU WIN!!!");
    }

    private void lose() {
        System.out.println("Congrats! You are a loser! But I still love you ♡");
    }
}
