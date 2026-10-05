package audio.adapter;

import audio.engine.AudioEngine;
import audio.exception.AudioPlayerException;
import audio.thirdparty.vlc.ThirdPartyVlcLibrary;
import audio.thirdparty.vlc.VlcLibraryException;

public class VlcEngineAdapter implements AudioEngine {
    private ThirdPartyVlcLibrary vlcLibrary;

    public VlcEngineAdapter(ThirdPartyVlcLibrary vlcLibrary) {
        this.vlcLibrary = vlcLibrary;
    }

    @Override
    public void playSound(String input) throws AudioPlayerException {
        try {
            vlcLibrary.startNetworkStream(input, true);
        } catch (VlcLibraryException e) {
            throw new AudioPlayerException("Playback failed: " + e.getMessage());
        }
    }
}