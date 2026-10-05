package audio.app;

import audio.engine.AudioEngine;
import audio.player.MusicPlayer;
import audio.player.SmartPlayer;
import audio.player.MiniPlayer;

public class Main {
    public static void main(String[] args) {
        String[] playlist = {
            "track01.mp3",          
            "symphony.flac",        
            "http://radio.com/live",
            "invalid_scheme://test" 
        };

        for (int i = 0; i < playlist.length; i++) {
            String track = playlist[i];
            AudioEngine engine = AudioEngineSelector.selectEngineForInput(track);
            MusicPlayer player = (i % 2 == 0) ? new SmartPlayer(engine) : new MiniPlayer(engine);
            player.play(track);
        }
    }
}