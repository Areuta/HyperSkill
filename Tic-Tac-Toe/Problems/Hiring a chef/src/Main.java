//put imports you need here

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String age = scanner.nextLine();
        String stageOfEducation = scanner.nextLine();
        String yearsOfExperience = scanner.nextLine();
        String cuisinePreference = scanner.nextLine();

        System.out.printf("\nThe form for %s is completed. ", firstName);
        System.out.print("We will contact you if we need a chef ");
        System.out.printf("that cooks %s dishes.", cuisinePreference);

    }
}