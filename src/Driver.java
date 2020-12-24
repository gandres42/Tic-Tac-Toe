import java.util.Scanner;

/***
 * Just a basic tic-tac-toe frontend to allow number of player choice, from 2 to 0
 */
public class Driver {
    public static void main(String[] args) throws InterruptedException {
        normalGame();
    }

    public static void normalGame() throws InterruptedException {
        Board game = new Board();
        Complayer joshua = new Complayer();
        Scanner inout = new Scanner(System.in);

        System.out.println("Enter number of players");
        int players = inout.nextInt();

        if (players == 0)
        {
            WarGames(1000);
        }

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
                game.play(joshua.getPlayIndex(game));
                game.printAll();
                if (game.won() == '.')
                {

                    game.play(inout.nextInt() - 1);
                }
                else
                {
                    break;
                }
            }
            game.printAll();
        }

        System.out.println();
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

    public static void WarGames(int time) throws InterruptedException {
        Board game = new Board();
        Complayer joshua = new Complayer();

        System.out.print("\033[H\033[2J");
        game.printAll();

        while (game.won() == '.')
        {
            game.play(joshua.getPlayIndex(game));
            System.out.print("\033[H\033[2J");
            game.printAll();
            Thread.sleep(time);
            if (game.won() == '.')
            {
                game.play(joshua.getPlayIndex(game));
            }
            else
            {
                break;
            }
            System.out.print("\033[H\033[2J");
            game.printAll();
            Thread.sleep(time);
        }

        if (game.won() == 'c')
        {
            System.out.println("Winner: none");
        }
        else
        {
            System.out.println("Winner: " + game.won());
        }
        Thread.sleep(Math.max(time, 20));
        WarGames((time / 4) * 3);
    }
}
