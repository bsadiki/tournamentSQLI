package com.nespresso.sofa.recruitement.tournament.equipment.defence;

import com.nespresso.sofa.recruitement.tournament.equipment.attack.AbstractWeapon;
import com.nespresso.sofa.recruitement.tournament.equipment.attack.concretWeapon.Axe;

import java.util.Iterator;
import java.util.List;

public class ProtectionEquipmentHandler {
    public Integer reduceDamage(List<AbstractProtectionEquipment> holdenProtectionEquipments, AbstractWeapon weapon, Integer strikeDamage){
        Integer reducedDamage = strikeDamage;
        Iterator<AbstractProtectionEquipment> protectionEquipmentIterator = holdenProtectionEquipments.listIterator();
        while (protectionEquipmentIterator.hasNext()){
            AbstractProtectionEquipment current = protectionEquipmentIterator.next();
            if (current instanceof Buckler) {
                Buckler buckler = (Buckler) current;
                reducedDamage = buckler.reduceDamage(reducedDamage, weapon);
                if(noAttackIsReceived(reducedDamage))
                    return null;
                if(!buckler.canBeUsed())
                    protectionEquipmentIterator.remove();
            }
            else if(current instanceof Armor){
                Armor armor = (Armor) current;
                reducedDamage = armor.reduceDamage(reducedDamage,weapon);
            }
        }
        return Math.max(0,reducedDamage);
    }
    private boolean noAttackIsReceived(Integer reducedDamaged){
        return reducedDamaged == null;
    }
}
