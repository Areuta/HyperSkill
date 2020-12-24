class CreateInstance {

    public static SuperClass create() {

        SuperClass instance = new SuperClass() {
            @Override
            public void method2() {
                System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
            }

            @Override
            public void method3() {
                System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
            }

        };
        /* create an instance of an anonymous class here,
                                 do not forget ; on the end */

        return instance;
    }
}

// Don't change the code below

abstract class SuperClass {

    public static void method1() {
    }

    public void method2() {
    }

    public abstract void method3();
}