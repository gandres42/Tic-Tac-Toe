import java.util.Random;

public class Complayer
{
    public Complayer()
    {

    }

    /***
     * Given a board object, this method will first check for any moves that will allow the other player to win within a turn, and if there is no such move, checks for the move with the highest probability of winning using the Possible class
     * @param in Board object to find the next move for
     * @return An int representing an index in the board where this method reccomends playing
     */
    public int getPlayIndex(Board in)
    {
        double[] probablities = new double[9];
        double[] tieBreaker = new double[9];

        for (int i = 0; i < 9; i++) {
            Board checkWin = new Board(in.getBoard(), in.getPlayer());
            checkWin.changePlayer();
            checkWin.play(i);
            if (checkWin.won() != '.' && checkWin.won() != in.getPlayer() && in.getBoard()[i] == '.') {
                System.out.println("emergency: " + i);
                return i;
            }
        }

        for (int i = 0; i < 9; i++) {
            Board checkWin = new Board(in.getBoard(), in.getPlayer());
            checkWin.changePlayer();
            checkWin.play(i);
            if (checkWin.won() != '.' && checkWin.won() != in.getPlayer() && in.getBoard()[i] == '.') {
                System.out.println("emergency: " + i);
                return i;
            }
        }

        /**
         * Generates probability scores using Possible object
         */
        for (int i = 0; i < in.getBoard().length; i++)
        {
            if (in.getBoard()[i] == '.')
            {
                char player = in.getPlayer();
                Board boardPlay = new Board(in.getBoard(), in.getPlayer());
                boardPlay.play(i);
                Possible opportunity = new Possible(boardPlay);
                probablities[i] = opportunity.getWon(player);
                tieBreaker[i] = opportunity.getLost(player);
            }
            else
            {
                probablities[i] = -1;
                tieBreaker[i] = -1;
            }
        }

        /**
         * Finds best possibility from array of possibility scores
         */
        int indexReturn = -1;
        double maxVal = -1 * Double.MAX_VALUE;

        for (int i = 0; i < probablities.length; i++)
        {
            System.out.print(probablities[i] + " ");
            if (probablities[i] != -1 && probablities[i] >= maxVal)
            {
                if (probablities[i] > maxVal)
                {
                    maxVal = probablities[i];
                    indexReturn = i;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < tieBreaker.length; i++)
        {
            System.out.print(tieBreaker[i] + " ");
        }
        System.out.println();
        return indexReturn;
    }
}
