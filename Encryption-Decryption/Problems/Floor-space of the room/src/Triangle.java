/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 21.01.2021
 * Time: 3:38
 * To change this template use File | Settings | File and Code Templates.
 */
public class Triangle extends Shape2d {
    private double a;
    private double b;
    private double c;

    @Override
    public double calculateSquare() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public void loadDimensions() {
        this.a = Main.scanner.nextDouble();
        this.b = Main.scanner.nextDouble();
        this.c = Main.scanner.nextDouble();
    }
}

