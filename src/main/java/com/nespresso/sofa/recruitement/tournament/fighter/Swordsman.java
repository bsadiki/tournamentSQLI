package com.nespresso.sofa.recruitement.tournament.fighter;

import com.nespresso.sofa.recruitement.tournament.equipment.AbstractEquipment;
import com.nespresso.sofa.recruitement.tournament.equipment.attack.AbstractWeapon;
import com.nespresso.sofa.recruitement.tournament.equipment.attack.concretWeapon.Sword;
import com.nespresso.sofa.recruitement.tournament.equipment.attack.decoratorWeapon.Poison;
import com.nespresso.sofa.recruitement.tournament.equipment.defence.AbstractProtectionEquipment;

public class Swordsman extends Fighter {
    private final Integer INITIAL_POINTS = 100;
    private final SwordsmanState swordsmanState;

    public Swordsman() {
        super();
        this.points = INITIAL_POINTS;
        this.attackEquipment = new Sword();
        swordsmanState = SwordsmanState.Normal;
    }

    public Swordsman(String vicious) {
        super();
        this.points = INITIAL_POINTS;
        this.attackEquipment = new Poison(new Sword());
        swordsmanState = SwordsmanState.Vicious;
    }

    public Swordsman equip(String equipmentName) {
        addWeapon(equipmentName);
        return this;
    }

    @Override
    public Integer power() {
        return attackEquipment.strike();
    }

    @Override
    protected void addWeapon(String equipmentName) {
        AbstractEquipment equipment = equipmentFactory.createEquipment(equipmentName);
        if (equipment instanceof AbstractWeapon) {
            attackEquipment = (AbstractWeapon) equipment;
            if (this.swordsmanState.equals(SwordsmanState.Vicious))
                this.attackEquipment = new Poison(this.attackEquipment);
        } else if (equipment instanceof AbstractProtectionEquipment)
            protectionEquipments.add((AbstractProtectionEquipment) equipment);
    }
}
