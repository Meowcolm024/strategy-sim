import java.util.Random;

class RandomModel extends BaseModel {

    RandomModel(String name) {
        super(name);
    }

    @Override
    Decision act(BaseModel enemy) {

        Random random = new Random();
        boolean x = random.nextBoolean();

        //System.out.println("Rand:" + x);

        if (x)
            return Decision.COOPERATE;
        else
            return Decision.BETRAY;
    }
}
