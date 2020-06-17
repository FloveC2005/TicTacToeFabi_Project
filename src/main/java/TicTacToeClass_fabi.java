import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeClass_fabi {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void printGameBoard(char[][] gameBoard){

        for(char[] row : gameBoard){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user){

        char symbol = ' ';

        if(user.equals("player")){
            symbol = 'X';
            playerPositions.add(pos);
        }else if(user.equals("cpu")){
            symbol = 'O';
            cpuPositions.add(pos);
        }

        switch(pos){
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String checkWinner(){

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 2, 3);

        List<List> winConditions = new ArrayList<List>();
        winConditions.add(topRow);
        winConditions.add(midRow);
        winConditions.add(botRow);
        winConditions.add(leftCol);
        winConditions.add(midCol);
        winConditions.add(rightCol);
        winConditions.add(cross1);
        winConditions.add(cross2);

        for(List l : winConditions){
            if(playerPositions.containsAll(l)){
                return "Congratulations you WON!!! FATALITY!! FLAWLESS VICTORY!!";
            }else if(cpuPositions.containsAll(l)){
                return "CPU wins!!! Sorry :(";
            }
        }
        if(playerPositions.size() + cpuPositions.size() == 9){
            return "CAT!";
        }

        return "";

    }


}
