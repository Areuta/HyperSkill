package flashcards;

import flashcards.exceptions.DuplicateDefinitionException;
import flashcards.exceptions.DuplicateTermException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CardManager {
    public static final Scanner scanner = new Scanner(System.in);

    List<FlashCard> cards = new ArrayList<>();
    List<String> terms = new ArrayList<>();
    List<String> definitions = new ArrayList<>();

    public CardManager() {

    }


    public void printResult(FlashCard flashCard, String answer) {
        if (flashCard.getDefinition().equals(answer)) {
            System.out.println("Correct!");
        } else {
            int i = definitions.indexOf(answer);
            if (i >= 0) {
                System.out.println("Wrong. The right answer is \""
                        + flashCard.getDefinition()
                        + "\", but your definition is correct for \""
                        + terms.get(i) + "\".");
            } else {
                System.out.println("Wrong. The right answer is \"" + flashCard.getDefinition() + "\".");
            }
        }
    }

    public void simpleCheck() {
        for (var i = 0; i < cards.size(); i++) {
            System.out.println("Print the definition of \""
                    + cards.get(i).getTerm()
                    + "\":");
            String answer = scanner.nextLine();
            printResult(cards.get(i), answer);
        }

    }


    public void readCards() {
        System.out.println("Input the number of cards:");
        var n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            System.out.printf("Card #%d:%n", i);
            String term = null;
            while (term == null) {
                try {
                    term = readTerm();
                } catch (DuplicateTermException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.printf("The definition for card #%d:%n", i);
            String definition = null;
            while (definition == null) {
                try {
                    definition = readDefinition();
                } catch (DuplicateDefinitionException e) {
                    System.out.println(e.getMessage());
                }
            }

            terms.add(term);
            definitions.add(definition);
            cards.add(new FlashCard(term, definition));

        }

    }

    private String readTerm() throws DuplicateTermException {
        String term = scanner.nextLine();
        if (terms.contains(term)) {
            throw new DuplicateTermException(term);
        }
        return term;
    }

    private String readDefinition() throws DuplicateDefinitionException {
        String definition = scanner.nextLine();
        if (definitions.contains(definition)) {
            throw new DuplicateDefinitionException(definition);
        }
        return definition;
    }

    public void addCard() {
        
    }
}
