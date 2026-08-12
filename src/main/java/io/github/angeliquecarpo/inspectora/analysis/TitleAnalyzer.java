package io.github.angeliquecarpo.inspectora.analysis;
import org.jsoup.nodes.Document;

public class TitleAnalyzer {

    public String analyze(Document document){

        String title = document.select("title").first().text();

        if (document.select("title").isEmpty()){
            return "MISSING";
        }

        if (title.isBlank()){
            return "EMPTY";
        }

        int length = title.length();

        if (length < 30){
            return "TOO SHORT";
        }

        if (length > 60){
            return "TOO LONG";
        }

        return "OK";
    }
}
