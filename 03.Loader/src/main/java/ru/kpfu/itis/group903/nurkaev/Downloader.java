package ru.kpfu.itis.group903.nurkaev;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author @nshamil Shamil Nurkaev
 * 11-903
 * Homework
 */

public class Downloader {

    private final List<URL> files;
    private final String folder;
    private final ExecutorService threadPool;

    public Downloader(String mode, int count, List<URL> files, String folder) {
        if (mode.equals("one-thread")) {
            threadPool = Executors.newFixedThreadPool(1);
        } else if (mode.equals("multi-thread")) {
            threadPool = Executors.newFixedThreadPool(count);;
        } else {
            throw new IllegalArgumentException("Unknown mode");
        }
        this.files = files;
        this.folder = folder;
    }

    public void download() {
        for (URL url : files) {
            String urlString = url.toString();
            String imageName = urlString.substring(urlString.lastIndexOf('/'));
            threadPool.submit(() -> {
                try (InputStream in = url.openStream();
                     FileOutputStream out = new FileOutputStream(new File(folder + imageName))) {
                    int i;
                    while ((i = in.read()) != -1) {
                        out.write(i);
                    }
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            });
        }
    }
}
