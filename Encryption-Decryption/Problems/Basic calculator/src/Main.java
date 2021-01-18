class Problem {
    public static void main(String[] args) {
        int number1 = 0;
        int number2 = 0;
        try {
            number1 = Integer.parseInt(args[1]);
            number2 = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int result;
        switch (args[0]) {
            case "*": {
                result = number1 * number2;
                break;
            }
            case "+": {
                result = number1 + number2;
                break;
            }
            case "-": {
                result = number1 - number2;
                break;
            }
            default: {
                System.out.println("Unknown operator");
                return;
            }
        }
        System.out.println(result);
    }
}