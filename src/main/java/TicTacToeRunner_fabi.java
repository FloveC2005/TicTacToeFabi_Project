import java.util.Random;
import java.util.Scanner;

public class TicTacToeRunner_fabi {

    public static void main(String[] args) {

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        TicTacToeClass_fabi.printGameBoard(gameBoard);

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9):");
            int playerPos = scan.nextInt();
            while (TicTacToeClass_fabi.playerPositions.contains(playerPos) || TicTacToeClass_fabi.cpuPositions.contains(TicTacToeClass_fabi.playerPositions)) {
                System.out.println("Position taken!!! Enter a correct Position");
                playerPos = scan.nextInt();
            }


            //System.out.println(pos);

            TicTacToeClass_fabi.placePiece(gameBoard, playerPos, "player");

            String answer = TicTacToeClass_fabi.checkWinner();
            if (answer.length() > 0) {
                System.out.println(answer);
                break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while (TicTacToeClass_fabi.playerPositions.contains(cpuPos) || TicTacToeClass_fabi.cpuPositions.contains(TicTacToeClass_fabi.cpuPositions)) {
                cpuPos = rand.nextInt(9) + 1;
            }
            TicTacToeClass_fabi.placePiece(gameBoard, cpuPos, "cpu");

            TicTacToeClass_fabi.printGameBoard(gameBoard);

            answer = TicTacToeClass_fabi.checkWinner();
            if (answer.length() > 0) {
                System.out.println(answer);
                ;
            }
        }

    }
}
