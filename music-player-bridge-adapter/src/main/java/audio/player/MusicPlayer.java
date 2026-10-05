package audio.player;
import audio.engine.AudioEngine;

public abstract class MusicPlayer {
    protected AudioEngine engine;

    public MusicPlayer(AudioEngine engine) {
        this.engine = engine;
    }
    public abstract void play(String input);
}