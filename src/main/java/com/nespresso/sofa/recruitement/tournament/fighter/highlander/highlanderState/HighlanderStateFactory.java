package com.nespresso.sofa.recruitement.tournament.fighter.highlander.highlanderState;

import static com.nespresso.sofa.recruitement.tournament.fighter.highlander.highlanderState.StateConfig.*;

public class HighlanderStateFactory {
    public static HighlanderState createState(String stateName){
        switch (stateName){
            case NORMAL : return new NomalState();
            case BERSERK : return new BerserkState();
            case VETERAN : return new VeterenState();
        }
        return null;
    }
}
