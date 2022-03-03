package Utility.webnodeadder;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.methods.walking.web.node.CustomWebPath;

public class WebNodeAdder {

    Tile[] customWebPathOne = {
            new Tile(3327, 4754, 0),
            new Tile(3328, 4764, 0),
            new Tile(3328, 4772, 0),
            new Tile(3328, 4779, 0),
            new Tile(3328, 4786, 0),
            new Tile(3328, 4796, 0),
            new Tile(3328, 4801, 0)
    };

    Tile[] customWebPathTwo = {
            new Tile(3327, 4755, 0),
            new Tile(3324, 4763, 0),
            new Tile(3319, 4773, 0),
            new Tile(3313, 4783, 0),
            new Tile(3318, 4796, 0),
            new Tile(3318, 4800, 0),
            new Tile(3318, 4807, 0),
            new Tile(3329, 4803, 0)
    };

    public CustomWebPath selectRandomWebNode() {
        CustomWebPath webPath = new CustomWebPath(customWebPathOne);
        return webPath;
    }

    public void addWebPath() {
        Walking.getWebPathFinder().addCustomWebPath(selectRandomWebNode());
    }
}
