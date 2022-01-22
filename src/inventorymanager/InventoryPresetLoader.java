package inventorymanager;

import framework.Task;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.wrappers.items.Item;

import java.lang.reflect.Method;
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

        String[] array = new String[]{"Death rune", "Mind rune", "Air rune"};
        int[] quantity = new int[] {100, 100, 2};

        InventoryPreset ip = new InventoryPreset(array, quantity);
        //p.withdrawPresetInventory();
        MethodProvider.log(ip.toString());


        return 1000;

    }

}
