package Utility.highscoremanager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Highscores {

    ArrayList<String> stats = new ArrayList<String>();

    public Highscores(String playerName) {
        getPlayerStats(playerName);
    }

    public int getLevel(MySkills skill) {
        try {
            int index = skill.getLevelIndex();
            String[] array = stats.get(index).split(",");
            // MethodProvider.log("Stats index : "  + stats.get(index) );

            return Integer.parseInt(array[1]);
        }catch (Exception e){
            return 1;
        }

    }

    public int getExperience(MySkills skill) {
        int index = skill.getLevelIndex();
        String[] array = stats.get(index).split(",");
        return Integer.parseInt(array[2]);
    }

    private void getPlayerStats(final String playerName) {
        try {
            URL url = new URL("https://secure.runescape.com/m=hiscore_oldschool/index_lite.ws?player=" + playerName);
            URLConnection connection = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                stats.add(inputLine);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}