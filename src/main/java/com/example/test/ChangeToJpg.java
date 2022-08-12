package com.example.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

public class ChangeToJpg {
    static long startTime = System.currentTimeMillis ();

    public static void change(String[] args) {
        logTime("start.");
        try (PDDocument doc = PDDocument.load(new File("/Users/USERNAME/Desktop/java/demo/src/resources/73d6b5795c7ebc1a38589608bad049fc.jpeg"), MemoryUsageSetting.setupTempFileOnly())) {
          int i = 0;
          PDFRenderer pdfRenderer = new PDFRenderer(doc);
          for (PDPage page : doc.getPages()) {
            logTime("renderImageWithDPI start.");
            BufferedImage image = pdfRenderer.renderImageWithDPI(i, 300, ImageType.RGB);
            logTime("renderImageWithDPI end.");
            ImageIOUtil.writeImage(image, String.format("%03d.jpg", i++), 300);
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
        logTime("end.");
      }
    
      public static void logTime (String msg) {
        long now = System.currentTimeMillis ();
        System.out.println (String.format ("%.3f ms: %s", (now - startTime) / 1000.0, msg));
        startTime = now;
      }
    
}
