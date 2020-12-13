import java.util.ArrayList;

/***
 * Only to be used internally by the Complayer class
 */

public class Possible
{
    Board node;
    ArrayList<Possible> branches;
    char win;
    //int turn;

    /***
     * When constructed, a possibility contains the board passed into it, then recursively fills an array of Possible objects representing all possible boards that can be accessed in a move from the node board.
     * @param in Board to initialize the Possible with
     */
    public Possible(Board in)
    {
        node = in;
        branches = new ArrayList<Possible>();
        ArrayList<Board> possibilities = new ArrayList<Board>();

        if (node.won() == '.')
        {
            win = '.';
            for (int i = 0; i < 9; i++)
            {
                if (node.getBoard()[i] == '.')
                {
                    possibilities.add(new Board(node.getBoard(), node.getPlayer()));
                    possibilities.get(possibilities.size() - 1).play(i);
                }
            }

            for (int i = 0; i < possibilities.size(); i++)
            {
                branches.add(new Possible(possibilities.get(i)));
            }
        }
        else
        {
            win = node.won();
        }
    }

    /***
     * Finds the total numbers of possible boards based on the node board of this object
     * @return number of total possible boards
     */
    public int getTotal()
    {
        if (branches.size() == 0)
        {
            return 1;
        }
        else
        {
            int total = 0;
            for (int i = 0; i < branches.size(); i++)
            {
                total += branches.get(i).getTotal();
            }
            return total;
        }
    }

    /***
     * Gets total number of wins for given player in all possibilities of this board
     * @param player character representation of player to check for
     * @return int number of total possible wins
     */
    public int getWon(char player)
    {
        if (branches.size() == 0)
        {

            if (node.won() == player)
            {
                return 1;
            }
            else if (node.won() == 'c')
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }
        else
        {
            int total = 0;
            for (int i = 0; i < branches.size(); i++)
            {
                total += branches.get(i).getWon(player);
            }
            return total;
        }
    }
}
