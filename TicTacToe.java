
import java.util.Scanner;
public class TicTacToe {
    static char[][] board = new char[3][3];
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        initializeBoard();
        playGame();
    }
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
    private static void playGame() {
        char player = 'X';
        for (int i = 0; i < 9; i++) {
            printBoard();
            System.out.println("Player " + player + ", enter row and column (1-3): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            board[row][col] = player;
            if (checkWin(player)) {
                printBoard();
                System.out.println("Player " + player + " wins!");
                return;
            }
            player = (player == 'X') ? 'O' : 'X';
        }
        printBoard();
        System.out.println("It's a tie!");
    }
    private static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("---------");
        }
    }
    private static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }
}

