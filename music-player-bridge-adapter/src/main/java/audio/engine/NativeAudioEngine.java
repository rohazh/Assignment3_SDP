package audio.engine;

public class NativeAudioEngine implements AudioEngine {
    @Override
    public void playSound(String input) {
        System.out.println("NativeEngine: Playing local file -> " + input);
    }
}