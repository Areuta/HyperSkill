package flashcards.exceptions;

public class DuplicateDefinitionException extends Exception {
    public DuplicateDefinitionException(String message) {
        super("The definition " + "\"" + message + "\" already exists. Try again:");

    }
}
