class Invoker {

    public static void invokeMethods(Thread t1, Thread t2, Thread t3) throws InterruptedException {
        t3.start();
        t2.start();
        t1.start();
        t3.join();
        t2.join();
        t1.join();
        /*t3.interrupt();
        t2.interrupt();
        t1.interrupt();*/
        // start passed instances here
    }
}