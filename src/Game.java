public class Game {
    public Game() {
        description =  "a small room";
    }

    public String description;

    public void start() {
        System.out.println("Welcome to video game!");
        System.out.println(describeLocation());
    }

    private String describeLocation() {
        return String.format("You are in %s.", description);
    }
}
