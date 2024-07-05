import java.util.Scanner;

public class TicTacToe
{
    private static final int ROW = 3;
    private  static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    public static void main(String[] args)
    {
        String playerAMove = "X";
        int moveNum = 0;
        int row;
        int col;
        Scanner in = new Scanner(System.in);

        clearBoard();
        showBoard();

        col = SafeInput.getRangedInt(in, "Player A starts (X). Enter the column you'll like to select ( top left is column 1)", 1,3) - 1;
        row = SafeInput.getRangedInt(in, "Enter the row you'll like to select (top is row 1)",1,3) - 1;
        isValidMove(row,col);
        board[row][col] = playerAMove;


        showBoard();

        col = SafeInput.getRangedInt(in, "Player A starts (X). Enter the column you'll like to select ( top left is column 1)", 1,3) - 1;
        row = SafeInput.getRangedInt(in, "Enter the row you'll like to select (top is row 1)",1,3) - 1;
        isValidMove(row, col);
        board[row][col] = playerAMove;

    }

    private static boolean isValidMove(int row, int col)
    {
        boolean retVal = false;
        if(board[row][col].equals(" ")) //is it a space?
        {
        retVal = true;
        return retVal;
        }
        return board[row][col].equals(" ");
    }

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


    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagnalWin(player))
        {
            return true;
        }
        return false;
    }

}