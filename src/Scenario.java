public class Scenario {

    public static Room demo() {
        Room startRoom = new Room("a dim wooden porch");
        startRoom.addItem(new Item("small modern-looking silver house key", "house key"));

        Room livingRoom = new Room("a drab and scarcely furnished living room that stinks of mildew");
        startRoom.addConnectingRoom("east", livingRoom);
        livingRoom.addItem(new Item("small retro television remote control", "tv remote"));

        Room kitchenRoom = new Room("a grimy little kitchen, infested with insects");
        kitchenRoom.addItem(new Item("plastic box of delicious fruit-flavored tide detergent pods", "container of tide pods"));
        livingRoom.addConnectingRoom("north", kitchenRoom);
    }
}
