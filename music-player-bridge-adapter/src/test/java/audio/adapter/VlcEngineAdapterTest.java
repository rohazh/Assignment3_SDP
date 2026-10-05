package audio.adapter;

import audio.exception.AudioPlayerException;
import audio.thirdparty.vlc.ThirdPartyVlcLibrary;
import audio.thirdparty.vlc.VlcLibraryException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VlcEngineAdapterTest {
    @Mock private ThirdPartyVlcLibrary mockVlcLibrary;

    @Test
    void playSound_translatesVlcExceptionToAudioPlayerException() throws VlcLibraryException {
        VlcEngineAdapter adapter = new VlcEngineAdapter(mockVlcLibrary);
        String badUrl = "invalid_scheme://test";
        
        doThrow(new VlcLibraryException("Invalid stream URL."))
                .when(mockVlcLibrary).startNetworkStream(badUrl, true);

        assertThrows(AudioPlayerException.class, () -> adapter.playSound(badUrl));
    }

    @Test
    void playSound_delegatesSuccessfullyWithoutErrors() throws VlcLibraryException {
        VlcEngineAdapter adapter = new VlcEngineAdapter(mockVlcLibrary);
        String validUrl = "http://live.stream.com";

        assertDoesNotThrow(() -> adapter.playSound(validUrl));
        verify(mockVlcLibrary, times(1)).startNetworkStream(validUrl, true);
    }
}