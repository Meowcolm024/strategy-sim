class ReverseModel extends StandardModel{

    ReverseModel(String name, int parts) {
        super(name, parts);
    }

    @Override
    Decision act(BaseModel enemy) {

        //System.out.println("RLast:" + Arrays.toString(recordings));

        for (String i : recordings)
            if (enemy.get_name().equals(i))
                return Decision.COOPERATE;

        return Decision.BETRAY;
    }
}
