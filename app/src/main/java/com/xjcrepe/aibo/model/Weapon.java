package com.xjcrepe.aibo.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.xjcrepe.aibo.data.AiboTypeConverters;

/**
 * id	Integer	The weapon's ID
 * slug	String	A human readable unique identifier
 * name	String	The weapon's name
 * type	Enum<WeaponType>	The type of the weapon
 * rarity	Integer	The weapon's rarity level
 * attributes	Attributes	An object describing the attributes of the weapon
 */

@Entity(tableName = "weapons")
//@TypeConverters(AiboTypeConverters.class)
public class Weapon {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "slug")
    private String slug;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "rarity")
    private int rarity;

    public void setId(int id) {
        this.id = id;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

    public String getType() {
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
        return type.equals(weapon.type);
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
