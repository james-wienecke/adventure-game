public class Item {
    public Item(String desc, String shortDesc) {
        this.description = desc;
        this.shortDescription = shortDesc;
    }

    public Item(String shortDesc) {
        this.description = shortDesc;
        this.shortDescription = shortDesc;
    }

    private String description;
    private String shortDescription;
    private boolean visible = true;

    public String formatFullDescription() {
        return String.format("This is a %s.", description);
    }

    public String formatBriefDescription() {
        return String.format("There is a %s.", shortDescription);
    }

    public boolean isVisible() {
        return visible;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
