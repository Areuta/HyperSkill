package flashcards;

import java.util.ArrayList;
import java.util.List;

public class FlashCards {
    private List<FlashCard> cards;
    private List<String> terms;
    private List<String> definitions;

    public List<FlashCard> getCards() {
        return cards;
    }
    public FlashCards() {
        List<FlashCard> cards = new ArrayList<>();
        List<String> terms = new ArrayList<>();
        List<String> definitions = new ArrayList<>();
    }
    public FlashCards(List<FlashCard> cards) {
        this.cards = cards;
    }

    public boolean addCard(FlashCard card) {
        this.terms.add(card.getTerm());
        this.definitions.add(card.getDefinition());
        this.cards.add(card);
        return false;
    }


}
