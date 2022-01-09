package textutils;

import gameobjs.Area;
import gameobjs.Entity;
import textutils.intention.Intention;

import java.util.Locale;

public class Sentence {
    private final String rawString;
    private final String[] words;
    private TextToken[] tokens;
    private Intention intention;

    Sentence(String input) {
        this.rawString = input;
        this.words = input.toLowerCase(Locale.ROOT).split(" ");
        tokens = new TextToken[words.length];
        for (int i = 0; i < words.length; i++) {
            tokens[i] = new TextToken(words[i]);
        }

        intention = new Intention(tokens);
    }

    public String toString() {
        return this.rawString;
    }

    public String[] getWords() {
        return this.words;
    }

    public TextToken getFirstNoun() {
        TextToken noun = null;
        for (TextToken token : this.tokens) {
            if (token.getType() == TextTokenType.NOUN)
                noun = token;
        }
        if (noun != null) return noun;
        else return new TextToken("unknown");
    }

    public Intention getIntention() {
        return intention;
    }

    public Entity getIntentionTarget(Area context) {
        this.intention.getDirectObject().findTarget(context.getContains());
        return this.getIntention().getDirectObject().getTarget();
    }

    public Entity getIntentionTarget(Entity context) {
        this.intention.getDirectObject().findTarget(context.getContains());
        return this.getIntention().getDirectObject().getTarget();
    }

    public GameVerb getVerb() {
        return this.intention.getAction().getGameVerb();
    }

    public Type getVerbType() {
        return this.getVerb().getType();
    }
}
