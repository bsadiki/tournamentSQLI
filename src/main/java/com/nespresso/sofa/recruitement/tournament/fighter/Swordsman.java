package com.nespresso.sofa.recruitement.tournament.fighter;

import com.nespresso.sofa.recruitement.tournament.equipment.attack.concretWeapon.Sword;
import com.nespresso.sofa.recruitement.tournament.equipment.attack.decoratorWeapon.Poison;

public class Swordsman extends Fighter {
    private final Integer INITIAL_POINTS=100;
    public Swordsman() {
        super();
        this.points = INITIAL_POINTS;
        this.attackEquipment = new Sword();
    }

    public Swordsman(String vicious) {
        super();
        this.points = INITIAL_POINTS;
        this.attackEquipment = new Poison(new Sword());
    }

    public Swordsman equip(String equipmentName) {
        addWeapon(equipmentName);
        return this;
    }

    @Override
    public Integer power() {
        return attackEquipment.strike();
    }
}
