public class Board
{
    char[] board;
    char player;

    public Board()
    {
        board = new char[9];
        for (int i = 0; i < board.length; i++)
        {
            board[i] = '.';
        }
        player = 'x';
    }

    public Board(char[] in, char player)
    {
        board = new char[9];
        for (int i = 0; i < board.length; i++)
        {
            board[i] = in[i];
        }
        this.player = player;
    }

    public void setBoard(char[] in)
    {
        for (int i = 0; i < board.length; i++)
        {
            board[i] = in[i];
        }
    }

    public char[] getBoard()
    {
        return board;
    }

    public char getPlayer()
    {
        return player;
    }

    public void play(int i)
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
    }

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
        for (int i = 0; i < 6; i += 3)
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

        return '.';
    }

    public void printAll()
    {

        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("---|---|---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("---|---|---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " ");


    }

}
