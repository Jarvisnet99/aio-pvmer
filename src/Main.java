
import Utility.autocastmanager.Autocast;
import Utility.autocastmanager.VarbitForSpells;
import Utility.minigameteleportmanager.MinigameTeleporter;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.wrappers.widgets.WidgetChild;

@ScriptManifest(author = "HMM", category = Category.MISC, name = "F2P", version = 0.02)
public class Main extends AbstractScript {
    private static final int SCOLLBARPARENT = 76; //Parent of the activity selection panel's scrollbar.
    private static final int SCOLLBARCHILD = 19; //Child of the activity selection panel's scrollbar.
    private static final int SCOLLBARGRANDCHILD = 1; //Grandchild of the activity selection panel's scrollbar.

    @Override
    public void onStart() {
    }

    @Override
    public int onLoop() {

        MinigameTeleporter.teleportMinigame("Clan Wars");


        return 1000;
    }

}
