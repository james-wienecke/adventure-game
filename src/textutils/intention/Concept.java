package textutils.intention;

import gameobjs.GameObject;
import gameobjs.Item;
import textutils.TextToken;

import java.util.ArrayList;

public class Concept {
    private Item target;
    private String targetPlainText;
    private TextToken noun;
    private ArrayList<TextToken> adjectives;
    public Concept(TextToken noun) {
        this.noun = noun;
        this.targetPlainText = this.noun.getWord();
    }

    public Concept(TextToken noun, ArrayList<TextToken> adjectives) {
        this.noun = noun;
        this.adjectives = adjectives;
        StringBuffer sb = new StringBuffer();
        for (TextToken adj : this.adjectives) {
            sb.append(adj.getWord()).append(" ");
        }
        sb.append(noun.getWord());
        this.targetPlainText = sb.toString();
    }

    public Item getTarget() {
        return target;
    }

    public String getTargetPlainText() {
        return targetPlainText;
    }

    public TextToken getNoun() {
        return noun;
    }

    public ArrayList<TextToken> getAdjectives() {
        return adjectives;
    }

    public void findTarget(ArrayList<Item> gameObjectArrayList) {
        ArrayList<Item> candidates = new ArrayList<>();
        for (Item obj : gameObjectArrayList) {
            if (obj.getName().equalsIgnoreCase(this.noun.getWord())) {
                candidates.add(obj);
            }
        }
        if (candidates.size() > 1 && adjectives != null) {
            // narrow down candidates using adjectives if possible
            for (Item obj : candidates) {
                // compare each adjective in current Item
                for (String canAdj : obj.getAdjectives()) {
                    // to each adjective in the Concept
                    for (TextToken adj : adjectives) {
                        // if it does not have the adjective, remove it from the candidate list
                        if (!canAdj.equalsIgnoreCase(adj.getWord())) {
                            candidates.remove(obj);
                        }
                    }
                }
            }
            if (candidates.size() > 1) {
                // temporary conditional result, will be replaced when normal input produces expected output
                System.out.println("You need to be more specific");
            }
        }
        this.target = candidates.get(0);
    }

    public static void main(String[] args) {
//        TextParser down testing
        GameObject testObj = new GameObject("test", "","a test container");
        testObj.addToContainer(new Item("key", "big silver", "the wrong house key"));
        testObj.addToContainer(new Item("key", "small gold", "the right house key"));
        testObj.addToContainer(new Item("key", "", "another wrong house key"));
        TextToken adj1 = new TextToken("gold");
        TextToken adj2 = new TextToken("small");
        ArrayList<TextToken> adjs = new ArrayList<>();
        adjs.add(adj1);
        adjs.add(adj2);
        Concept concept = new Concept(new TextToken("key"), adjs);

        concept.findTarget(testObj.getContains());

        System.out.println(concept.getTarget().getDescription());
    }
}
