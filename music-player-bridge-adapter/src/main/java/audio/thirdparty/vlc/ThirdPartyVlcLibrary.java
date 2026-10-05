package audio.thirdparty.vlc;

public class ThirdPartyVlcLibrary {
    public void startNetworkStream(String url, boolean isLive) throws VlcLibraryException {
        if (!url.startsWith("http") && !url.startsWith("ftp")) {
            throw new VlcLibraryException("VLC Error 400: Invalid network stream URL.");
        }
        System.out.println("VLC: Streaming from " + url + " (Live: " + isLive + ")");
    }
}