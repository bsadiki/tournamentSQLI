package com.nespresso.sofa.recruitement.tournament.equipment;
import com.nespresso.sofa.recruitement.tournament.equipment.attack.concretWeapon.Axe;
import com.nespresso.sofa.recruitement.tournament.equipment.defence.*;
public class EquipmentFactory {
    public static AbstractEquipment createEquipment(String equipment){
        switch (equipment){
            case "buckler" : return new Buckler();
            case "armor" : return new Armor();
            case "axe" : return new Axe();
        }
        return null;
    }
}
