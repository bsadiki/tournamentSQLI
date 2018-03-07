package com.nespresso.sofa.recruitement.tournament.fighter;

import com.nespresso.sofa.recruitement.tournament.equipment.attack.concretWeapon.Axe;

public class Viking extends Fighter {
    private final Integer INITIAL_POINTS=120;
    public Viking() {
        super();
        this.points = INITIAL_POINTS;
        this.attackEquipment = new Axe();
    }

    public Viking equip(String equipmentName) {
        addWeapon(equipmentName);
        return this;
    }
    @Override
    public Integer power() {
        return attackEquipment.strike();
    }

}
