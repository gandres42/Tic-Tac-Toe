import java.util.Scanner;

/***
 * Just a basic tic-tac-toe frontend to allow number of player choice, from 2 to 0
 */
public class Driver {
    public static void main(String[] args) {
        Board game = new Board();
        Complayer joshua = new Complayer();
        Scanner inout = new Scanner(System.in);

        //System.out.println("Enter number of players");
        //int players = inout.nextInt();

        int players = 1;

        game.printAll();

        while (game.won() == '.')
        {
            if (players == 2)
            {
                game.play(inout.nextInt() - 1);
                if (game.won() == '.')
                {
                    game.play(inout.nextInt() - 1);
                }
                else
                {
                    break;
                }
            }
            else if (players == 1)
            {
                game.play(inout.nextInt() - 1);
                if (game.won() == '.')
                {
                    game.play(joshua.getPlayIndex(game));
                }
                else
                {
                    break;
                }
            }
            else if (players == 0)
            {
                game.play(joshua.getPlayIndex(game));
                if (game.won() == '.')
                {
                    game.play(joshua.getPlayIndex(game));
                }
                else
                {
                    break;
                }
            }
            game.printAll();
            System.out.println();
        }

        game.printAll();

        if (game.won() == 'c')
        {
            System.out.println("Winner: none");
        }
        else
        {
            System.out.println("Winner: " + game.won());
        }
    }
}
