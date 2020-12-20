package cinema;//Author Anton   28.11.2020

public class CinemaRoom {
    private final int countRows;
    private final int seatInRow;
    Seat[][] seats;

    public int getCountRows() {
        return countRows;
    }

    public int getSeatInRow() {
        return seatInRow;
    }

    public CinemaRoom(int countRows, int seatInRow) {
        this.countRows = countRows;
        this.seatInRow = seatInRow;
        seats = new Seat[countRows][seatInRow];
        int discountedPrice = countRows * seatInRow <= 60 ? 10 : 8;
        for (int i = 0; i < countRows; i++) {
            for (int j = 0; j < seatInRow; j++) {
                if (i < countRows / 2) {
                    seats[i][j] = new Seat(10);
                } else {
                    seats[i][j] = new Seat(discountedPrice);
                }
            }
        }

    }

    public void printCinemaRoom() {
        System.out.println("\nCinema:");

        System.out.print(" ");
        for (int i = 1; i <= seatInRow; i++) {
            System.out.printf(" %d", i);
        }
        System.out.println();

        for (int i = 1; i <= countRows; i++) {
            for (int j = 0; j <= seatInRow; j++) {
                if (j == 0) {
                    System.out.print(i);
                } else {
                    System.out.printf(" %c", seats[i - 1][j - 1].isBusy() ? 'B' : 'S');
                }
            }
            System.out.println();
        }
    }
}
