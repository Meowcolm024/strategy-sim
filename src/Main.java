import java.util.Random;

public class Main {

    private static final int COUNT = 7;
    private static final int LIMIT = 1000000;

    public static void main(String args[]) {

        Random random = new Random();

        BaseModel[] xs = {
                new KindModel("Kind"),
                new RandomModel("Random"),
                new MaliceModel("Malice"),
                new StandardModel("Standard"),
                new OnceModel("Once"),
                new ReverseModel("Reverse"),
                new OnRdModel("OnceRandom")
        };

        for (int i = 0; i < LIMIT; i++){
            int p = random.nextInt(COUNT);
            int q = random.nextInt(COUNT);
            while (p == q)
                q = random.nextInt(COUNT);

            test(xs, p, q);
        }

        for (BaseModel x : xs) {
            System.out.println(x);
        }
    }

    private static void test(BaseModel[] xs, int p, int q) {

        Decision one = xs[p].act(xs[q]);
        Decision two = xs[q].act(xs[p]);
        xs[p].receive(xs[q], two, one);
        xs[q].receive(xs[p], one, two);

        /*
        System.out.println(xs[p]);
        System.out.println(xs[q]);
        System.out.println();
        */

    }
}
