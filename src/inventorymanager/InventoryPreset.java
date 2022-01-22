package inventorymanager;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;

import java.util.ArrayList;

public class InventoryPreset {

    private ArrayList<String> itemName = new ArrayList<String>();
    private String[] inventoryItemArray = new String[28];
    private int[] inventoryQuantityArray = new int[28];

    public InventoryPreset(String[] inventoryItemArray, int[] inventoryQuantityArray) {
        this.inventoryItemArray = inventoryItemArray;
        this.inventoryQuantityArray = inventoryQuantityArray;
    }

    public String[] getInventoryArray() {
        return this.inventoryItemArray;
    }

    public void setInventoryArray(String[] setInventoryArray) {
        this.inventoryItemArray = setInventoryArray;
    }

    public int[] getInventoryQuantityArray() {
        return this.inventoryQuantityArray;
    }

    public void setInventoryQuantityArray(int[] setInventoryQuantityArray) {
        this.inventoryQuantityArray = setInventoryQuantityArray;
    }

    public int getInventoryArrayLength() {
        return inventoryItemArray.length;
    }

    public void withdrawPresetInventory() {
        for (int i = 0; i < inventoryItemArray.length; i++) {
            String itemName = inventoryItemArray[i];
            int itemQuantity = inventoryQuantityArray[i];
            Bank.withdraw(itemName, itemQuantity);
            MethodProvider.sleepUntil(() -> Inventory.contains(itemName) && Inventory.count(itemName) == itemQuantity, 6000);
        }
    }

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
