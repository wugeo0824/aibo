package com.xjcrepe.aibo.model;

/**
 * A weapon type is one of the following values:
 * <p>
 * great-sword
 * long-sword
 * sword-and-shield
 * dual-blades
 * hammer
 * hunting-horn
 * lance
 * gunlance
 * switch-axe
 * charge-blade
 * insect-glaive
 * light-bowgun
 * heavy-bowgun
 * bow
 */

public enum WeaponType {
    GREAT_SWORD("GREAT_SWORD"),
    LONG_SWORD("LONG_SWORD"),
    SWORD_AND_SHIELD("SWORD_AND_SHIELD"),
    DUAL_BLADES("DUAL_BLADES"),
    HAMMER("HAMMER"),
    HUNTING_HORN("HUNTING_HORN"),
    LANCE("LANCE"),
    GUNLANCE("GUNLANCE"),
    SWITCH_AXE("SWITCH_AXE"),
    CHARGE_BLADE("CHARGE_BLADE"),
    INSECT_GLAIVE("INSECT_GLAIVE"),
    LIGHT_BOWGUN("LIGHT_BOWGUN"),
    HEAVY_BOWGUN("HEAVY_BOWGUN"),
    BOW("BOW");

    private String weaponsType;

    WeaponType(String weaponsType) {
        this.weaponsType = weaponsType;
    }

    public String getWeaponsType() {
        return weaponsType;
    }
}
