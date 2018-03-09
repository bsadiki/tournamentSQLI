package com.nespresso.sofa.recruitement.tournament.equipment.defence;

import com.nespresso.sofa.recruitement.tournament.equipment.attack.AbstractWeapon;

public class Armor extends AbstractProtectionEquipment {
    @Override
    public Integer reduceDamage(Integer strikePower, AbstractWeapon attackingWeapon) {
        return strikePower - 3;
    }

    public Integer reduceOwnerPower(Integer strikePower) {
        return strikePower - 1;
    }
}
