class BaseModel {

    final String name;
    int score;

    BaseModel(String name) {
        this.name = name;
        this.score = 0;
    }

    String get_name() {
        return this.name;
    }

    void receive(BaseModel e, Decision enemy, Decision me) {
        if (enemy == Decision.COOPERATE && me == Decision.COOPERATE) {
            this.score += 3;
        }else if (enemy == Decision.BETRAY && me == Decision.BETRAY) {
            this.score -= 1;
        }else if (enemy == Decision.COOPERATE && me == Decision.BETRAY) {
            this.score += 5;
        }
    }

    Decision act(BaseModel enemy) {
        return null;
    }

    @Override
    public String toString() {
        return (name + " score: " + score);
    }
}
