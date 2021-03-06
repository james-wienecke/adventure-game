import gameobjs.Entity;
import gameobjs.Item;
import gameobjs.Player;
import textutils.Sentence;
import textutils.TextParser;

import java.util.Arrays;

public class PlayerInterpreter {

    public static void interpret(String input, Entity player) {
        TextParser.addSentence(input);
        try {
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
            System.out.println("You WHAT, mate?");
        }
    }
}
