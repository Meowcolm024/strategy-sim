class OnceModel extends StandardModel{

    OnceModel(String name, int parts) {
        super(name, parts);
    }

    @Override
    void receive(BaseModel e, Decision enemy, Decision me) {
        if (enemy == Decision.COOPERATE && me == Decision.COOPERATE) {
            this.score += 3;

        } else if (enemy == Decision.BETRAY && me == Decision.BETRAY) {
            this.score -= 1;
            log_betray(e);

        } else if (enemy == Decision.COOPERATE && me == Decision.BETRAY) {
            this.score += 5;

        } else if (enemy == Decision.BETRAY && me == Decision.COOPERATE) {
            log_betray(e);
        }
    }

}
