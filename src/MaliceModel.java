class MaliceModel extends BaseModel {

    MaliceModel(String name) {
        super(name);
    }

    @Override
    Decision act(BaseModel enemy) {
        return Decision.BETRAY;
    }
}
