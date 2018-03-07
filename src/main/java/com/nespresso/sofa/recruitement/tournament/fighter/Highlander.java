package com.nespresso.sofa.recruitement.tournament.fighter;

import com.nespresso.sofa.recruitement.tournament.equipment.attack.AbstractWeapon;
import com.nespresso.sofa.recruitement.tournament.equipment.attack.concretWeapon.GreatSword;

public class Highlander extends Fighter {
    private final Integer INITIAL_POINTS = 150;
    HighlanderState state;

    public Highlander() {
        super();
        this.points = INITIAL_POINTS;
        this.attackEquipment = new GreatSword();
        state = HighlanderState.NORMAL;
    }

    public Highlander(String veteran) {
        super();
        this.points = INITIAL_POINTS;
        this.attackEquipment = new GreatSword();
        state = HighlanderState.VETEREN;
    }

    @Override
    public Integer power() {
        if (state.equals(HighlanderState.BERSEK)){
            Integer equipmentStrike = attackEquipment.strike();
            if(equipmentStrike!=null)
                return equipmentStrike*2;
        }
        return attackEquipment.strike();
    }

    @Override
    protected void takeDamage(AbstractWeapon weapon, Integer strikeDamage) {
        super.takeDamage(weapon, strikeDamage);
        if (state.equals(HighlanderState.VETEREN))
            if ((100 * points) / INITIAL_POINTS < 30)
                state = HighlanderState.BERSEK;
    }
}
