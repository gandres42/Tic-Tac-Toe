import java.util.Random;

/***
 * @author Gavin Andres
 * Class to determine the best move using the Minimax algorithm, independent of player, simply takes a board and player turn and finds a best move, means only one is needed.
 */
public class Complayer
{
    public Complayer()
    {
        //Does nothing
    }

    /***
     * Given a board object, this method will first check for any moves that will allow the other player to win within a turn, and if there is no such move, checks for the move with the highest probability of winning using the Possible class
     * @param in Board object to find the next move for
     * @return An int representing an index in the board where this method reccomends playing
     */
    public int getPlayIndex(Board in)
    {
        Integer[] probablities = new Integer[9];

        /**
         * Generates scores for all options using Possible object with first node at the current game board
         */
        for (int i = 0; i < in.getBoard().length; i++)
        {
            if (in.getBoard()[i] == '.')
            {
                char player = in.getPlayer();
                Board boardPlay = new Board(in.getBoard(), in.getPlayer());
                boardPlay.play(i);
                Possible opportunity = new Possible(boardPlay);
                probablities[i] = opportunity.getScore(player);
            }
            else
            {
                probablities[i] = null;
            }
        }
        System.out.println();

        /**
         * Finds best possibility from array of possibility scores, if there are multiple optimal plays, one is randomly chosen
         */
        int indexReturn = -1;
        double maxVal = -1 * Double.MAX_VALUE;
        Random rand = new Random();

        for (int i = 0; i < probablities.length; i++)
        {
            if (probablities[i] != null && probablities[i] >= maxVal)
            {
                if (probablities[i] > maxVal)
                {
                    maxVal = probablities[i];
                    indexReturn = i;
                }
                else if (probablities[i] == maxVal && rand.nextBoolean())
                {
                    indexReturn = i;
                }
            }
        }

        return indexReturn;
    }
}
