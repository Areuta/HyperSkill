package flashcards;

public class FlashCard {
    private String term;
    private String definition;

    public String getDefinition() {
        return definition;
    }

    public String getTerm() {
        return term;
    }

    public FlashCard(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }
}
