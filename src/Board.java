public class Board
{
    char[] board;
    char player;

    /***
     * Creates a new, empty board
     */
    public Board()
    {
        board = new char[9];
        for (int i = 0; i < board.length; i++)
        {
            board[i] = '.';
        }
        player = 'x';
    }

    /***
     * Creates a board using a character array passed in and a current player.
     * @param in
     * @param player
     */
    public Board(char[] in, char player)
    {
        board = new char[9];
        for (int i = 0; i < board.length; i++)
        {
            board[i] = in[i];
        }
        this.player = player;
    }

    /***
     * Gets the current array representing the board
     * @return character array of the board
     */
    public char[] getBoard()
    {
        return board;
    }

    /***
     * Gets the current player
     * @return character representing current player turn
     */
    public char getPlayer()
    {
        return player;
    }

    /***
     * Updates given index in the array with the current players turn, then toggles the player to prepare for the next turn
     * @param i index to update
     */
    public boolean play(int i)
    {
        if (board[i] == '.')
        {
            board[i] = player;
            if (player == 'x')
            {
                player = 'o';
            }
            else if (player == 'o')
            {
                player = 'x';
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    /***
     * Checks if there is a winner or a cats game
     * @return character 'x' or 'o' for each player, if no winner '.' and if cats game 'c';
     */
    public char won()
    {
        //Checks for vertical
        for (int i = 0; i < 3; i++)
        {
            if (board[i] == 'x' && board[i + 3] == 'x' && board[i + 6] == 'x')
            {
                return 'x';
            }
            else if (board[i] == 'o' && board[i + 3] == 'o' && board[i + 6] == 'o')
            {
                return 'o';
            }
        }

        //Checks for diagonals
        if (board[0] == 'x' && board[4] == 'x' && board[8] == 'x')
        {
            return 'x';
        }
        else if (board[0] == 'o' && board[4] == 'o' && board[8] == 'o')
        {
            return 'o';
        }

        if (board[2] == 'x' && board[4] == 'x' && board[6] == 'x')
        {
            return 'x';
        }
        else if (board[2] == 'o' && board[4] == 'o' && board[6] == 'o')
        {
            return 'o';
        }

        //Checks horizontals
        for (int i = 0; i <= 6; i += 3)
        {
            if (board[i] == 'x' && board[i + 1] == 'x' && board[i + 2] == 'x')
            {
                return 'x';
            }
            else if (board[i] == 'o' && board[i + 1] == 'o' && board[i + 2] == 'o')
            {
                return 'o';
            }
        }

        //checks for cats game
        boolean cats = true;
        for (int i = 0; i < 9; i++)
        {
            if (board[i] == '.')
            {
                cats = false;
            }
        }
        if (cats)
        {
            return 'c';
        }

        //only returns if game is in progress, with no winner
        return '.';
    }

    /**
     * A method which directly prints the board to console with a nice little gui
     */
    public void printAll()
    {

        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("---|---|---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("---|---|---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " ");


    }
}
