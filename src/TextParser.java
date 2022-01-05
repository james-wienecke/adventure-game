import com.sun.nio.file.SensitivityWatchEventModifier;

import java.util.Arrays;

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

    public static Sentence getSentence() { return history[index]; }

    public static Sentence getSentence(int i) {
        // i is the number of commands into the past we want to look up
        int indexLookup = index - i;
        if (indexLookup < 0)
            indexLookup = history.length + indexLookup;

        return history[indexLookup];
    }

    public static Sentence[] getHistory() { return history; }

    public static void test() {
        addSentence("Hello my baby");
        addSentence("Hello my darling");
        addSentence("Hello my ragtime girl");
        addSentence("4th sentence here!");
        addSentence("5th lil thing also here");
//        for (Sentence sentence : history) {
//            try {
//                System.out.println(sentence.toString());
//            } catch(Exception e) {
//                System.out.println("empty");
//            }
//        }
    }
}

class Sentence {
    private final String rawString;
    private final String[] tokens;
    Sentence(String input) {
        this.rawString = input;
        this.tokens = input.split(" ");
        //System.out.println(Arrays.toString(tokens));
    }

    public String toString() {
        return this.rawString;
    }

    public String[] getTokens() {
        return this.tokens;
    }
}