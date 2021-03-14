package readability;

public abstract class ScoreStrategy implements Scorable {
    protected String name;

    public ScoreStrategy(Document document) {
        this.document = document;
    }

    protected Document document;
    private final String[] ages = new String[]{
            "6", "7", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "24", "24+",
    };

    public void printResult(String text) {
        double score = this.calculate(text);
        System.out.println(name + ": " + score + " (about " + getAge(score) + "-year-olds).");
    }

    public String getAge(double score) {
        return ages[(int) Math.floor(score) - 1];
    }

}
