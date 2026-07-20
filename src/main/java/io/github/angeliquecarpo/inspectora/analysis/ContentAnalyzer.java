package io.github.angeliquecarpo.inspectora.analysis;

import org.jsoup.nodes.Document;

public class ContentAnalyzer {

    private void removeLayoutElements(Document document) {
        document.select("header").remove();
        document.select("footer").remove();
        document.select("nav").remove();
        document.select("aside").remove();
        document.select("script").remove();
        document.select("style").remove();
        document.select("no-script").remove();
    }

    public int countWords(Document document){
        removeLayoutElements(document);
        String text = document.body().text();
        System.out.println("--------------------------------");
        System.out.println(text);
        System.out.println("--------------------------------");
        String[] words = text.split("\\s+");
        return words.length;
    }

    public int countImages(Document document){
        return document.select("img").size();
    }

    public String getPageStatus(int wordCount, int imageCount) {

        if (wordCount <= 20) {
            return "EMPTY";
        }

        if (wordCount <= 100) {
            return "VERY THIN";
        }

        if (wordCount <= 180) {
            return "THIN CONTENT";
        }

        return "OK";
    }
}
