package pl.umg.trains;

import android.widget.ProgressBar;

import java.io.Serializable;

public class Train implements Serializable{
    private int maxHealthPool;
    private int maxShield;
    private double armour;
    private double attackDamage;
    private double attackSpeed;
    private double armourPenetration;

    public Train(int maxHealthPool, int maxShield, double armour, double attackDamage, double attackSpeed, double armourPenetration) {
        this.maxHealthPool = maxHealthPool;
        this.maxShield = maxShield;
        this.armour = armour;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.armourPenetration = armourPenetration;
    }

    public int getMaxHealthPool() {
        return maxHealthPool;
    }

    public void setMaxHealthPool(int maxHealthPool) {
        this.maxHealthPool = maxHealthPool;
    }

    public int getMaxShield() {
        return maxShield;
    }

    public void setMaxShield(int maxShield) {
        this.maxShield = maxShield;
    }

    public double getArmour() {
        return armour;
    }

    public void setArmour(double armour) {
        this.armour = armour;
    }

    public double getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(double attackDamage) {
        this.attackDamage = attackDamage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getArmourPenetration() {
        return armourPenetration;
    }

    public void setArmourPenetration(double armourPenetration) {
        this.armourPenetration = armourPenetration;
    }
}
