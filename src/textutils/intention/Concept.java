package textutils.intention;

import gameobjs.GameObject;
import textutils.TextToken;
import java.util.ArrayList;

public class Concept {
    private GameObject target;
    private String targetPlainText;
    public Concept(TextToken noun) {
        this.targetPlainText = noun.getWord();
    }

    public Concept(TextToken noun, ArrayList<TextToken> adjectives) {
        StringBuffer sb = new StringBuffer();
        for (TextToken adj : adjectives) {
            sb.append(adj.getWord()).append(" ");
        }
        sb.append(noun.getWord());
        this.targetPlainText = sb.toString();
    }

    public static void main(String[] args) {
        TextToken adj1 = new TextToken("gold");
        TextToken adj2 = new TextToken("small");
        ArrayList<TextToken> adjs = new ArrayList<>();
        adjs.add(adj1);
        adjs.add(adj2);
        Concept concept = new Concept(new TextToken("key"), adjs);
        System.out.println(concept.targetPlainText);
    }
}
