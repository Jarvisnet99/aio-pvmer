package Utility.autocastmanager;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.wrappers.widgets.WidgetChild;


public class Autocast {

    public static void openChooseSpell() {
        WidgetChild autoCastInterface = Widgets.getChildWidget(201, 2);
        if (!widgetChecker(autoCastInterface)) {
            if (Tabs.open(Tab.COMBAT)) {
                WidgetChild chooseSpell = Widgets.getChildWidget(593, 26);
                if (chooseSpell.interact()) {
                    MethodProvider.sleepUntil(() -> widgetChecker(autoCastInterface) == true, 6000);
                }
            }
        }
    }

    public static boolean widgetChecker(WidgetChild widgetChild) {
        return widgetChild != null && widgetChild.isVisible();
    }

    public static void clearAutocastSpell() {
        openChooseSpell();
        WidgetChild cancel = Widgets.getWidgetChild(201, 1, 0);
        if (PlayerSettings.getBitValue(276) != 0) {
            cancel.interact();
        }
    }

    public static void selectAutocastSpell(WidgetChild spell) {
        if (PlayerSettings.getBitValue(276) == 0) {
            spell.interact();
        }
    }
}
