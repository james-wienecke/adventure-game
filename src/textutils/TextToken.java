package textutils;

public class TextToken {
    private final String word;
    // type may in future become an arraylist to allow preforming additional checks for most likely part if there is overlap
    private TextTokenType type;

    TextToken(String word) {
        this.word = word;
        assignTokenType();
    }

    public String getWord() {
        return word;
    }

    public TextTokenType getType() {
        return type;
    }

    private void assignTokenType() {
        switch (this.word) {
            case "key":
            case "book":
            case "brick":
            case "item":
            case "shirt":
            case "blouse":
            case "pants":
            case "shoe":
            case "shoes":
            case "room":
            case "phone":
            case "torch":
            case "box":
            case "container":
            case "chest":
            case "drawer":
            case "shelf":
            case "bookshelf":
            case "pod":
            case "house":
            case "fish":
            case "bread":
            case "quilt":
            case "north":
            case "northeast":
            case "northwest":
            case "south":
            case "southeast":
            case "southwest":
            case "east":
            case "west":
            case "inventory":
                this.type = TextTokenType.NOUN;
                break;
            case "go":
            case "climb":
            case "jump":
            case "eat":
            case "drink":
            case "hit":
            case "take":
            case "look":
            case "examine":
            case "search":
            case "use":
            case "move":
            case "return":
            case "retreat":
            case "grab":
            case "get":
            case "interact":
            case "touch":
            case "press":
            case "push":
                this.type = TextTokenType.VERB;
                break;
            case "red":
            case "green":
            case "blue":
            case "purple":
            case "yellow":
            case "orange":
            case "silver":
            case "gold":
            case "grimy":
            case "shiny":
            case "small":
            case "large":
            case "normal":
            case "good":
            case "bad":
            case "evil":
            case "dark":
            case "light":
            case "nice":
            case "dim":
            case "tall":
            case "short":
            case "tiny":
            case "heavy":
                this.type = TextTokenType.ADJECTIVE;
                break;
                //‘with’, ‘at’, ‘by’, ‘to’, ‘in’, ‘for’, ‘from’, ‘of’, ‘on’.
            case "with":
            case "at":
            case "by":
            case "to":
            case "in":
            case "for":
            case "from":
            case "of":
            case "on":
                this.type = TextTokenType.PREPOSITION;
                break;
            case "the":
            case "a":
            case "an":
            case "some":
            case "any":
            case "my":
            case "your":
            case "his":
            case "her":
            case "their":
            case "our":
            case "all":
            case "both":
            case "half":
            case "each":
            case "every":
            case "most":
            case "much":
            case "many":
                this.type = TextTokenType.DETERMINER;
                break;
            case "and":
            case "but":
            case "or":
                this.type = TextTokenType.CONJUNCTION;
                break;
            default:
                this.type = TextTokenType.UNKNOWN;
        }
    }

}