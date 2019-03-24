public class OnRdModel extends OnceModel {

    private int counter;

    OnRdModel(String name, int parts) {
        super(name, parts);
        counter = 0;
    }

    @Override
    Decision act(BaseModel enemy) {

        //System.out.println("Last:" + Arrays.toString(recordings));
        if (counter < 10)
            counter += 1;
        else {
            counter = 0;
            return Decision.BETRAY;
        }

        for (String i : recordings)
            if (enemy.get_name().equals(i))
                return Decision.BETRAY;

        return Decision.COOPERATE;
    }
}
