package audio.player;

import audio.engine.AudioEngine;
import audio.exception.AudioPlayerException;

public class SmartPlayer extends MusicPlayer {
    public SmartPlayer(AudioEngine engine) { super(engine); }

    @Override
    public void play(String input) {
        System.out.println("\n[SmartPlayer] Preparing UI, fetching metadata...");
        try {
            engine.playSound(input);
        } catch (AudioPlayerException e) {
            System.err.println("[SmartPlayer] Alert: " + e.getMessage());
        }
    }
}