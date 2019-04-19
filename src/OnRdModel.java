public class OnRdModel extends OnceModel {

    private int counter;

    OnRdModel(String name) {
        super(name);
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

        if (recordings.hasElem(enemy.get_name()))
            return Decision.BETRAY;
        else
            return Decision.COOPERATE;
    }
}
