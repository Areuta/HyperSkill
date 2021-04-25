import java.lang.reflect.Method;

class MethodFinder {

    public static String findMethod(String methodName, String[] classNames) throws ClassNotFoundException {
        for (String s: classNames) {
            Class sClass = Class.forName(s);
            for (Method method : sClass.getMethods()) {
                if (method.getName().equals(methodName)) {
                    return sClass.getName();
                }
            }
        }
        return null;
    }
}