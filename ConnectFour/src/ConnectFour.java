import java.util.Scanner;

public class ConnectFour {

    public static void printBoard(char[][] array) {                                //this section prints the game board
        for (int i = (array.length - 1); i > -1; i--) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void initializeBoard(char[][] array) {                          //this section resets game board
        for (int i = (array.length - 1); i > -1; i--) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = '-';
            }
        }
    }


    public static int insertChip(char[][] array, int col, char chipType) {          //this section puts the players
                                                                                    //token in the spot they choose
        int i = 2;
        int turn = 0;
        for (i = 0; i < array.length; i++) {
            if (array[i][col] == '-') {
                array[i][col] = chipType;
                break;
            }
        }
        return i;
    }


    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {
        int i = 0;
        int j = 0;                                                             //this section checks for winners
        int inARowX = 0;
        int inARowO = 0;
        boolean game = true;

        for (i = 0; i < array.length; i++) {                                //here we have the vertical win tester
            if (array[i][col] == 'x') {
                inARowX = inARowX + 1;
            }
            if (array[i][col] != 'x') {
                inARowX = 0;
            }
            while (inARowX == 4) {
                System.out.println("Player 1 won the game!");
                System.exit(0);
            }
            if (array[i][col] == 'o') {
                inARowO = inARowO + 1;
            }
            if (array[i][col] != 'o') {
                inARowO = 0;
            }
            while (inARowO == 4) {
                System.out.println("Player 2 won the game!");
                System.exit(0);
            }
        }


        int winnerX = 0;                                                //here we have the horizontal win tester
        int winnerO = 0;
        for (row = 0; row < array.length; row++) {
            for (j = 0; j < array[0].length; j++) {
                if (array[row][j] == 'x') {
                    winnerX = winnerX + 1;
                }
                if (array[row][j] != 'x') {
                    winnerX = 0;
                }
                if (winnerX == 4) {
                    System.out.println("Player 1 won the game!");
                    System.exit(0);
                }
                if (array[row][j] == 'o') {
                    winnerO = winnerO + 1;
                }
                if (array[row][j] != 'o') {
                    winnerO = 0;
                }
                if (winnerO == 4) {
                    System.out.println("Player 2 won the game!");
                    System.exit(0);
                }
            }
            winnerO = 0;
            winnerX = 0;
        }


        int turn = 0;                                                           //here we have a draw tester
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[0].length; j++) {
                if (array[i][j] != '-') {
                    turn = turn + 1;                                            //this counts what turn we are on
                }
            }
            if (turn >= ((array.length) * (array[0].length))) {
                System.out.println("Draw. Nobody wins.");
                System.exit(0);
            }
        }

        return game = false;
    }


    public static void main(String[] args) {                                      //prints / starts the game to set board
        Scanner scnr = new Scanner(System.in);
        System.out.println("What would you like the height of the board to be? ");
        int h = scnr.nextInt();

        System.out.println("What would you like the length of the board to be? ");
        int w = scnr.nextInt();
        char[][] array = new char[h][w];

        initializeBoard(array);
        printBoard(array);

        System.out.println();
        System.out.println("Player 1: x");
        System.out.println("Player 2: o");

        boolean game = true;
        while (game = true) {
            System.out.println("Player 1: Which column would you like to choose? ");
            int col = scnr.nextInt();
            int row = w;
            int i = 0;


            insertChip(array, col, 'x');                        //components of player1 turn
            printBoard(array);
            checkIfWinner(array, col, i, 'x');


            System.out.println("Player 2: Which column would you like to choose? ");
            col = scnr.nextInt();

            insertChip(array, col, 'o');                      //components of player2 turn
            printBoard(array);
            checkIfWinner(array, col, i, 'o');

        }
    }
}
