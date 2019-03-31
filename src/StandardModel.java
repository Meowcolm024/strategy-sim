import java.util.Arrays;

class StandardModel extends BaseModel {

    String[] recordings;

    StandardModel(String name, int parts) {
        super(name);
        this.recordings = new String[parts];
        for (int i = 0; i < recordings.length; i++)
            recordings[i] = "";
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
        for (int i = 0; i < recordings.length; i++) {
            if (recordings[i].equals(e.get_name()))
                break;
            if (recordings[i].equals("")){
                recordings[i] = e.get_name();
                break;
            }
        }
    }

    private void del_betray(BaseModel e) {
        for (int i = 0; i < recordings.length; i++){
            if (recordings[i].equals(e.get_name()))
                recordings[i] = "";
        }
    }

    @Override
    Decision act(BaseModel enemy) {

        //System.out.println("Last:" + Arrays.toString(recordings));

        for (String i : recordings)
            if (enemy.get_name().equals(i))
                return Decision.BETRAY;

        return Decision.COOPERATE;
    }

    @Override
    public String toString() {
        return (name + " score: " + score + "  Rec: " + Arrays.toString(recordings));
    }
}
