package adapterpattern.mediaplayer.src;

public class Main {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        player.play("mp3", "song.mp3");
        player.play("vlc", "video.vlc");
        player.play("mp4", "movie.mp4");
    }
}
