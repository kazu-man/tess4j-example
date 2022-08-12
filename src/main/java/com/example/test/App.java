package com.example.test;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

//画像から文字を取得する
public class App {
    private static final String FILE_PATH = "/Users/USERNAME/work/java/Tess4JDemo/demo/src/resources/";
    private static final String TEST_DATA_PATH = "/usr/local/Cellar/tesseract/5.1.0/share/tessdata";
    public static void main(String[] args) {
        // File imageFile = new File(FILE_PATH + "number.png");
        File imageFile = new File(FILE_PATH + "73d6b5795c7ebc1a38589608bad049fc.jpeg");
        
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
        instance.setDatapath(TEST_DATA_PATH); // path to tessdata directory
        instance.setLanguage("jpn+eng+snum+osd+jpn_vert");
        // instance.setVariable("tessedit_char_whitelist", "中村");
        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}