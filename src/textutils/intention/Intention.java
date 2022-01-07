package textutils.intention;

import gameobjs.GameObject;
import gameobjs.Item;
import textutils.TextToken;
import textutils.TextTokenType;

import java.util.ArrayList;

public class Intention {
    private Action action;
    private Concept directObject;
    private Concept indirectObject;

    public Intention(TextToken[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            // process nouns
            if ((tokens[i].getType() == TextTokenType.NOUN) && directObject == null) {
                // first noun in sentence will be direct object of Intention
                // check backwards for adjectives to feed in to the Concept constructor
                if (i > 0) {
                    int j = i - 1;
                    ArrayList<TextToken> adjectives = new ArrayList<TextToken>();
                    while (tokens[j].getType() == TextTokenType.ADJECTIVE) {
                        adjectives.add(tokens[j]);
                        if (j - 1 < 0) {
                            break;
                        } else {
                            j--;
                        }
                    }
                    this.directObject = new Concept(tokens[i], adjectives);
                } else {
                    this.directObject = new Concept(tokens[i]);
                }
            } else if ((tokens[i].getType() == TextTokenType.NOUN) && directObject != null) {
                // this will be the indirect object
            }

            if ((tokens[i].getType() == TextTokenType.VERB) && action == null) {
                // we define the action that is attempting to be preformed
                this.action = new Action(tokens[i]);
            }

        }
    }

        public static void main(String[] args) {
        // player searches this testObject's contents to do something with an item inside
        GameObject testObj = new GameObject("test", "","a test container");
        // these three keys are the contents of testObject
        testObj.addToContainer(new Item("key", "big silver", "the wrong house key"));
        testObj.addToContainer(new Item("key", "small gold", "the right house key"));
        testObj.addToContainer(new Item("key", "", "another wrong house key"));

        TextToken[] testTokens = {new TextToken("small"), new TextToken("gold"), new TextToken("key")};

        Intention testIntent = new Intention(testTokens);
        System.out.println(testIntent.directObject.getTargetPlainText());
        testIntent.directObject.findTarget(testObj.getContains());

        if (testIntent.directObject.getTarget() != null) {
            System.out.println(testIntent.directObject.getTarget().getDescription());
        } else {
            System.out.println("no matches ;I");
        }
    }
}
