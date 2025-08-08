package adapterpattern.mediaplayer.src;

/*
* Target interface (what a client wants)
*/
public interface MediaPlayer {
    void play(String audioType, String fileName);
}
