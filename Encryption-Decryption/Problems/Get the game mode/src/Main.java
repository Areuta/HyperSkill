class Problem {
    public static void main(String[] args) {
        String result = "default";
        for (int i = args.length - 2; i >= 0; i--) {
            if (args[i].equals("mode")) {
                result = args[i + 1];
                break;
            }
        }
        System.out.println(result);
    }
}