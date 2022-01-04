public class Item {
    public Item(String desc, String shortDesc) {
        this.description = desc;
        this.shortDescription = shortDesc;
    }

    private String description;
    private String shortDescription;
    private boolean visible = true;
}
