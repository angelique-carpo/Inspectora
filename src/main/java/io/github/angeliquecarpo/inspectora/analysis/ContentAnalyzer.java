package io.github.angeliquecarpo.inspectora.analysis;

import org.jsoup.nodes.Document;

public class ContentAnalyzer {
    public int countWords(Document document){

        String text = document.body().text();
        String[] words = text.split("\\s+");
        return words.length;
    }
}
