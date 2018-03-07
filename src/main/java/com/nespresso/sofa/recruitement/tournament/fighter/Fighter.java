package com.nespresso.sofa.recruitement.tournament.fighter;

import com.nespresso.sofa.recruitement.tournament.equipment.AbstractEquipment;
import com.nespresso.sofa.recruitement.tournament.equipment.EquipmentFactory;
import com.nespresso.sofa.recruitement.tournament.equipment.attack.AbstractWeapon;
import com.nespresso.sofa.recruitement.tournament.equipment.defence.AbstractProtectionEquipment;
import com.nespresso.sofa.recruitement.tournament.equipment.defence.Armor;
import com.nespresso.sofa.recruitement.tournament.equipment.defence.ProtectionEquipmentHandler;

import java.util.ArrayList;
import java.util.List;

public abstract class Fighter {
    private EquipmentFactory equipmentFactory;
    protected Integer points;
    protected List<AbstractProtectionEquipment> protectionEquipments;
    protected AbstractWeapon attackEquipment;
    private ProtectionEquipmentHandler protectionEquipmentHandler;
    public Fighter() {
        equipmentFactory = new EquipmentFactory();
        protectionEquipments = new ArrayList<>();
        protectionEquipmentHandler = new ProtectionEquipmentHandler();
    }

    public Integer hitPoints() {
        return this.points;
    }

    public void engage(Fighter fighter) {
        while (this.isAlive() && fighter.isAlive()) {
            this.hitFighter(fighter);
            if (fighter.isAlive()) {
                fighter.hitFighter(this);
            }
        }
    }

    protected void addWeapon(String equipmentName) {
        AbstractEquipment equipment = equipmentFactory.createEquipment(equipmentName);
        if (equipment instanceof AbstractWeapon)
            attackEquipment = (AbstractWeapon) equipment;
        else if (equipment instanceof AbstractProtectionEquipment)
            protectionEquipments.add((AbstractProtectionEquipment) equipment);
    }

    public Integer strike(){
        Integer power = power();
        for(AbstractProtectionEquipment protectionEquipment : protectionEquipments){
            if(protectionEquipment instanceof Armor)
                power = ((Armor) protectionEquipment).reduceOwnerPower(power);
        }
        return power;
    }

    protected void takeDamage(AbstractWeapon weapon, Integer strikeDamage){
        Integer reducedDamage = protectionEquipmentHandler.reduceDamage(protectionEquipments,weapon,strikeDamage);
        if(reducedDamage!=null)
            this.points -= reducedDamage;
        zeroIfNegative();
    }


    private boolean isAlive() {
        return (this.points > 0);
    }

    private void hitFighter(Fighter fighter) {
        Integer attack = this.strike();
        if (attack != null) fighter.takeDamage(attackEquipment,attack);
    }

    private void zeroIfNegative(){
        if(points <= 0)
            points = 0;
    }
    public abstract Integer power();
}

