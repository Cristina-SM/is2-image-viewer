package software.ulpgc.imageViewer.io;

import software.ulpgc.imageViewer.model.Image;

import java.io.File;
import java.io.FileFilter;

public class FileImageLoader implements ImageLoader {
    private final File[] imgFiles;

    public FileImageLoader(File directory) {
        this.imgFiles = directory.listFiles(fileTypes());
    }

    private static FileFilter fileTypes() {
        return pathname -> pathname.getName().toLowerCase().endsWith(".jpg")
                || pathname.getName().toLowerCase().endsWith("png");
    }

    public Image imageAt(int i) {
        assert imgFiles != null;
        return new Image() {
            @Override
            public String id() {
                return imgFiles[i].getAbsolutePath();
            }

            @Override
            public Image next() {
                return imageAt((i + 1) % imgFiles.length);
            }

            @Override
            public Image prev() {
                return imageAt((i - 1 + imgFiles.length) % imgFiles.length);
            }
        };
    }

    @Override
    public Image load() {
        return imageAt(0);
    }
}
