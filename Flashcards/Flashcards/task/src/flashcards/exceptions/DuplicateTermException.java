package flashcards.exceptions;

public class DuplicateTermException extends Exception {
    public DuplicateTermException(String message) {
        super("The term " + "\"" + message + "\" already exists. Try again:");
    }
}
