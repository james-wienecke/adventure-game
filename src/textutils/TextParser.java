package textutils;

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
        addSentence("Hello my baby");
        addSentence("Hello my darling");
        addSentence("Hello my ragtime girl");
        addSentence("4th sentence here!");
        addSentence("5th lil thing also here");
    }
}

class Sentence {
    private final String rawString;
    private final String[] tokens;
    Sentence(String input) {
        this.rawString = input;
        this.tokens = input.split(" ");
    }

    public String toString() {
        return this.rawString;
    }

    public String[] getTokens() {
        return this.tokens;
    }
}