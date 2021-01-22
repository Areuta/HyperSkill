/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 22.01.2021
 * Time: 8:19
 * To change this template use File | Settings | File and Code Templates.
 */
public class Rectangle extends Shape2d {
    private double a;
    private double b;

    @Override
    public void loadDimensions() {
        this.a = Main.scanner.nextDouble();
        this.b = Main.scanner.nextDouble();
    }

    @Override
    public double calculateSquare() {
        return a * b;
    }
}
