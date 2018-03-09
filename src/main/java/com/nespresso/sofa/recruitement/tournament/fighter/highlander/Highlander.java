package com.nespresso.sofa.recruitement.tournament.fighter.highlander;

import com.nespresso.sofa.recruitement.tournament.equipment.attack.AbstractWeapon;
import com.nespresso.sofa.recruitement.tournament.equipment.attack.concretWeapon.GreatSword;
import com.nespresso.sofa.recruitement.tournament.fighter.Fighter;
import com.nespresso.sofa.recruitement.tournament.fighter.highlander.highlanderState.BerserkState;
import com.nespresso.sofa.recruitement.tournament.fighter.highlander.highlanderState.ChangedState;
import com.nespresso.sofa.recruitement.tournament.fighter.highlander.highlanderState.HighlanderStateFactory;
import com.nespresso.sofa.recruitement.tournament.fighter.highlander.highlanderState.HighlanderState;

import static com.nespresso.sofa.recruitement.tournament.fighter.highlander.highlanderState.StateConfig.*;

public class Highlander extends Fighter {
    private final Integer INITIAL_POINTS = 150;
    private HighlanderState state;
    public Highlander() {
        super();
        this.points = INITIAL_POINTS;
        this.attackEquipment = new GreatSword();
        state = HighlanderStateFactory.createState(NORMAL);
    }

    public Highlander(String stateName) {
        super();
        this.points = INITIAL_POINTS;
        this.attackEquipment = new GreatSword();
        state = HighlanderStateFactory.createState(stateName);
    }

    @Override
    public Integer power() {
        Integer equipmentStrike = attackEquipment.strike();
        if (state instanceof BerserkState){
            if(equipmentStrike!=null)
                return equipmentStrike*2;
        }
        return equipmentStrike;
    }

    @Override
    protected void takeDamage(AbstractWeapon weapon, Integer strikeDamage) {
        super.takeDamage(weapon, strikeDamage);
        if (state instanceof ChangedState)
            updateState();
    }
    private void updateState(){
        ((ChangedState) state).changeState(this);
    }
    public Integer getPointsRatio(){
        return (100 * this.points) / this.INITIAL_POINTS;
    }

    public void changeState(String stateName) {
        this.state = HighlanderStateFactory.createState(stateName);
    }
}
