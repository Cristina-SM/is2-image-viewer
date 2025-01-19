package software.ulpgc.imageViewer;

import software.ulpgc.imageViewer.app.swing.MainFrame;
import software.ulpgc.imageViewer.control.ImagePresenter;
import software.ulpgc.imageViewer.io.FileImageLoader;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File directory = new File("src/main/resources");
        FileImageLoader loader = new FileImageLoader(directory);
        MainFrame mainFrame = new MainFrame();
        ImagePresenter presenter = new ImagePresenter(mainFrame.getImageDisplay());
        presenter.show(loader.load());
        mainFrame.setVisible(true);
    }
}
