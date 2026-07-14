package io.github.angeliquecarpo.inspectora.analysis;

import org.jsoup.nodes.Document;

public class ContentAnalyzer {
    public int countWords(Document document){

        String text = document.body().text();
        String[] words = text.split("\\s+");
        return words.length;
    }

    public int countImages(Document document){
        return document.select("img").size();
    }

    public String getPageStatus(int wordCount, int imageCount) {
        if (wordCount <= 50)
         return "EMPTY";

        if (wordCount <= 200)
            return "THIN CONTENT";
        String ok = "OK";
        return ok;
    }
}
