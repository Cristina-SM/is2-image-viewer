package software.ulpgc.imageViewer.model;

public interface Image {
    String id();
    Image next();
    Image prev();
}
