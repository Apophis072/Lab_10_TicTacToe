public class TicTacToe
{
    private static final int ROW = 3;
    private  static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    public static void main(String[] args)
    {

    clearBoard();
    showBoard();


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
        if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)){
            return true;
        }
    }
    return false; //no row win
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

}