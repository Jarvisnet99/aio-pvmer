package Utility.minigameteleportmanager;

import org.dreambot.api.input.Mouse;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import static org.dreambot.api.Client.getLocalPlayer;

public class MinigameTeleporter {


    public static void openMinigameTab() {
        final int CLANTABBITVALUE = 3;
        if (Tabs.open(Tab.CLAN)) {
            if (PlayerSettings.getBitValue(13071) != CLANTABBITVALUE) {
                WidgetChild groupingTab = Widgets.getWidgetChild(707, 6, 3);
                groupingTab.interact();
                MethodProvider.sleepUntil(() -> PlayerSettings.getBitValue(13071) == CLANTABBITVALUE, Calculations.random(2500, 5000));
            }
        }
    }

    public static void teleportMinigame(String minigameName) {
        WidgetChild activitySelect = Widgets.getWidgetChild(76, 8);
        WidgetChild activityPanel = Widgets.getWidgetChild(76, 18);
        WidgetChild teleportButton = Widgets.getMatchingWidget(widget -> widget != null && widget.getText().equals("Teleport"));

        if (!activitySelect.getText().equals(minigameName)) {
            if (activitySelect != null && !activityPanel.isVisible()) {
                activitySelect.interact();
            }

            WidgetChild nameOfMinigame = Widgets.getMatchingWidget(w -> w != null && w.getText().equals(minigameName));
            WidgetChild scrollBar = Widgets.getWidgetChild(76, 19, 1);
            MethodProvider.log(scrollBar.getRectangle().getY());

            if (Mouse.move(activityPanel.getRectangle()) && scrollBar.getRectangle().getY() != 246.0) {
                Mouse.scrollUpUntil(1000, () -> scrollBar.getRectangle().getY() == 246.0);
                MethodProvider.sleepUntil(() -> scrollBar.getRectangle().getY() == 246, 5000);
            }

            if (scrollBar.getRectangle().getY() == 246 &&
                    Mouse.move(activityPanel.getRectangle()) &&
                    !activityPanel.getRectangle().contains(nameOfMinigame.getRectangle())) {
                Mouse.scrollDownUntil(1000, () -> activityPanel.getRectangle().contains(nameOfMinigame.getRectangle()));
            }

            if (nameOfMinigame.interact()) {
                MethodProvider.sleepUntil(() -> activitySelect.getText().equals(minigameName), 1500);
            }

        } else if (activitySelect.getText().equals(minigameName) && !getLocalPlayer().isAnimating()) {
            if (teleportButton.interact()) {
                MethodProvider.sleepUntil(() -> !getLocalPlayer().isAnimating(), 15000);
            }
        }
    }
}
