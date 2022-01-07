import gameobjs.Area;
import gameobjs.Item;
import gameobjs.Player;
import textutils.Sentence;
import textutils.TextParser;
import textutils.intention.*;

public class PlayerInterpreter {

    public static void interpret(String input, Player player) {
        TextParser.addSentence(input);
        Sentence lastSent = TextParser.getSentence();
        switch (lastSent.getVerb().getType()) {
            case NO_OBJ:
                switch (lastSent.getVerb()) {
                    case VERB_LOOK:
                        System.out.println(player.getLocation().lookAround());
                        break;
                }
                break;
            case ONE_OBJ:
                switch (lastSent.getVerb()) {
                    case VERB_GO:

                        break;
                    case VERB_GET:
                        Item targetGet = lastSent.getIntentionTarget(player.getLocation());
                        System.out.println(player.takeItem(targetGet));
                        break;
                    case VERB_DROP:
                        Item targetDrop = lastSent.getIntentionTarget(player);
                        System.out.println(player.dropItem(targetDrop));
                        break;
                    case VERB_EXAMINE:
                        Item targetExamine = lastSent.getIntentionTarget(player.getLocation());
                        System.out.println(player.examineItem(targetExamine));
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
