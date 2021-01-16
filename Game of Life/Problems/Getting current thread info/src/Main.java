class Info {

    public static void printCurrentThreadInfo() {
        System.out.printf("name: %s\n", Thread.currentThread().getName());
        System.out.printf("priority: %d", Thread.currentThread().getPriority());

        Thread t3 = new Thread(() -> {
            System.out.println(String.format("Hello, i'm %s", Thread.currentThread().getName()));
        });
    }

}