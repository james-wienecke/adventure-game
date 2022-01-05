import java.util.Arrays;

public class TextParser {
    Sentence[] history;
    int index;
    TextParser() {
        this.history = new Sentence[3];
        this.index = 0;
//        System.out.println(this.history.length);
    }

    public String addSentence(String input) {
        Sentence newInput = new Sentence(input);
        history[index] = newInput;
//        System.out.println(Arrays.toString(history[index].getTokens()));
        incrementIndex();
        return input;
    }

    private void incrementIndex() {
        this.index = ++index % history.length;
    }

    public void test() {
        addSentence("Hello my baby");
        addSentence("Hello my darling");
        addSentence("Hello my ragtime girl");
        addSentence("4th sentence here!");
        for (Sentence sentence : history) {
            System.out.println(sentence.toString());
            //System.out.println(Arrays.toString(sentence.getTokens()));
        }
    }
}

class Sentence {
    private String rawString;
    private String[] tokens;
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