package com.nespresso.sofa.recruitement.tournament.equipment.defence;


import com.nespresso.sofa.recruitement.tournament.equipment.attack.AbstractWeapon;
import com.nespresso.sofa.recruitement.tournament.equipment.attack.concretWeapon.Axe;

public class Buckler extends AbstractProtectionEquipment {
    private Integer strikesToBeDestroyed;
    private boolean hasCanceledDamage;

    public Buckler() {
        strikesToBeDestroyed = 3;
        hasCanceledDamage = false;
    }

    @Override
    public Integer reduceDamage(Integer strikePower, AbstractWeapon attackingWeapon) {
        if(!hasCanceledDamage){
            hasCanceledDamage =true;
            if(attackingWeapon instanceof Axe)
                reduceStrikesToBeDestroyed();
            return null;
        }else {
            hasCanceledDamage = false;
            return strikePower;
        }
    }
    private void reduceStrikesToBeDestroyed(){
        strikesToBeDestroyed--;
    }
    public boolean canBeUsed(){
        return (strikesToBeDestroyed>0);
    }
}
