import gameobjs.Entity;
import gameobjs.Item;
import gameobjs.Player;
import textutils.Sentence;
import textutils.TextParser;

public class PlayerInterpreter {

    public static void interpret(String input, Entity player) {
        TextParser.addSentence(input);
        Sentence lastSent = TextParser.getSentence();
        try {
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
                            Entity targetGet = lastSent.getIntentionTarget(player.getLocation());
                            System.out.println(player.takeItem(targetGet));
                            break;
                        case VERB_DROP:
                            Entity targetDrop = lastSent.getIntentionTarget(player);
                            System.out.println(player.dropItem(targetDrop));
                            break;
                        case VERB_EXAMINE:
                            Entity targetExamine = lastSent.getIntentionTarget(player);
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
        } catch (NullPointerException e) {
            String failure = lastSent.getFirstNoun().getWord();
            System.out.println("Don't know what a " + failure + " is");
        }
    }
}
