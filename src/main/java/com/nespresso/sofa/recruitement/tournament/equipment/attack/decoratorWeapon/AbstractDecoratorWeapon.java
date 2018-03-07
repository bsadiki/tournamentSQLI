package com.nespresso.sofa.recruitement.tournament.equipment.attack.decoratorWeapon;

import com.nespresso.sofa.recruitement.tournament.equipment.attack.AbstractWeapon;

public abstract class AbstractDecoratorWeapon extends AbstractWeapon {
    protected AbstractWeapon abstractWeapon;

    public AbstractDecoratorWeapon(AbstractWeapon abstractWeapon) {
        this.abstractWeapon = abstractWeapon;
    }
}
