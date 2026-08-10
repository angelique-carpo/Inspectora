package io.github.angeliquecarpo.inspectora.analysis;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MetaDescriptionAnalyzer {

    public String analyze(Document document){

        Element metaDescription = document.select("meta[name=description]").first();

        if (metaDescription == null){
            return "MISSING";
        }

        if (metaDescription.attr("content").isBlank()){
            return "EMPTY";
        }

        return "OK";
    }
}
