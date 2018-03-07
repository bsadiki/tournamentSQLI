package com.nespresso.sofa.recruitement.tournament.equipment.attack.decoratorWeapon;

import com.nespresso.sofa.recruitement.tournament.equipment.attack.AbstractWeapon;

public class Poison extends AbstractDecoratorWeapon {
    Integer poisonEffect;

    public Poison(AbstractWeapon abstractWeapon) {
        super(abstractWeapon);
        poisonEffect = 2;
    }

    @Override
    public Integer strike() {
        if (poisonEffect > 0) {
            poisonEffect--;
            return 20 + abstractWeapon.strike();
        }
        return abstractWeapon.strike();
    }
}
