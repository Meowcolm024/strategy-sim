class StandardModel extends BaseModel {

    Sets<String> recordings;

    StandardModel(String name) {
        super(name);
        this.recordings = new Sets<>();
    }

    @Override
    void receive(BaseModel e, Decision enemy, Decision me) {
        if (enemy == Decision.COOPERATE && me == Decision.COOPERATE) {
            this.score += 3;
            del_betray(e);

        }else if (enemy == Decision.BETRAY && me == Decision.BETRAY) {
            this.score -= 1;
            log_betray(e);

        }else if (enemy == Decision.COOPERATE && me == Decision.BETRAY) {
            this.score += 5;
            del_betray(e);

        }else if (enemy == Decision.BETRAY && me == Decision.COOPERATE){
            log_betray(e);
        }
    }

    void log_betray(BaseModel e) {
        recordings.push(e.get_name());
    }

    private void del_betray(BaseModel e) {
        recordings.pop(e.get_name());
    }

    @Override
    Decision act(BaseModel enemy) {

        if (recordings.hasElem(enemy.get_name()))
            return Decision.BETRAY;
        else
            return Decision.COOPERATE;
    }

    @Override
    public String toString() {
        return (name + " score: " + score + "  Rec: " + recordings.toArr());
    }
}
