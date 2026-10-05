package audio.player;

import audio.engine.AudioEngine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MusicPlayerTest {
    @Mock private AudioEngine mockEngine;

    @Test
    void smartPlayer_delegatesPlayCallToEngine() {
        MusicPlayer player = new SmartPlayer(mockEngine);
        player.play("song.mp3");
        verify(mockEngine, times(1)).playSound("song.mp3");
    }

    @Test
    void miniPlayer_delegatesPlayCallToEngine() {
        MusicPlayer player = new MiniPlayer(mockEngine);
        player.play("podcast.wav");
        verify(mockEngine, times(1)).playSound("podcast.wav");
    }
}