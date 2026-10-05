package audio.engine;

public class HighResAudioEngine implements AudioEngine {
    @Override
    public void playSound(String input) {
        System.out.println("HighResEngine: Decoding lossless format -> " + input);
    }
}