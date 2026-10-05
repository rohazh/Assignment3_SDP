package audio.app;

import audio.adapter.VlcEngineAdapter;
import audio.engine.AudioEngine;
import audio.engine.HighResAudioEngine;
import audio.engine.NativeAudioEngine;
import audio.thirdparty.vlc.ThirdPartyVlcLibrary;

public class AudioEngineSelector {
    public static AudioEngine selectEngineForInput(String input) {
        if (input.startsWith("http") || input.startsWith("ftp")) {
            return new VlcEngineAdapter(new ThirdPartyVlcLibrary());
        } else if (input.endsWith(".flac") || input.endsWith(".wav")) {
            return new HighResAudioEngine();
        } else {
            return new NativeAudioEngine();
        }
    }
}