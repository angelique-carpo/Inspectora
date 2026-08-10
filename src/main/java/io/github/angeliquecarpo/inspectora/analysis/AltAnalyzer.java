package io.github.angeliquecarpo.inspectora.analysis;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class AltAnalyzer {

    public String analyze(Document document){

        int imageCount = document.select("img").size();

        if (imageCount == 0){
            return "NO IMAGES";
        }

        for (Element image : document.select("img")){

            if (image.attr("alt").isBlank()){
                return "MISSING";
            }
        }
        return "OK";
    }
}
