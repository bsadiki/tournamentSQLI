package com.nespresso.sofa.recruitement.tournament.fighter.swordsman.swordsmanStae;

import com.nespresso.sofa.recruitement.tournament.equipment.attack.AbstractWeapon;
import com.nespresso.sofa.recruitement.tournament.equipment.attack.decoratorWeapon.Poison;

public class ViciousState implements SwordsmanState, ChangingWeaponState {
    @Override
    public AbstractWeapon changeWeapon(AbstractWeapon weapon) {
        return new Poison(weapon);
    }
}
