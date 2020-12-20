package tictactoe;//Author Anton   07.12.2020

public class PlayerFactory {
    public Player getPlayer(PlayerTypes type, boolean b) {
        Player toReturn = null;
        switch (type) {
            case EASY: {
                toReturn = new AiPlayerEasy(b);
                break;
            }
            case MEDIUM: {
                toReturn = new AiPlayerMedium(b);
                break;
            }
            case HARD: {
                toReturn = new AiPlayerHard(b);
                break;
            }
            case USER: {
                toReturn = new HumanPlayer(b);
                break;
            }
        }

        return toReturn;
    }

}
