package Utility.prayermanager;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.prayer.Prayer;
import org.dreambot.api.methods.prayer.Prayers;
import org.dreambot.api.wrappers.widgets.WidgetChild;

//*********************************************************************************
// CLASS: PrayerPreset
// The purpose of this class is to create a prayer preset of prayers that the local player
// can activate
// AUTHOR: Hmm
//*********************************************************************************

public class PrayerPreset {

    private Prayer[] prayers;

    //*********************************************************************************
    // CONSTRUCTOR: InventoryPreset Constructor
    // Takes parameters of prayers
    // This array is used to activate prayers
    //*********************************************************************************
    public PrayerPreset(Prayer[] prayers) {
        this.prayers = prayers;
    }

    //*********************************************************************************
    // ACCESSOR: getPrayerPreset()
    // Gets the prayers array
    //*********************************************************************************
    public Prayer[] getPrayerPreset() {
        return this.prayers;
    }

    //*********************************************************************************
    // MUTATOR: setPrayerPreset()
    // Sets the prayers
    //*********************************************************************************
    public void setPrayerPreset(Prayer[] prayers) {
        this.prayers = prayers;
    }

    //*********************************************************************************
    // BOOLEAN METHOD: widgetChecker()
    // Checks if widgetChild is available.
    //*********************************************************************************
    public static boolean widgetChecker(WidgetChild widgetChild) {
        return widgetChild != null && widgetChild.isVisible();
    }

    //*********************************************************************************
    // VOID METHOD: activatePrayerPreset()
    // Enables all prayers in the prayer array
    //*********************************************************************************
    public void activatePrayerPreset() {
        disableCurrentActivePrayers();
        for (Prayer prayer : prayers) {
            if (!Prayers.isActive(prayer)) {
                Prayers.toggle(true, prayer);
                MethodProvider.sleepUntil(() -> Prayers.isActive(prayer), 6000);
            }
        }
    }

    //*********************************************************************************
    // VOID METHOD: disableCurrentActivePrayers()
    // Disables all prayers that are currently active
    //*********************************************************************************
    public void disableCurrentActivePrayers() {
        Prayer[] currentActivePrayers = Prayers.getActive();
        for (Prayer prayer : currentActivePrayers) {
            Prayers.toggle(false, prayer);
            MethodProvider.sleepUntil(() -> !Prayers.isActive(prayer), 6000);
        }
    }

}
