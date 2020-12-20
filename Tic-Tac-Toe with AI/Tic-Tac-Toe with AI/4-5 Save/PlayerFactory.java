package tictactoe;//Author Anton   07.12.2020

public class PlayerFactory {
    public Player getPlayer(PlayerTypes type, TicTacToe ticTacToe, boolean b) {
        Player toReturn = null;
        switch (type) {
            case EASY: {
                toReturn = new AiPlayerEasy(ticTacToe, b);
                break;
            }
            case MEDIUM: {
                toReturn = new AiPlayerMedium(ticTacToe, b);
                break;
            }
            case USER: {
                toReturn = new HumanPlayer(ticTacToe, b);
                break;
            }
        }

        return toReturn;
    }

}
