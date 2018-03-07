package com.nespresso.sofa.recruitement.tournament.equipment.defence;


public class Buckler extends AbstractProtectionEquipment {
    private Integer strikesToBeDestroyed;
    private boolean hasConceledDamage;

    public Buckler() {
        strikesToBeDestroyed = 3;
        hasConceledDamage = false;
    }

    @Override
    public Integer reduceDamage(Integer strikePower) {
        if(!hasConceledDamage){
            hasConceledDamage =true;
            return null;
        }else {
            hasConceledDamage = false;
            return strikePower;
        }
    }
    void reduceStrikesToBeDestroyed(){
        strikesToBeDestroyed--;
    }
    public boolean canBeUsed(){
        return (strikesToBeDestroyed>0);
    }
}
