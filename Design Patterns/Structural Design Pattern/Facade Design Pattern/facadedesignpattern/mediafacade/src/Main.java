package facadedesignpattern.mediafacade.src;

import facadedesignpattern.mediafacade.src.mediaplayer.MediaFacade;

public class Main {
    public static void main(String[] args) {
        MediaFacade mediaFacade = new MediaFacade();
        mediaFacade.playMovie();
    }
}
