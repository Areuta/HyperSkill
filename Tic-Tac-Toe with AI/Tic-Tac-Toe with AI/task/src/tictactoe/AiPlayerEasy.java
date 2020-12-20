package tictactoe;//Author Anton   06.12.2020

public class AiPlayerEasy extends Player {

    public AiPlayerEasy(boolean b) {
        super(b);
        playerString = "Making move level \"easy\"\n";
    }

    @Override
    public void move() {
        doRandomMove();
        super.move();
    }
}
