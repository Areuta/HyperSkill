/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 22.01.2021
 * Time: 8:12
 * To change this template use File | Settings | File and Code Templates.
 */
public class Circle extends Shape2d {
    private double r;

    @Override
    public void loadDimensions() {
        this.r = Main.scanner.nextDouble();
    }

    @Override
    public double calculateSquare() {
        return 3.14 * r * r;
    }
}
