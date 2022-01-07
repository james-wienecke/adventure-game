import gameobjs.Player;
import textutils.Sentence;
import textutils.TextParser;
import textutils.intention.*;

public class PlayerInterpreter {

    public static void interpret(String input, Player player) {
        TextParser.addSentence(input);
        Sentence lastSentence = TextParser.getSentence();
        switch (lastSentence.getVerb().getType()) {
            case NO_OBJ:
                switch (lastSentence.getVerb()) {
                    case VERB_LOOK:
                        System.out.println(player.getLocation().lookAround());
                        break;
                }
                break;
            case ONE_OBJ:
                switch (lastSentence.getVerb()) {
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
