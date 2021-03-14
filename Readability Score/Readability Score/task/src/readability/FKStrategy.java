package readability;

public class FKStrategy extends ScoreStrategy {
    public FKStrategy(Document document) {
        super(document);
    }

    @Override
    public double calculate(String text) {
        return 0.39 * document.getCountWords() / document.getCountSentences()
                + 11.8 * document.getCountSyllables() / document.getCountWords() - 15.59;
    }

    @Override
    public void printResult(String text) {
        name = "Flesch–Kincaid readability tests";
        super.printResult(text);
    }
}
