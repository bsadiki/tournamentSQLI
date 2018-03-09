package com.nespresso.sofa.recruitement.tournament.fighter.highlander.highlanderState;

import com.nespresso.sofa.recruitement.tournament.fighter.highlander.Highlander;

import static com.nespresso.sofa.recruitement.tournament.fighter.highlander.highlanderState.StateConfig.BERSERK;

public class VeterenState implements HighlanderState, ChangedState {
    @Override
    public void changeState(Highlander highlander) {
        if (highlander.getPointsRatio() < 30)
            highlander.changeState(BERSERK);
    }
}
