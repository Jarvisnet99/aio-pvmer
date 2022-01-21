package inventorymanager;

import framework.Task;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.wrappers.items.Item;

import java.util.ArrayList;
import java.util.List;

public class InventoryPresetLoader implements Task {

    private ArrayList<String> itemName = new ArrayList<String>();
    private ArrayList<Integer> itemQuantity = new ArrayList<Integer>();

    @Override
    public boolean validate() {

        return !Inventory.isFull();

    }

    @Override
    public int execute() {

        if (Bank.openClosest()) {

        } else {

            return 500;

        }
        setInventoryPreset(new String[]{"Staff of fire", "Death rune"});


        return 1000;

    }

    public void setInventoryPreset(String itemName[]) {

        for (String item : itemName) {
            Bank.withdraw(item);
        }

    }
}
