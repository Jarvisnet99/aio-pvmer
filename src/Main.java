import equipmentmanager.EquipmentPreset;
import framework.Module;
import inventorymanager.InventoryPresetLoader;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

@ScriptManifest(author = "Hmm", category = Category.MISC, name = "AIO PvMer", version = 0.01)
public class Main extends AbstractScript {
    InventoryPresetLoader i = new InventoryPresetLoader();

    private Module currentModule = new Module() {
        @Override
        public boolean validate() {
            return !getLocalPlayer().isMoving();
        }
    };

    @Override
    public void onStart() {


    }

    @Override
    public int onLoop() {
        String[] d = {"Black wizard hat (g)", "Team-29 cape", "Amulet of power"};
        int[] slots = {EquipmentSlot.AMULET.getSlot()};
        EquipmentPreset eq = new EquipmentPreset(d);
        eq.withdrawEquipmentPreset();
        eq.wieldEquipmentPreset();
        return 1000;
    }
}
