import textutils.Sentence;
import textutils.TextParser;
import textutils.intention.*;

public class PlayerInterpreter {

    public void interpret(String input) {
        TextParser.addSentence(input);
        Sentence lastSentence = TextParser.getSentence();
        switch (lastSentence.getIntention().getAction().getGameVerb().getType()) {
            case NO_OBJ:
                switch (lastSentence.getIntention().getAction().getGameVerb()) {
                    case VERB_LOOK:

                        break;
                }
                break;
            case ONE_OBJ:
                switch (lastSentence.getIntention().getAction().getGameVerb()) {
                    case VERB_GO:

                        break;
                    case VERB_GET:

                        break;
                }

                break;
            case TWO_OBJ:
                System.out.println("Unimplemented");
                break;
            case SYSTEM:

                break;
            case UNKNOWN:

                break;
        }
    }
}
