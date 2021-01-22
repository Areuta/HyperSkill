import java.util.Scanner;

class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String type = scanner.nextLine();
        /*ShapeFactory shapeFactory = new ShapeFactory();

        Shape2d shape = shapeFactory.getInstance(type);
        shape.loadDimensions();
        System.out.println(shape.calculateSquare());*/

        switch (type) {
            case "circle": {
                double r = scanner.nextDouble();
                System.out.println(r * r * 3.14);
                break;
            }
            case "triangle": {
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();
                double p = (a + b + c) / 2;
                System.out.println(Math.sqrt(p * (p - a) * (p - b) * (p - c)));
                break;
            }
            case "rectangle": {
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                System.out.println(a * b);
                break;
            }
        }

        scanner.close();
    }
}