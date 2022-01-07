package textutils.intention;

import gameobjs.Area;
import textutils.TextToken;
import textutils.GameVerb;

public class Action {
    private GameVerb gameVerb;
    private TextToken token;

    public Action(TextToken token) {
        this.token = token;
        // assign the proper GameVerb to this Action
        for (GameVerb verb : GameVerb.values()) {
            for (String alias : verb.getAliases()) {
                if (this.token.getWord().equals(alias)) {
                    this.gameVerb = verb;
                    break;
                }
            }
        }
        if (gameVerb == null) this.gameVerb = GameVerb.VERB_NULL;
    }

    public GameVerb getGameVerb() {
        return gameVerb;
    }

    public TextToken getToken() {
        return token;
    }

    public void preformAction(Area context) {
        switch (gameVerb.getType()) {
            case NO_OBJ:

                break;
            case ONE_OBJ:

                break;
            case TWO_OBJ:

                break;
            case SYSTEM:

                break;
            case UNKNOWN:

                break;
        }
    }
}
