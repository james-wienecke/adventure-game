import gameobjs.Area;
import gameobjs.Item;
import utils.Direction;

public class Scenario {

//    public static Room demo() {
//        Room startRoom = new Room("a dim wooden porch");
//        startRoom.addItem(new Item("small modern-looking silver house key", "house key"));
//
//        Room livingRoom = new Room("a drab and scarcely furnished living room that stinks of mildew");
//        startRoom.addConnectingRoom("east", livingRoom);
//        livingRoom.addItem(new Item("small retro television remote control", "tv remote"));
//
//        Room kitchenRoom = new Room("a grimy little kitchen, infested with insects");
//        kitchenRoom.addItem(new Item("plastic box of delicious fruit-flavored tide detergent pods", "container of tide pods"));
//        livingRoom.addConnectingRoom("north", kitchenRoom);
//
//        Room bedRoom = new Room("a comfy bedroom dominated by a queen-size bed with what looks to be a homemade quilt");
//        bedRoom.addItem(new Item("copy of \"Gravity's Rainbow\" by Thomas Pynchon", "book"));
//        bedRoom.addItem(new Item("purple classic Nintendo 3DS handheld game console", "3DS"));
//        livingRoom.addConnectingRoom("east", bedRoom);
//
//        return startRoom;
//    }


    public static Area demo2() {
        Area startRoom = new Area("porch", "dim", "a small and unremarkable wooden front porch of a rural home");
        Area livingRoom = new Area("livingroom", "cozy", "a snug little living room filled with old furniture");
        Area kitchen = new Area("kitchen", "bright", "an outdated and cramped kitchen that while not filthy, is also not spotlessly clean");

        startRoom.addConnectingArea(livingRoom, Direction.E);
        livingRoom.addConnectingArea(kitchen, Direction.N);

        startRoom.addToContainer(new Item("key", "shiny gold", "a small metal house key"));

        return startRoom;
    }
}
