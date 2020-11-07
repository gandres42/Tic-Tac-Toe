import java.sql.PseudoColumnUsage;
import java.util.ArrayList;

public class Possible
{
    Board node;
    ArrayList<Possible> branches;
    char win;

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
}
