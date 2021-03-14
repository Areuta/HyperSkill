package readability;

public class CLStrategy extends ScoreStrategy {
    public CLStrategy(Document document) {
        super(document);
    }

    @Override
    public double calculate(String text) {
        return 0.0588 * document.getCountCharacters() * 100 / document.getCountWords()
                - 0.296 * document.getCountSentences() * 100 / document.getCountWords() - 15.8;
    }

    @Override
    public void printResult(String text) {
        name = "Coleman–Liau index";
        super.printResult(text);
    }
}
