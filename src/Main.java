public class Main {

    static char board[][] = {
            { '1', '|', '2', '|', '3' },
            { '-', '+', '-', '+', '-' },
            { '4', '|', '5', '|', '6' },
            { '-', '+', '-', '+', '-' },
            { '7', '|', '8', '|', '9' },
    };

    static int indexBoard[][] = {
            { 0, 0 },
            { 0, 2 },
            { 0, 4 },
            { 2, 0 },
            { 2, 2 },
            { 2, 4 },
            { 4, 0 },
            { 4, 2 },
            { 4, 4 }
    };

    public static void main(String[] args) {
        Controller ctrl = new Controller();
        System.out.println("Welcome to the Tic Tac Toe Game!");
        while (true) {
            printBoard();
            ctrl.play(board, indexBoard);
            ctrl.checkWinner();
        }
    }

    static void printBoard() {
        for (char i[] : board) {
            for (char j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}