package cinema;

import java.util.Scanner;

public class Cinema {
    static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {

        System.out.println("Enter the number of rows:");
        int numberRows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int numberCols = scanner.nextInt();
        CinemaRoom cinemaRoom = new CinemaRoom(numberRows, numberCols);

        showMenu();

        int menuItem;

        do {
            menuItem = scanner.nextInt();
            switch (menuItem) {
                case 0: {
                    scanner.close();
                    break;
                }
                case 1: {
                    cinemaRoom.printCinemaRoom();
                    showMenu();
                    break;
                }
                case 2: {
                    while (!chooseSeat(cinemaRoom)) ;
                    showMenu();
                    break;
                }
                case 3: {
                    showStatistics(cinemaRoom);
                    showMenu();
                }
            }
        } while (menuItem != 0);

    }

    private static boolean chooseSeat(CinemaRoom cinemaRoom) {
        System.out.println();
        int numberRow;
        int numberCol;

        System.out.println("Enter a row number:");
        if (scanner.hasNextInt()) {
            numberRow = scanner.nextInt();
        } else {
            System.out.println("Wrong input!");
            scanner.next();
            return false;
        }

        System.out.println("Enter a seat number in that row:");
        if (scanner.hasNextInt()) {
            numberCol = scanner.nextInt();
        } else {
            System.out.println("Wrong input!");
            scanner.next();
            return false;
        }
        System.out.println();

        if (numberRow < 1 || numberRow > cinemaRoom.getCountRows() ||
                numberCol < 1 || numberCol > cinemaRoom.getCountRows()) {
            System.out.println("Wrong input!");
            scanner.next();
            return false;
        }

        Seat currentSeat = cinemaRoom.seats[numberRow - 1][numberCol - 1];
        if (currentSeat.isBusy()) {
            System.out.println("That ticket has already been purchased");
            return false;
        }

        System.out.printf("Ticket price: $%d\n", currentSeat.getCost());
        currentSeat.setBusy(true);
        return true;
    }

    private static void showStatistics(CinemaRoom cinemaRoom) {
        System.out.println();
        int countBusy = 0;
        int currentIncome = 0;
        int totalIncome = 0;

        for (Seat[] seats : cinemaRoom.seats) {
            for (Seat seat : seats) {
                if (seat.isBusy()) {
                    countBusy++;
                    currentIncome += seat.getCost();
                }
                totalIncome += seat.getCost();
            }
        }
        System.out.printf("Number of purchased tickets: %d\n", countBusy);

        float percent = 100f * countBusy / (cinemaRoom.getCountRows() * cinemaRoom.getSeatInRow());
        System.out.printf("Percentage: %.2f%%\n", percent);

        System.out.printf("Current income: $%d\n", currentIncome);
        System.out.printf("Total income: $%d\n", totalIncome);
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit");
    }

}