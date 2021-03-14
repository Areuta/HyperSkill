package readability;

public class ARIStrategy extends ScoreStrategy {
    public ARIStrategy(Document document) {
        super(document);
    }

    @Override
    public double calculate(String text) {
        return 4.71 * document.getCountCharacters() / document.getCountWords()
                + 0.5 * document.getCountWords() / document.getCountSentences() - 21.43;
    }

    @Override
    public void printResult(String text) {
        this.name = "Automated Readability Index";
        super.printResult(text);
    }
}
