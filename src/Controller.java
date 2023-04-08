import java.util.Random;
import java.util.Scanner;

public class Controller {
    protected Player player = new Player();
    protected Computer comp = new Computer();
    private Scanner sc = new Scanner(System.in);
    private Random rand = new Random();
    private int chance;
    public int finalResult;
    private int winCondition[][] = {
            { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 },
            { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
            { 0, 4, 8 }, { 2, 4, 6 } };
    private int result[] = new int[9];

    Controller() {
        chance = rand.nextInt(1 + 1);
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
    }

    void checkWinner() {
        for (int[] i : winCondition) {
            if ((result[i[0]] != -1) &&
                    (result[i[1]] != -1) &&
                    (result[i[2]] != -1)) {
                if (result[i[0]] == result[i[1]] && result[i[1]] == result[i[2]]) {
                    finalResult = result[i[0]];
                    Main.printBoard();
                    if (result[i[0]] == 0) {
                        System.out.println("Player Win");
                    } else {
                        System.out.println("Computer Win");
                    }
                    System.exit(0);
                }
            }
        }
    }

    void play(char[][] board, int[][] indexBoard) {
        int getPos = 0;
        if (chance == 0) { // player turn
            System.out.print("Player turn : ");
            getPos = sc.nextInt();
        } else if (chance == 1) { // computer turn
            do {
                getPos = rand.nextInt(8 + 1);
            } while ((getPos > 8 && getPos <= 0));
        }

        if (getPos == 0) {
            play(board, indexBoard);
        }

        if (result[getPos - 1] != -1) {
            play(board, indexBoard);
        } else {
            setBoard(getPos - 1, board, indexBoard);
            setChance();
        }

        System.out.println();
    }

    void setBoard(int pos, char[][] board, int[][] indexBoard) {
        if (chance == 0) {
            board[indexBoard[pos][0]][indexBoard[pos][1]] = player.sign;
            result[pos] = 0;
        } else if (chance == 1) {
            System.out.println("Computer turn: ");
            board[indexBoard[pos][0]][indexBoard[pos][1]] = comp.sign;
            result[pos] = 1;
        }
    }

    void setChance() {
        if (chance == 0) {
            chance = 1;
        } else {
            chance = 0;
        }
    }
}
