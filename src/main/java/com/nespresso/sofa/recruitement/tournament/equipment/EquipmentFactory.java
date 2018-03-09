package com.nespresso.sofa.recruitement.tournament.equipment;
import com.nespresso.sofa.recruitement.tournament.equipment.attack.concretWeapon.Axe;
import com.nespresso.sofa.recruitement.tournament.equipment.defence.*;

import static com.nespresso.sofa.recruitement.tournament.equipment.EquipmentConfig.*;

public class EquipmentFactory {
    public static AbstractEquipment createEquipment(String equipment){
        switch (equipment){
            case BUCKLER : return new Buckler();
            case ARMOR : return new Armor();
            case AXE : return new Axe();
        }
        return null;
    }
}
