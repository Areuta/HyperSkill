package readability;

public class SMOGStrategy extends ScoreStrategy {
    public SMOGStrategy(Document document) {
        super(document);
    }

    @Override
    public double calculate(String text) {
        return 1.043 * Math.sqrt(document.getCountPolysyllables() * 30.0 / document.getCountSentences()) + 3.1291;
    }

    @Override
    public void printResult(String text) {
        name = "Simple Measure of Gobbledygook";
        super.printResult(text);
    }
}
