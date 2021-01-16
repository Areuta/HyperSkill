class MessageNotifier extends Thread {

    int repetitions;

    public MessageNotifier(String msg, int repeats) {
        super(msg);
        this.repetitions = repeats;
    }

    @Override
    public void run() {
        for (int i = 0; i < repetitions; i++) {
            System.out.println(this.getName());
        }
    }
}