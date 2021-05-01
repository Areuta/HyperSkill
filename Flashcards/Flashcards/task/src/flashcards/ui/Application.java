package flashcards.ui;

import flashcards.CardManager;

import java.util.EnumMap;

public class Application {
    enum Options {
        ADD, REMOVE, IMPORT, EXPORT, ASK, EXIT
    }

    private final EnumMap<Options, MenuItem> options = new EnumMap<>(Options.class);
    private final CardManager cardManager = new CardManager();
    private boolean isExit = false;


    public Application() {
        registerAddCommand();
        registerExitCommand();

        cardManager.readCards();
        cardManager.simpleCheck();
    }

    public void run() {
        System.out.println("Input the action (add, remove, import, export, ask, exit):");
        while (!isExit) {

        }

    }

    private void registerAddCommand() {
        options.put(Options.ADD, new MenuItem() {
            @Override
            public void execute() {
cardManager.addCard();
            }
        });
    }

    private void registerExitCommand() {
        options.put(Options.EXIT, new MenuItem() {
            @Override
            public void execute() {
                isExit = true;
                System.out.println("Bye bye!");
            }
        });
    }
}
