package textutils;

public enum GameVerb {
    // NO_OBJ
    VERB_LOOK(Type.NO_OBJ, new String[] {"look", "l", "observe"}),

    // ONE_OBJ
    VERB_GO(Type.ONE_OBJ, new String[] {"go", "walk", "travel"}),
    VERB_GET(Type.ONE_OBJ, new String[] {"get", "g", "take", "grab", "acquire"}),
    VERB_OPEN(Type.ONE_OBJ, new String[] {"open"}),
    VERB_DROP(Type.ONE_OBJ, new String[] {"drop", "discard"}),
    VERB_EXAMINE(Type.ONE_OBJ, new String[] {"examine", "inspect", "scrutinize", "appraise"}),

    // TWO_OBJ
    // TBD :)
    // ideas: put, throw, useOn, useWith

    // meta game controls
    SYS_SAVE(Type.SYSTEM, new String[] {"save"}),
    SYS_LOAD(Type.SYSTEM, new String[] {"load"}),
    SYS_QUIT(Type.SYSTEM, new String[] {"quit"}),
    SYS_HELP(Type.SYSTEM, new String[] {"help"}),

    // null actions and etc
    VERB_NULL(Type.UNKNOWN, new String[] {}),
    VERB_ERROR(Type.UNKNOWN, new String[] {});

    private final Type type;
    private final String[] aliases;

    GameVerb(Type type, String[] aliases) {
        this.type = type;
        this.aliases = aliases;
    }

    public Type getType() {
        return type;
    }

    public String[] getAliases() {
        return aliases;
    }
}
