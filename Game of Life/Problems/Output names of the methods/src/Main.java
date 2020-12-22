class CreateInstance {

    public static SuperClass create() {

        SuperClass instance = /* create an instance of an anonymous class here, 
                                 do not forget ; on the end */

        return instance;
    }
}

// Don't change the code below

abstract class SuperClass {

    public static void method1() { }

    public void method2() { }

    public abstract void method3();
}