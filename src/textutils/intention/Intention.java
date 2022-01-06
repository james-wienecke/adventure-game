package textutils.intention;

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
                    int j = i;
                    ArrayList<TextToken> adjectives = new ArrayList<TextToken>();
                    while (tokens[j].getType() == TextTokenType.ADJECTIVE && j > 0) {
                        adjectives.add(tokens[j]);
                        ++j;
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
}
