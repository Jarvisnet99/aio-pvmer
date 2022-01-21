import framework.Module;
import inventorymanager.InventoryPresetLoader;
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

        currentModule.addTask(i);

    }

    @Override
    public int onLoop() {
        return currentModule.execute();
    }
}
