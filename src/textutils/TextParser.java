package textutils;

import textutils.intention.Intention;

import java.util.Locale;

public class TextParser {
    private static Sentence[] history = new Sentence[5];
    private static int index = 0;

    public static String addSentence(String input) {
        Sentence newInput = new Sentence(input);
        incrementIndex();
        history[index] = newInput;
        return input;
    }

    private static void incrementIndex() {
        index = ++index % history.length;
    }

    private static Sentence getSentence() { return history[index]; }

    private static Sentence getSentence(int i) {
        // i is the number of commands into the past we want to look up
        int indexLookup = index - i;
        if (indexLookup < 0)
            indexLookup = history.length + indexLookup;

        return history[indexLookup];
    }

    private static Sentence[] getHistory() { return history; }

    private static Sentence[] getHistoryChronological() {
        Sentence[] output = new Sentence[history.length];
        for (int i = 0; i < history.length; i++) {
            output[i] = getSentence(i);
        }
        return output;
    }

    private static String getRawSentence(Sentence s) {
        return s.toString();
    }

    private static String[] getRawSentences(Sentence[] array) {
        String[] output = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            output[i] = array[i].toString();
        }
        return output;
    }

    public static String getRawSentenceByHistoryIndex(int i) {
        return getRawSentence(getSentence(i));
    }

    public static String[] getRawSentences() {
        return getRawSentences(history);
    }

    public static String[] getRawSentencesHistoryOrder() {
        return getRawSentences(getHistoryChronological());
    }


    public static void test() {
        addSentence("Get torch");
        addSentence("go northwest");
        addSentence("go south east");
        addSentence("search box and take all");
        addSentence("take small chest");
    }
}

class Sentence {
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

//        intention = new Intention(tokens);
    }

    public String toString() {
        return this.rawString;
    }

    public String[] getWords() {
        return this.words;
    }

}