package adapterpattern.mediaplayer.src;

/*
* Adaptee (incompatible class)
*/
class VLCPlayer {
    public void playVLC(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }
}
