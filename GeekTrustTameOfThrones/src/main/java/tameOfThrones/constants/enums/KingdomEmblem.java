package tameOfThrones.constants.enums;

public enum KingdomEmblem {

    LAND("Panda"),
    WATER("Octopus"),
    ICE("Mammoth"),
    AIR("Owl"),
    FIRE("Dragon");

    private String emblemType;

    KingdomEmblem(String emblemType) {
        this.emblemType = emblemType;
    }

    public String getEmblemType() {
        return this.emblemType;
    }
}
