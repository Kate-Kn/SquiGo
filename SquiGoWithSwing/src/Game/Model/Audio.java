package Model;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import java.util.HashMap;
import java.util.Map;

public class Audio {

    public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
    public static Map<String, Music> musicMap = new HashMap<String, Music>();

    public static void loadmusic() {
        try {
            soundMap.put("menu_sound", new Sound("resources/music/trialclick.ogg"));
            musicMap.put("music_menu", new Music("resources/music/menu.ogg"));
            musicMap.put("music_game", new Music ("resources/music/game.ogg"));
            soundMap.put("nut", new Sound("resources/music/nutsound.ogg"));
            soundMap.put("shop_s", new Sound("resources/music/shop_s.ogg"));

        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
public static Music getMusic(String key){
        return musicMap.get(key);
}
public static Sound getSound(String key){
        return soundMap.get(key);
}

}
