package textutils.intention;

import gameobjs.Item;
import textutils.TextToken;

import java.util.ArrayList;
import java.util.Arrays;

public class Concept {
    private Item target;
    private String targetPlainText;
    private TextToken noun;
    private ArrayList<TextToken> adjectives;
    private String[] rawAdjs;
    public Concept(TextToken noun) {
        this.noun = noun;
        this.targetPlainText = this.noun.getWord();
    }

    public Concept(TextToken noun, ArrayList<TextToken> adjectives) {
        this.noun = noun;
        this.adjectives = adjectives;
        this.rawAdjs = new String[adjectives.size()];
        for (int i = 0; i < adjectives.size(); i++) {
            this.rawAdjs[i] = adjectives.get(i).getWord();
        }
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
        // narrow down the target by trying to remove candidates that do not have the right adjectives
        if (candidates.size() > 1 && adjectives != null) {
            candidates.removeIf(this::noAdjectivesMatch);
        }
        // if adjectives still can't narrow it down enough, targeting fails
        if (candidates.size() > 1) {
            // temporary conditional result, will be replaced when normal input produces expected output
            System.out.println("You need to be more specific");
            this.target = null;
        } else {
            // if all candidates have been eliminated, targeting fails
            if (candidates.size() == 0) {
                this.target = null;
            } else {
                // good end, we found our target
                this.target = candidates.get(0);
            }
        }
    }

    private boolean noAdjectivesMatch(Item item) {
//        int potentialMatches = item.getAdjectives().length;
        int negativeMatches = 0;
        for (String itemAdj : item.getAdjectives()) {
            if (Arrays.stream(this.rawAdjs).noneMatch(adj -> adj.equals(itemAdj))) {
                negativeMatches++;
            }
        }
        return negativeMatches == item.getAdjectives().length;
    }
//
//    public static void main(String[] args) {
//        // player searches this testObject's contents to do something with an item inside
//        GameObject testObj = new GameObject("test", "","a test container");
//        // these three keys are the contents of testObject
//        testObj.addToContainer(new Item("key", "big silver", "the wrong house key"));
//        testObj.addToContainer(new Item("key", "small gold", "the right house key"));
//        testObj.addToContainer(new Item("key", "", "another wrong house key"));
//
//        // the player specified these two adjectives to target a specific key
//        // input was "adj1 adj2 key"
//        TextToken adj1 = new TextToken("gold");
//        TextToken adj2 = new TextToken("big");
//        ArrayList<TextToken> adjs = new ArrayList<>();
//        adjs.add(adj1);
//        adjs.add(adj2);
//        // a Concept was created of a "key" with the adjectives provided
//        Concept concept = new Concept(new TextToken("key"), adjs);
//
//        // concept attempts to find intended target of player's Intention
//        concept.findTarget(testObj.getContains());
//
//        if (concept.getTarget() != null) {
//            System.out.println(concept.getTarget().getDescription());
//        } else {
//            System.out.println("no matches ;I");
//        }
//    }
}
