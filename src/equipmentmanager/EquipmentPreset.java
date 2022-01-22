package equipmentmanager;


import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;

//*********************************************************************************
// CLASS: EquipmentPreset
// The purpose of this class is to create equipment presets of items that the local player
// can withdraw from the bank and wield/equip
// AUTHOR: Hmm
//*********************************************************************************
public class EquipmentPreset {

    String[] equipment;

    //*********************************************************************************
    // CONSTRUCTOR: EquipmentPreset Constructor
    // Takes parameters of equipment
    // Array of strings (item names)
    //*********************************************************************************
    public EquipmentPreset(String[] equipment) {
        this.equipment = equipment;
    }

    //*********************************************************************************
    // ACCESSOR: getEquipmentPreset()
    // Gets the equipment
    //*********************************************************************************
    public String[] getEquipmentPreset() {
        return this.equipment;
    }

    //*********************************************************************************
    // MUTATOR: setEquipmentPreset()
    // Sets the equipment
    //*********************************************************************************
    public String[] setEquipmentPreset(String[] setEquipment) {
        return this.equipment = setEquipment;
    }

    //*********************************************************************************
    // VOID METHOD: withdrawEquipmentPreset()
    // Withdraws the preset items from the local player's bank
    //*********************************************************************************
    public void withdrawEquipmentPreset() {
        for (int i = 0; i < equipment.length; i++) {
            Bank.withdraw(equipment[i]);
        }
    }

    //*********************************************************************************
    // VOID METHOD: wieldEquipmentPreset()
    // Interacts with the equipment in the local player's inventory.
    //*********************************************************************************
    public void wieldEquipmentPreset() {

        if (Bank.isOpen()) {
            Bank.close();
        }

        if (Tabs.open(Tab.INVENTORY)) {
            for (int i = 0; i < equipment.length; i++) {
                String itemName = equipment[i];
                if (Inventory.contains(itemName)) {
                    Inventory.get(item -> item != null && item.getName().equals(itemName)).interact();
                }
            }
        }
    }

    //*********************************************************************************
    // RETURN METHOD: toString()
    // Neatly prints out the equipment preset information.
    //*********************************************************************************
    public String toString() {
        StringBuilder equipmentDetails = new StringBuilder();
        for (int i = 0; i < equipment.length; i++) {
            String itemName = equipment[i];
            equipmentDetails.append(itemName + " ");
        }

        return equipmentDetails.toString();
    }
}
