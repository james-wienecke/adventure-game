package textutils;

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
//            System.out.println(tokens[i].getWord());
//            System.out.println(tokens[i].getType().toString());
        }

        intention = new Intention(tokens);
    }

    public String toString() {
        return this.rawString;
    }

    public String[] getWords() {
        return this.words;
    }

    public Intention getIntention() {
        return intention;
    }


    public GameVerb getVerb() {
        return this.intention.getAction().getGameVerb();
    }

    public Type getVerbType() {
        return this.getVerb().getType();
    }
}
