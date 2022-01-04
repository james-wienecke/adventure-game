public class Item {
    public Item(String desc, String shortDesc) {
        this.description = desc;
        this.shortDescription = shortDesc;
    }

    private String description;
    private String shortDescription;
    // private boolean visible = true;

    public String formatFullDescription() {
        return String.format("This is a %s.", description);
    }

    public String formatBriefDescription() {
        return String.format("This is %s.", shortDescription);
    }

}
