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

    public static void selectAutocastSpell(String spellName, int varbit) {
        if (PlayerSettings.getBitValue(276) != varbit) {
            openChooseSpell();
            WidgetChild spell = Widgets.getMatchingWidget(w -> w != null && w.hasAction(spellName));
            spell.interact();
        }
    }
}
