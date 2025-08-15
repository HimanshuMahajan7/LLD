package facadedesignpattern.mediafacade.src.mediaplayer;

public class MediaFacade {
    private AudioPlayer audioPlayer;
    private VideoPlayer videoPlayer;
    private SubtitleService subtitleService;

    public MediaFacade() {
        audioPlayer = new AudioPlayer();
        videoPlayer = new VideoPlayer();
        subtitleService = new SubtitleService();
    }

    public void playMovie() {
        audioPlayer.playAudio();
        videoPlayer.playVideo();
        subtitleService.loadSubtitles();
        System.out.println("Movie started successfully!");
    }
}
