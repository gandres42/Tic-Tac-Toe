public class Driver {
    public static void main(String[] args)
    {
        Board testin = new Board();
        Possible test = new Possible(testin, 0);
        System.out.println(test.getTotal());
    }
}
