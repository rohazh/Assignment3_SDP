package audio.player;

import audio.engine.AudioEngine;
import audio.exception.AudioPlayerException;

public class MiniPlayer extends MusicPlayer {
    public MiniPlayer(AudioEngine engine) { super(engine); }

    @Override
    public void play(String input) {
        System.out.println("\n[MiniPlayer] Minimal UI mode...");
        try {
            engine.playSound(input);
        } catch (AudioPlayerException e) {
            System.err.println("[MiniPlayer] Error: " + e.getMessage());
        }
    }
}