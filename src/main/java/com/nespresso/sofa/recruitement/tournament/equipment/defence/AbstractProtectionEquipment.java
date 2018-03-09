package com.nespresso.sofa.recruitement.tournament.equipment.defence;

import com.nespresso.sofa.recruitement.tournament.equipment.AbstractEquipment;
import com.nespresso.sofa.recruitement.tournament.equipment.attack.AbstractWeapon;

public abstract class AbstractProtectionEquipment extends AbstractEquipment{
    public abstract Integer reduceDamage(Integer strikePower, AbstractWeapon attackingWeapon);
}
