package com.nespresso.sofa.recruitement.tournament.fighter.swordsman.swordsmanStae;

import static com.nespresso.sofa.recruitement.tournament.fighter.swordsman.swordsmanStae.StateConfig.*;

public class SwordsmanStateFactory {
    public static SwordsmanState createState(String stateName){
        switch (stateName){
            case NORMAL : return new NormalState();
            case VICIOUS : return new ViciousState();
        }
        return null;
    }
}
