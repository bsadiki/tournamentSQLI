package com.nespresso.sofa.recruitement.tournament.equipment.defence;

public class Armor extends AbstractProtectionEquipment {
    @Override
    public Integer reduceDamage(Integer strikePower) {
        return strikePower - 3;
    }

    public Integer reduceOwnerPower(Integer strikePower) {
        return strikePower - 1;
    }
}
