import java.util.ArrayList;

/***
 * Only to be used internally by the Complayer class
 */

public class Possible
{
    Board node;
    ArrayList<Possible> branches;
    char win;

    /***
     * When constructed, a possibility contains the board passed into it, then recursively fills an array of Possible objects representing all possible boards that can be accessed in a move from the node board.
     * @param in Board to initialize the Possible with
     */
    public Possible(Board in)
    {
        node = in;
        branches = new ArrayList<>();

        if (node.won() == '.')
        {
            win = '.';
            for (int i = 0; i < 9; i++)
            {
                if (node.getBoard()[i] == '.')
                {
                    Board temp = new Board(node.getBoard(), node.getPlayer());
                    temp.play(i);
                    branches.add(new Possible(temp));
                }
            }
        }
        else
        {
            win = node.won();
        }
    }

    /***
     * Recursive method using the Minimax algorithm to find the minimax score starting at the parent node board
     * @param player
     * @return
     */
    public int getScore(char player)
    {
        if (branches.size() == 0)
        {
            if (win == player)
            {
                return 1;
            }
            else if (win == 'c')
            {
                return 0;
            }
            return -1;
        }
        else
        {
            if (node.getPlayer() == player)
            {
                int max = branches.get(0).getScore(player);
                for (int i = 0; i < branches.size(); i++)
                {
                    if (max < branches.get(i).getScore(player))
                    {
                        max = branches.get(i).getScore(player);
                    }
                }
                return max;
            }
            else
            {
                int min = branches.get(0).getScore(player);
                for (int i = 0; i < branches.size(); i++)
                {
                    if (min > branches.get(i).getScore(player))
                    {
                        min = branches.get(i).getScore(player);
                    }
                }
                return min;
            }
        }
    }
}
