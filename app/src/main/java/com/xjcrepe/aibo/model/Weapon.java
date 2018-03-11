package com.xjcrepe.aibo.model;

/**
 * id	Integer	The weapon's ID
 * slug	String	A human readable unique identifier
 * name	String	The weapon's name
 * type	Enum<WeaponType>	The type of the weapon
 * rarity	Integer	The weapon's rarity level
 * attributes	Attributes	An object describing the attributes of the weapon
 */

public class Weapon {

    private int id;
    private String slug;
    private String name;
    private WeaponType type;
    private int rarity;

    public int getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

    public WeaponType getType() {
        return type;
    }

    public int getRarity() {
        return rarity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weapon weapon = (Weapon) o;

        if (id != weapon.id) return false;
        if (rarity != weapon.rarity) return false;
        if (!slug.equals(weapon.slug)) return false;
        if (!name.equals(weapon.name)) return false;
        return type == weapon.type;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + slug.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + rarity;
        return result;
    }
}
