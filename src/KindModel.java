class KindModel extends BaseModel {

    KindModel(String name) {
        super(name);
    }

    @Override
    Decision act(BaseModel enemy) {
        return Decision.COOPERATE;
    }
}
