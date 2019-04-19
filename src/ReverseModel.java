class ReverseModel extends StandardModel{

    ReverseModel(String name) {
        super(name);
    }

    @Override
    Decision act(BaseModel enemy) {

        if (recordings.hasElem(enemy.get_name()))
            return Decision.COOPERATE;
        else
            return Decision.BETRAY;
    }
}
