import Utility.autocastmanager.Autocast;
import Utility.autocastmanager.VarbitForSpells;
import Utility.frameworkmanager.Module;
import Utility.minigameteleportmanager.MinigameTeleporter;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.wrappers.widgets.WidgetChild;

@ScriptManifest(author = "Hmm", category = Category.MISC, name = "AIO PvMer", version = 0.01)
public class Main extends AbstractScript {

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
        Autocast.selectAutocastSpell("Fire Strike", VarbitForSpells.FIRE_STRIKE.getVarbit());
        return 1000;
    }
}
