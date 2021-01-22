/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 21.01.2021
 * Time: 18:59
 * To change this template use File | Settings | File and Code Templates.
 */
public enum ShapeType {
    TRIANGLE("triangle"), RECTANGLE("rectangle"), CIRCLE("circle"), UNKNOWN_SHAPE("unknown");
    private final String name;

    public String getName() {
        return name;
    }

    ShapeType(final String shape) {
        this.name = shape;
    }

    public static ShapeType getShapeType(String name) {
        for (ShapeType type : ShapeType.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        return UNKNOWN_SHAPE;
    }
}
