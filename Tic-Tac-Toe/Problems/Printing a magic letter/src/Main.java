class Main {
    public static void main(String[] args) {
        String twoAsterisk = "**";
        String twoSpace = "  ";

        //fist line print
        String myString = twoAsterisk.repeat(4) +
                "\n" +

                //second line print
                twoSpace.repeat(3) +
                twoAsterisk +
                "\n" +

                //third line print
                twoSpace.repeat(3) +
                twoAsterisk +
                "\n" +

                //fourth line print
                twoSpace.repeat(3) +
                twoAsterisk +
                "\n" +

                //fifth line print
                twoAsterisk +
                twoSpace.repeat(2) +
                twoAsterisk +
                "\n" +

                //sixth line print
                twoAsterisk +
                twoSpace.repeat(2) +
                twoAsterisk +
                "\n" +

                //seventh line print
                " *" +
                twoAsterisk.repeat(3);
        System.out.println(myString);
    }
}