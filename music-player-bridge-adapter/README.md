# Music Player (Bridge + Adapter Patterns)
## Design Rationale Document

**Problem Domain:** 
An audio player system needing to support various UI representations (MiniPlayer, SmartPlayer) and playback engines (Native OS, High-Res, and a 3rd-party VLC network library).

**Why Bridge alone is not enough:** 
Bridge separates player abstractions from engines. However, the 3rd-party VLC library does not implement our `AudioEngine` interface, has a different method signature, and throws specific exceptions. Bridge alone cannot integrate this library.

**Why Adapter alone is not enough:** 
Adapter makes VLC compatible, but without Bridge, we would have to subclass every player type with every engine (e.g., `MiniPlayerVlc`, `SmartPlayerNative`), leading to a combinatorial explosion of classes. 

**Why the wrapped implementation is genuinely incompatible:** 
`ThirdPartyVlcLibrary` requires a network URL, an additional boolean flag (`isLive`), and throws a specific checked exception (`VlcLibraryException`) different from our `AudioPlayerException`.

**Complexity Module Chosen:** Dynamic implementor selection.
