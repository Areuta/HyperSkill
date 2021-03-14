package readability;

import java.util.Scanner;

public class UI {
    ScoreStrategy scoreStrategy;
    Document document;

    public void setScoreStrategy(ScoreStrategy scoreStrategy) {
        this.scoreStrategy = scoreStrategy;
    }

    public UI(String fileName) {
        document = new Document(fileName);
        System.out.println(document);
        chooseScore();
    }

    private void chooseScore() {
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "ARI": {
                setScoreStrategy(new ARIStrategy(document));
                scoreStrategy.printResult(this.document.getText());
                break;
            }
            case "FK": {
                setScoreStrategy(new FKStrategy(document));
                scoreStrategy.printResult(this.document.getText());
                break;
            }
            case "SMOG": {
                setScoreStrategy(new SMOGStrategy(document));
                scoreStrategy.printResult(this.document.getText());
                break;
            }
            case "CL": {
                setScoreStrategy(new CLStrategy(document));
                scoreStrategy.printResult(this.document.getText());
                break;
            }
            case "all": {
                getItAll();
                break;
            }
            default: {
                System.out.println("Bad input!");
            }
        }

        scanner.close();
    }

    private void getItAll() {
        setScoreStrategy(new ARIStrategy(document));
        scoreStrategy.printResult(this.document.getText());
        setScoreStrategy(new FKStrategy(document));
        scoreStrategy.printResult(this.document.getText());
        setScoreStrategy(new SMOGStrategy(document));
        scoreStrategy.printResult(this.document.getText());
        setScoreStrategy(new CLStrategy(document));
        scoreStrategy.printResult(this.document.getText());
    }
}
