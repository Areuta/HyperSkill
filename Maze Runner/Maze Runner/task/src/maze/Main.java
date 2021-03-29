package maze;

public class Main {
    public static void main(String[] args) {
        new SimpleMenu().initialize();
//        ./Maze Runner/task/src/maze/mazes/maze1616885256.txt   LEFT
        //  ./Maze Runner/task/src/maze/mazes/maze1616886195.txt  UP
        //  ./Maze Runner/task/src/maze/mazes/maze1616888689.txt
    }

    /**
     * B - BORDER
     * N - NODE always PASS
     * E - EDGE always a wall, except when it belongs Spanning Tree
     * W - always WALL
     *
     * maze:
     *     0 1 2 3 4 5
     *   -------------
     * 0 | B B B B B B
     * 1 | B N E N E B
     * 2 | B E W E W B
     * 3 | B N E N E B
     * 4 | B E W E W B
     * 5 | B B B B B B

     */
}
