package tameOfThrones.constants.enums;

public enum KingdomTypeCipherKey {

    LAND(5),
    WATER(7),
    ICE(7),
    AIR(3),
    FIRE(6);

    private int key;

    KingdomTypeCipherKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return this.key;
    }
}
