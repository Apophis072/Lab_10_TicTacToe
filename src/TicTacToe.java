
import java.util.Scanner;

public class TicTacToe
{
    private static final int ROW = 3;
    private  static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        clearBoard();
        showBoard();
        boolean done = false;
        String playAgain = "";

        //to play again1

        do
        {
            playerMove();
            playAgain = SafeInput.getNonZeroLenString(in, "To play again press Y. Press anything else to exit");
            if (playAgain.equalsIgnoreCase("Y")) {
                clearBoard();
                showBoard();
                playerMove();
                playAgain = SafeInput.getNonZeroLenString(in, "To play again press Y. Press anything else to exit");
            }
            else
            {
                done = true;
            }
        }while(!done);

    }

    //checking whether or not there is already a player's move in that cell
    private static boolean isValidMove(int col, int row)
    {
        boolean retVal = false;
        if(board[row][col].equals(" ")) //is it a space?
        {
        retVal = true;
        return retVal;
        }
        return board[row][col].equals(" ");
    }

    //declare a win by row
    private static boolean isRowWin(String player)
    {
    for (int row = 0; row < ROW; row++)
    {
        if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
        {
            return true;
        }
    }
    return false; //no row win
    }

    //declare a win by col
    private static boolean isColWin(String player)
    {
        for (int col = 0; col < COL; col++)
        {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
             {
                return true;
             }
        }
        return false;
    }

    //declare a win diagnal
    private static boolean isDiagnalWin(String player)
    {
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
        {
            return true;
        }

        else if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))
        {
            return true;
        }
        return false;
    }

    //restart for the next game
    public static void clearBoard()
    {
        for(int row = 0; row < ROW; row++){
            for(int col = 0; col < COL; col++){
                board[row][col] = " "; //make this cell a space
            }
        }
    }

    //show the board
    public static void showBoard()
    {

        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    //Getting a move from player A or first player
    public static void playerMove ()
    {
        Scanner in = new Scanner(System.in);
        int row;
        int col;
        boolean done = false;
        double turn = 0;

        String playerAMove = "X";
        String playerBMove = "O";
        boolean finish = false;

        //declaring the players move
    do {
        do {
            col = SafeInput.getRangedInt(in, "Player A's turn (X). Enter the column you'll like to select ( top left is column 1)", 1, 3) - 1;
            row = SafeInput.getRangedInt(in, "Enter the row you'll like to select (top is row 1)", 1, 3) - 1;
            if (isValidMove(col, row)) {
                board[row][col] = playerAMove;
                showBoard();
                done = true;
                turn = turn + 0.5;
            } else {
                System.out.println("This is an invalid move try again.");
            }
            if (isWin(playerAMove))
            {
                System.out.println("Player A wins!");
                finish = true;
                return;
            }
        } while (!done);


        done = false;
        if (turn < 4.5) //To check if there is still spaces on the board
        {
            do {
                col = SafeInput.getRangedInt(in, "Player B's turn (O). Enter the column you'll like to select ( top left is column 1)", 1, 3) - 1;
                row = SafeInput.getRangedInt(in, "Enter the row you'll like to select (top is row 1)", 1, 3) - 1;
                if (isValidMove(col, row)) {
                    board[row][col] = playerBMove;
                    showBoard();
                    done = true;
                    turn = turn + 0.5;
                } else {
                    System.out.println("This is an invalid move. Try again. ");
                }


                if (isWin(playerBMove)) {
                    System.out.println("Player B wins!");
                    finish = true;
                    return;
                }
            } while (!done);
        }
        else
        {
            System.out.println("Out of spaces. It's a draw.");
            finish = true;
        }
        done = false;
    }while (!finish);


}


//To declare a victor
    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagnalWin(player))
        {
            return true;
        }
        return false;
    }

}