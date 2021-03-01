import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        normalGame();
    }

    public static void normalGame() throws InterruptedException {
        Scanner inout = new Scanner(System.in);
        clearConsole();
        System.out.println("Enter number of players");
        int players = inout.nextInt();

        if (players == 0)
        {
            WarGames(1000);
        }
        else if (players == 1)
        {
            OnePlayer();
        }
        else if (players == 2)
        {
            TwoPlayer();
        }
        else
        {
            System.out.println("Invalid number of players");
        }

    }

    public static void WarGames(int time) throws InterruptedException {
        Board game = new Board();
        Complayer joshua = new Complayer();

        clearConsole();
        game.printAll();

        while (game.won() == '.')
        {
            game.play(joshua.getPlayIndex(game));
            clearConsole();
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
            clearConsole();
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

    public static void OnePlayer()
    {
        Board game = new Board();
        Complayer joshua = new Complayer();
        Scanner inout = new Scanner(System.in);
        int xoro = -1;
        while (xoro != 1 && xoro != 0)
        {
            System.out.println("X (1) or O (0)?");
            xoro = inout.nextInt();
        }

        if (xoro == 1)
        {
            System.out.println("Player Turn")    ;
        }
        else
        {
            System.out.println("CPU Turn");
        }
        game.printAll();

        while (game.won() == '.')
        {
            if (xoro == 1)
            {
                safePlay(game);
                clearConsole();
                System.out.println("CPU Turn");
                game.printAll();
                if (game.won() == '.')
                {
                    game.play(joshua.getPlayIndex(game));
                    clearConsole();
                    System.out.println("Player Turn");
                    game.printAll();
                }
                else
                {
                    break;
                }
            }
            else
            {
                game.play(joshua.getPlayIndex(game));
                clearConsole();
                System.out.println("Player Turn");
                game.printAll();
                if (game.won() == '.')
                {
                    safePlay(game);
                    clearConsole();
                    System.out.println("CPU Turn");
                    game.printAll();
                }
                else
                {
                    break;
                }

            }
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

    public static void TwoPlayer()
    {
        Board game = new Board();
        Scanner inout = new Scanner(System.in);
        System.out.println("Player 1 Turn");
        game.printAll();
        while (game.won() == '.')
        {
            safePlay(game);
            clearConsole();
            System.out.println("Player 2 Turn");
            game.printAll();

            if (game.won() == '.')
            {
                safePlay(game);
                clearConsole();
                System.out.println("Player 1 Turn");
                game.printAll();
            }
            else
            {
                break;
            }
        }


        System.out.println();
        clearConsole();
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

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                System.out.print("\033[H\033[2J");
            }
        }
        catch (final Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public static void safePlay(Board game)
    {
        Scanner inout = new Scanner(System.in);
        while (game.play(inout.nextInt() - 1) == false)
        {
            System.out.println("Invalid move, please choose a different space");
        }
    }
}
