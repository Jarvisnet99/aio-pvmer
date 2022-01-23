package Utility.minigameteleportmanager;

import org.dreambot.api.input.Mouse;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import static org.dreambot.api.Client.getLocalPlayer;

public class MinigameTeleporter {


    public static void openMinigameTab() {
        if (Tabs.open(Tab.CLAN)) {
            WidgetChild groupingTab = Widgets.getWidgetChild(707, 6, 3);
            WidgetChild clanTab = Widgets.getChildWidget(164, 37);

            if (groupingTab != null) {
                if (!clanTab.getActions()[0].equals("Grouping")) {
                    groupingTab.interact();
                    MethodProvider.sleepUntil(() -> clanTab.getActions()[0].equals("Grouping"), 6000);
                }
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

            if (Mouse.move(activityPanel.getRectangle()) && !activityPanel.getRectangle().contains(nameOfMinigame.getRectangle())) {
                Mouse.scrollDownUntil(1000, () -> activityPanel.getRectangle().contains(nameOfMinigame.getRectangle()));
            }

            if (nameOfMinigame.interact()) {
                MethodProvider.sleepUntil(() -> activitySelect.getText().equals(minigameName), 1000);
            }

        } else if (activitySelect.getText().equals(minigameName) && !getLocalPlayer().isAnimating()) {
            if (teleportButton.interact()) {
                MethodProvider.sleepUntil(() -> !getLocalPlayer().isAnimating(), 15000);
            }
        }
    }
}
