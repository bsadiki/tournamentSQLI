package com.nespresso.sofa.recruitement.tournament.equipment.attack.concretWeapon;

public class GreatSword extends AbstractConcreteWeapon {
    Integer counter;

    public GreatSword() {
        this.counter = 0;
    }

    @Override
    public Integer strike() {
        counter++;
        if(counter % 3 != 0) {
            return 12;
        }
        else return null;
    }
}
