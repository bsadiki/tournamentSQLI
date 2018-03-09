package com.nespresso.sofa.recruitement.tournament.fighter.swordsman;

import com.nespresso.sofa.recruitement.tournament.equipment.AbstractEquipment;
import com.nespresso.sofa.recruitement.tournament.equipment.EquipmentFactory;
import com.nespresso.sofa.recruitement.tournament.equipment.attack.AbstractWeapon;
import com.nespresso.sofa.recruitement.tournament.equipment.attack.concretWeapon.Sword;
import com.nespresso.sofa.recruitement.tournament.equipment.defence.AbstractProtectionEquipment;
import com.nespresso.sofa.recruitement.tournament.fighter.Fighter;
import com.nespresso.sofa.recruitement.tournament.fighter.swordsman.swordsmanStae.ChangingWeaponState;
import com.nespresso.sofa.recruitement.tournament.fighter.swordsman.swordsmanStae.SwordsmanState;
import com.nespresso.sofa.recruitement.tournament.fighter.swordsman.swordsmanStae.SwordsmanStateFactory;
import static com.nespresso.sofa.recruitement.tournament.fighter.swordsman.swordsmanStae.StateConfig.*;

public class Swordsman extends Fighter {
    private final Integer INITIAL_POINTS = 100;
    private SwordsmanState state;

    public Swordsman() {
        super();
        this.points = INITIAL_POINTS;
        this.attackEquipment = new Sword();
        state = SwordsmanStateFactory.createState(NORMAL);
    }

    public Swordsman(String stateName) {
        super();
        this.points = INITIAL_POINTS;
        state = SwordsmanStateFactory.createState(stateName);
        updateWeapon();
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
        AbstractEquipment equipment = EquipmentFactory.createEquipment(equipmentName);
        if (equipment instanceof AbstractWeapon) {
            attackEquipment = (AbstractWeapon) equipment;
            updateWeapon();
        } else if (equipment instanceof AbstractProtectionEquipment)
            protectionEquipments.add((AbstractProtectionEquipment) equipment);
    }

    private void updateWeapon(){
        if(this.state instanceof ChangingWeaponState)
            this.attackEquipment = ((ChangingWeaponState) state).changeWeapon(this.attackEquipment);
    }
}
