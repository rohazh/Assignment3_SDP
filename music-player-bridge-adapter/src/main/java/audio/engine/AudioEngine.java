package audio.engine;
import audio.exception.AudioPlayerException;

public interface AudioEngine {
    void playSound(String input) throws AudioPlayerException;
}