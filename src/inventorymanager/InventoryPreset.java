package inventorymanager;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;

import java.util.ArrayList;

//*********************************************************************************
// CLASS: InventoryPreset
// The purpose of this class is to create a preset of items that the local player
// can withdraw from the bank.
//*********************************************************************************
public class InventoryPreset {

    private ArrayList<String> itemName = new ArrayList<String>();
    private String[] inventoryItemArray = new String[28];
    private int[] inventoryQuantityArray = new int[28];

    //*********************************************************************************
    // CONSTRUCTOR: InventoryPreset Constructor
    // Takes parameters of inventoryItemArray and inventoryQuantityArray
    // One array is used to retrieve items and the other is used to get the quantity of items
    //*********************************************************************************
    public InventoryPreset(String[] inventoryItemArray, int[] inventoryQuantityArray) {
        this.inventoryItemArray = inventoryItemArray;
        this.inventoryQuantityArray = inventoryQuantityArray;
    }

    //*********************************************************************************
    // ACCESSOR: getInventoryArray()
    // Gets the inventoryItemArray
    //*********************************************************************************
    public String[] getInventoryArray() {
        return this.inventoryItemArray;
    }

    //*********************************************************************************
    // MUTATOR: getInventoryArray()
    // Sets the inventoryItemArray
    //*********************************************************************************
    public void setInventoryArray(String[] setInventoryArray) {
        this.inventoryItemArray = setInventoryArray;
    }

    //*********************************************************************************
    // ACCESSOR: getInventoryQuantityArray()
    // Gets the getInventoryQuantityArray
    //*********************************************************************************
    public int[] getInventoryQuantityArray() {
        return this.inventoryQuantityArray;
    }

    //*********************************************************************************
    // MUTATOR: setInventoryQuantityArray()
    // Sets the inventoryItemArray
    //*********************************************************************************
    public void setInventoryQuantityArray(int[] setInventoryQuantityArray) {
        this.inventoryQuantityArray = setInventoryQuantityArray;
    }

    //*********************************************************************************
    // VOID METHOD: withdrawPresetInventory()
    // Withdraws the preset items from the local player's bank
    //*********************************************************************************
    public void withdrawPresetInventory() {
        for (int i = 0; i < inventoryItemArray.length; i++) {
            String itemName = inventoryItemArray[i];
            int itemQuantity = inventoryQuantityArray[i];
            Bank.withdraw(itemName, itemQuantity);
            MethodProvider.sleepUntil(() -> Inventory.contains(itemName) && Inventory.count(itemName) == itemQuantity, 6000);
        }
    }

    //*********************************************************************************
    // RETURN METHOD: toString()
    // Neatly prints out the preset information.
    //*********************************************************************************
    public String toString() {
        StringBuilder inventoryDetails = new StringBuilder();
        for (int i = 0; i < inventoryItemArray.length; i++) {
            String itemName = inventoryItemArray[i];
            int itemQuantity = inventoryQuantityArray[i];
            inventoryDetails.append("Slot " + i + " ").append( "[" + itemName + " " + itemQuantity + "]").append(" ");
        }

        return inventoryDetails.toString();
    }

}
