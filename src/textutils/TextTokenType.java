package textutils;

public enum TextTokenType {
    // assigned to tokens linked to Concepts
    NOUN,
    // assigned to tokens linked to Actions
    VERB,
    // specifier for Concepts
    ADJECTIVE,
    // specifier for Concepts
    ARTICLE,
    // identifier for indirect/secondary Concepts
    PREPOSITION,
    // specifier for Concepts
    DETERMINER,
    // specifies the start of a second Action and Intention
    CONJUNCTION,
    // identifier for token have indeterminate type
    UNKNOWN,
}
