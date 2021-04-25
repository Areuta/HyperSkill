import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String[] password = {""};

        Arrays.stream(scanner.nextLine().split("[?&]"))
                .skip(1)
                .map(s -> {
                    String res;
                    res = s.replace("=", " : ");
                    if (s.matches("[\\w]*=$")) {
                        res += "not found";
                    }
                    if (s.startsWith("pass=")) {
                        password[0] = s.substring(5);
                    }
                    return res;
                })
                .forEach(System.out::println);

        if (!password[0].equals("")) {
            System.out.println("password" + " : " + password[0]);
        }


    }
}