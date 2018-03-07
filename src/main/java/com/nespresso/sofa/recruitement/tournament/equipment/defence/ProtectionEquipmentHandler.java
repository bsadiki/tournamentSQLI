package com.nespresso.sofa.recruitement.tournament.equipment.defence;

import com.nespresso.sofa.recruitement.tournament.equipment.attack.AbstractWeapon;
import com.nespresso.sofa.recruitement.tournament.equipment.attack.concretWeapon.Axe;

import java.util.List;

public class ProtectionEquipmentHandler {
    public Integer reduceDamage(List<AbstractProtectionEquipment> holdenProtectionEquipments, AbstractWeapon weapon, Integer strikeDamage){
        Integer reducedDamage = strikeDamage;
        AbstractProtectionEquipment bucklerToDestroy = null;
        for(AbstractProtectionEquipment holdenProtectionEquipment : holdenProtectionEquipments) {
            if (holdenProtectionEquipment instanceof Buckler) {
                Buckler buckler = (Buckler) holdenProtectionEquipment;
                reducedDamage = buckler.reduceDamage(reducedDamage);
                if(noAttackIsReceived(reducedDamage))
                    return null;
                if(weapon instanceof Axe)
                    buckler.reduceStrikesToBeDestroyed();
                if(!buckler.canBeUsed())
                    bucklerToDestroy = holdenProtectionEquipment;
            }
            else if(holdenProtectionEquipment instanceof Armor){
                Armor armor = (Armor) holdenProtectionEquipment;
                reducedDamage = armor.reduceDamage(reducedDamage);
            }
        }
        holdenProtectionEquipments.remove(bucklerToDestroy);
        return zeroIfNegative(reducedDamage);
    }
    private Integer zeroIfNegative(Integer reducedDamage){
        if(reducedDamage < 0)
            return 0;
        return reducedDamage;
    }
    private boolean noAttackIsReceived(Integer reducedDamaged){
        return reducedDamaged == null;
    }
}
