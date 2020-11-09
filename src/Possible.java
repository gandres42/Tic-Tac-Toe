import java.sql.PseudoColumnUsage;
import java.util.ArrayList;

public class Possible
{
    Board node;
    ArrayList<Possible> branches;
    char win;
    int turn;

    public Possible(Board in, int turnin)
    {
        turn = turnin;
        node = in;
        branches = new ArrayList<Possible>();
        //node.printAll();
        //System.out.println("Turn: " + turn);
        //System.out.println("Winner: " + node.won());
        //System.out.println();

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
                branches.add(new Possible(possibilities.get(i), turn + 1));
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

    public boolean isWin(char in)
    {
        return (win == in);
    }

    public int getWins(char check)
    {
        if ()
    }
}
