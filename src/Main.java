
import Utility.minigameteleportmanager.MinigameTeleporter;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.emotes.Emote;
import org.dreambot.api.methods.emotes.Emotes;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.wrappers.widgets.WidgetChild;

@ScriptManifest(author = "HMM", category = Category.MISC, name = "F2P PvPer", version = 0.01)
public class Main extends AbstractScript {

    @Override
    public void onStart() {
    }

    @Override
    public int onLoop() {
        MinigameTeleporter.openMinigameTab();
        MinigameTeleporter.teleportMinigame("Clan Wars");

        return 100;
    }
}
