import java.util.function.Function;

interface Movable {

    void move(float dx, float dy);
}

interface Scalable {

    void scale(float factor);
}

final class Circle implements MutableShape {

    /**
     * Defines the horizontal position of the center of the circle
     */
    private float centerX;

    /**
     * Defines the vertical position of the center of the circle
     */
    private float centerY;

    /**
     * Defines the radius of the circle
     */
    private float radius;

    public Circle(float centerX, float centerY, float radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public float getCenterX() {
        return centerX;
    }

    public float getCenterY() {
        return centerY;
    }

    public float getRadius() {
        return radius;
    }

    @Override
    public void move(float dx, float dy) {
        this.centerX = centerX + dx;
        this.centerY = centerY + dy;
    }

    @Override
    public void scale(float factor) {
        this.radius = factor * radius;
    }
}

final class Rectangle implements MutableShape {

    /**
     * Defines the X coordinate of the upper-left corner of the rectangle.
     */
    private float x;

    /**
     * Defines the Y coordinate of the upper-left corner of the rectangle.
     */
    private float y;

    /**
     * Defines the width of the rectangle.
     */
    private float width;

    /**
     * Defines the height of the rectangle.
     */
    private float height;

    public Rectangle(float x, float y, float w, float h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public void move(float dx, float dy) {
        this.x = x + dx;
        this.y = y + dy;
    }

    @Override
    public void scale(float factor) {
        this.width = factor * width;
        this.height = factor * height;
    }
}

interface MutableShape extends Movable, Scalable {
    @Override
    void move(float dx, float dy);

    @Override
    void scale(float factor);

    public static void main(String[] args) {
        Function<Long, Long> f = x -> x * x;
        Function<Long, Function<Long, Long>> ha = x -> y -> y * 2;

            Function<Function<Long, Long>, Long> appl =
                    lFunc -> Long.valueOf(lFunc.getClass().getTypeName().length());

        System.out.println(appl.apply(f));
        };




}