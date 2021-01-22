/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 21.01.2021
 * Time: 19:47
 * To change this template use File | Settings | File and Code Templates.
 */
public class ShapeFactory {
    public Shape2d getInstance(String type) {
        ShapeType shapeType = ShapeType.getShapeType(type);
        switch (shapeType) {
            case TRIANGLE: {
                return new Triangle();
            }
            case CIRCLE: {
                return new Circle();
            }
            case RECTANGLE: {
                return new Rectangle();
            }
            case UNKNOWN_SHAPE: {
                return null;
            }
            default: {
                return null;
            }
        }
    }

}
